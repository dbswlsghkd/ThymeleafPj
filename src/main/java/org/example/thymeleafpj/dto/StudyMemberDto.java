package org.example.thymeleafpj.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.example.thymeleafpj.entity.Study_member;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@ToString
public class StudyMemberDto {

    private int memberId;
    private String loginId;
    private String password;
    private String name;
    private String role;
    private LocalDateTime regDay;
    private String email;

    public static StudyMemberDto createStudyMemberDto(Study_member study_member) {
        return new StudyMemberDto(
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
