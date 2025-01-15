package org.example.thymeleafpj.repository;

import org.example.thymeleafpj.entity.Study_member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudyMemberRepo extends JpaRepository<Study_member, Integer> {

}
