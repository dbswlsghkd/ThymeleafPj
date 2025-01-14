package org.example.thymeleafpj.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.thymeleafpj.entity.Study_member;
import org.example.thymeleafpj.repository.StudyMemberRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class StudyMemberService {

    private final StudyMemberRepo studyMemberRepo;

    public List<Study_member> doSelectAll(){
        return studyMemberRepo.findAll();
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
