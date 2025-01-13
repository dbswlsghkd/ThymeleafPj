package org.example.thymeleafpj.service;

import lombok.RequiredArgsConstructor;
import org.example.thymeleafpj.entity.Study_record;
import org.example.thymeleafpj.repository.StudyRecordRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
// @RequiredArgsConstructor
public class StudyRecordService {

    private final StudyRecordRepo studyRecordRepo;

    @Autowired
    public StudyRecordService(StudyRecordRepo studyRecordRepo) {
        this.studyRecordRepo = studyRecordRepo;
    }

    public List<Study_record> doSelectAll(){
        return studyRecordRepo.findAll();
    }
    // select
    public Study_record doSelectOne(int key_id){
        return studyRecordRepo.findById(key_id).get();
    }
    // Insert
    public void doInsert(Study_record study_record){
        studyRecordRepo.save(study_record);
    }
    // update
    public void doUpdate(Study_record study_record){
        studyRecordRepo.save(study_record);
    }
    // delete
    public void doDelete(int key_id){
        studyRecordRepo.deleteById(key_id);
    }
}
