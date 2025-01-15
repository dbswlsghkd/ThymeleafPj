package org.example.thymeleafpj.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.thymeleafpj.entity.Study_member;
import org.example.thymeleafpj.mapper.StudyMemberMapper;
import org.example.thymeleafpj.repository.StudyMemberRepo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class StudyMemberService {

    private final StudyMemberRepo studyMemberRepo;
    private final StudyMemberMapper studyMemberMapper;

    public Page<Study_member> doSelectAll(Pageable pageable){
        // return studyMemberRepo.findAll();
        return studyMemberMapper.findAll(pageable);
    }

    public Study_member doSelectById(int member_id){
        return studyMemberRepo.findById(member_id).get();
    }

    public void doInesert(Study_member study_member){
        studyMemberRepo.save(study_member);
    }

    public void doUpdate(Study_member study_member){
        studyMemberRepo.save(study_member);
    }

    public void doDelete(int member_id){
        studyMemberRepo.deleteById(member_id);
    }

}
