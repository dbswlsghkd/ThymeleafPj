package org.example.thymeleafpj.mapper;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.thymeleafpj.entity.Study_member;
import org.example.thymeleafpj.entity.Study_record;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
@Slf4j
@RequiredArgsConstructor
public class StudyRecordMapper {

    private final SqlSessionTemplate sqlsessionTemplate;

    public Page<Study_record> findAll(Pageable pageable) {
        // log.info("안에 들어와요?");
        // 페이징 파라미터 생성
        Map<String, Object> params = new HashMap<>();
        params.put("offset", pageable.getPageNumber() * pageable.getPageSize());
        params.put("pageSize", pageable.getPageSize());

        log.info("findBySearch 쿼리 실행 전에 도달했습니다");
        // 데이터 조회
        List<Study_record> studyRecords = sqlsessionTemplate.selectList("com.example.ThymeleafPj.mapper.StudyRecordMapper.findAll", params);
        log.info("findBySearch 쿼리 실행 후 결과: {}", studyRecords);;
        // 전체 개수 조회
        int total = sqlsessionTemplate.selectOne("com.example.ThymeleafPj.mapper.StudyRecordMapper.countStRecords", params);

        // Page 객체로 변환
        return new PageImpl<>(studyRecords, pageable, total);
    }
}
