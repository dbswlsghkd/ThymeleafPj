package org.example.thymeleafpj.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.thymeleafpj.entity.Study_member;
import org.example.thymeleafpj.service.StudyMemberService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/member")
@Slf4j
@RequiredArgsConstructor
public class Con_member {

    private final StudyMemberService studyMemberService;

    @GetMapping("/list")
    public String doMemberList(Model model) {
        log.info("doMemberList called");

        List<Study_member> stM = studyMemberService.doSelectAll();
        model.addAttribute("stM", stM);

        return "member/member_list";
    }

    @GetMapping("/insert")
    public String doMemberInsert() {
        log.info("doMemberInsert called");
        return "member/member_join";
    }

    // 회원가입
    @PostMapping("/insert_exe")
    public String doMemberInsertExe(@ModelAttribute Study_member study_member) {
        log.info("doMemberInsertExe called");
        studyMemberService.doInesert(study_member);
        return "redirect:/member/list";
    }

    @GetMapping("/delete")
    public String doMemberDelete(@RequestParam int member_id) {
        studyMemberService.doDelete(member_id);
        return "redirect:/member/list";
    }
}
