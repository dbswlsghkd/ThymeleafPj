package org.example.thymeleafpj.controller;


import lombok.extern.slf4j.Slf4j;
import org.example.thymeleafpj.entity.Study_record;
import org.example.thymeleafpj.service.StudyRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
@Slf4j
@Controller
@RequestMapping("/study")
public class Con_study {

    @Autowired
    StudyRecordService studyRecordService;


    @GetMapping("/list")
    public String doStudyList(Model model) {
        Pageable pageable = PageRequest.of(0, 15);
        Page<Study_record> list =  studyRecordService.doSelectAll(pageable);
        System.out.println("List: ------------->" + list); // 반환 값 확인
        model.addAttribute("list", list.getContent());
        return "study/study_list";
    }

    @GetMapping("/insert")
    public String doInsertStudy() {
        return "study/study_insert";
    }

    // insert
    @PostMapping("/insert_exe")
    public String doInsert(@ModelAttribute Study_record record) {
        // log.info("insert study: {}", record);
        // record.setReg_day(LocalDateTime.now());
        studyRecordService.doInsert(record);
        return "redirect:/study/list";
    }

    // 수정 조회
    @GetMapping("/modify")
    public String doModifyStudy(@RequestParam Integer key_id, Model model) {
        Study_record st = studyRecordService.doSelectOne(key_id);
        model.addAttribute("modify", st);
        return "/study/study_mod";
    }

    // 수정
    @PostMapping("/modify_exe")
    public String doModify(@ModelAttribute Study_record record) {
        studyRecordService.doUpdate(record);
        return "redirect:/study/list";
    }

    // 삭제
    @GetMapping("/delete")
    public String doDeleteSt(@RequestParam Integer key_id) {
        studyRecordService.doDelete(key_id);
        return "redirect:/study/list";
    }

}
