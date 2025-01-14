package org.example.thymeleafpj.entity;

import jakarta.persistence.*;
import lombok.*;

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
    @Column(updatable = false)  // 첫 생성 시에만 값을 넣도록 설정
    private LocalDateTime reg_day;
    private String email;

    @PrePersist
    protected void prePersist() {
        if (this.reg_day == null) {
            this.reg_day = LocalDateTime.now();  // 현재 시간을 설정
        }
    }

}
