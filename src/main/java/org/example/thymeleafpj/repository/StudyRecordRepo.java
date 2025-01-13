package org.example.thymeleafpj.repository;

import org.example.thymeleafpj.entity.Study_record;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudyRecordRepo extends JpaRepository<Study_record, Integer> {

    
}
