package org.example.thymeleafpj.service;

import lombok.RequiredArgsConstructor;
import org.example.thymeleafpj.entity.Study_record;
import org.example.thymeleafpj.mapper.StudyRecordMapper;
import org.example.thymeleafpj.repository.StudyRecordRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor
public class StudyRecordService {

    private final StudyRecordRepo studyRecordRepo;
    private final StudyRecordMapper studyRecordMapper;


    public Page<Study_record> doSelectAll(Pageable pageable){
        // return studyRecordRepo.findAll();
        return studyRecordMapper.findAll(pageable);
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
