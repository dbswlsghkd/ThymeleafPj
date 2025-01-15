package org.example.thymeleafpj.repository;

import lombok.AllArgsConstructor;
import org.example.thymeleafpj.entity.Study_record;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class StudyRecordRepoTest {
    @Autowired
    StudyRecordRepo studyRecordRepo;

    @Test
    public void testSelectAll(){
        // List<Study_record> list = studyRecordRepo.findAll();
        //
        // for(Study_record study_record : list){
        //     System.out.println(study_record.getKey_id());
        //     System.out.println(study_record.getStudy_day());
        //     System.out.println(study_record.getContents());
        //     System.out.println(study_record.getReg_day());
        //
        // }
    }
}