package org.example.thymeleafpj.service;

import lombok.RequiredArgsConstructor;
import org.example.thymeleafpj.entity.Study_record;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

// @RequiredArgsConstructor
@SpringBootTest
class StudyRecordServiceTest {

    @Autowired
    private StudyRecordService studyRecordService;
    // private final StudyRecordService studyRecordService;

    @Test
    void doSelectOne() {

    }

    @Test
    void doInsert() {
        Study_record study_record = Study_record.builder()
                .study_day("2025-01-12")
                .contents("Test Insert")
                .reg_day(LocalDateTime.now())
                .build();

        studyRecordService.doInsert(study_record);
    }

    @Test
    void doUpdate() {
        // 전체를 다 수정하는 방법
        // Study_record study_record = new Study_record();
        // study_record.setKey_id(3);
        // study_record.setStudy_day("2025-01-15");
        // study_record.setContents("Test Insert");
        // study_record.setReg_day(LocalDateTime.now());

        // 부분만 수정 하는 방법
        Study_record allStudy = studyRecordService.doSelectOne(3);

        allStudy.setStudy_day("2025-01-16");

        studyRecordService.doUpdate(allStudy);
    }

    @Test
    // 기존 데이터를 삭제하면 안되고 테스트가 되는지 확인하는 방법
    // @Transactional
    void doDelete() {
        studyRecordService.doDelete(3);
    }
}