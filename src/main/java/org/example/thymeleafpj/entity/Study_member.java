package org.example.thymeleafpj.entity;

import jakarta.persistence.*;
import lombok.*;
import org.example.thymeleafpj.dto.StudyMemberDto;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Setter
@Getter
@ToString
@Builder
@Table(name = "study_member")
public class Study_member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "member_id")
    private int memberId;
    @Column(name = "login_id")
    private String loginId;
    private String password;
    private String name;
    private String role;
    @Column(updatable = false, name = "reg_day")  // 첫 생성 시에만 값을 넣도록 설정
    private LocalDateTime regDay;
    private String email;

    @PrePersist
    protected void prePersist() {
        if (this.regDay == null) {
            this.regDay = LocalDateTime.now();  // 현재 시간을 설정
        }
    }

    public static Study_member createStudyMember(StudyMemberDto study_member) {
        return new Study_member(
                study_member.getMemberId(),
                study_member.getLoginId(),
                study_member.getPassword(),
                study_member.getName(),
                study_member.getRole(),
                study_member.getRegDay(),
                study_member.getEmail()
        );
    }
}
