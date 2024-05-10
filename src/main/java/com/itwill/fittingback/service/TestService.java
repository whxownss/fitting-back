package com.itwill.fittingback.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.itwill.fittingback.mapper.TestMapper;
import com.itwill.fittingback.model.TestEntity;
import com.itwill.fittingback.persistence.TestRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@RequiredArgsConstructor
public class TestService {

    private final TestRepository repository;
    private final TestMapper mapper;

    public String getTest(String num) {
		return mapper.selectByNum(num); 
	}
	
	public List<TestEntity> select(final String testId) {
		return repository.findByTestId(testId);
	}

	public List<TestEntity> create(TestEntity entity) {
		repository.save(entity);
		log.info("Entity id : {} 가 저장됨.", entity.getTestId());
		
		return select(entity.getTestId());
	}
}
