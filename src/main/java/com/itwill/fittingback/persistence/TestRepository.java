package com.itwill.fittingback.persistence;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.itwill.fittingback.model.TestEntity;

public interface TestRepository extends JpaRepository<TestEntity, String>{
	
	// 메서드명과 필드명이 일치해야함 (낙타표기)
	List<TestEntity> findByTestId(String testId);
	
}
