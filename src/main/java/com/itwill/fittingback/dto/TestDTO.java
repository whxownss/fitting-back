package com.itwill.fittingback.dto;

import com.itwill.fittingback.model.TestEntity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

// DTO는 클라이언트 (사용자)에게 DB구조를 숨기고 실제로 "보여주기" 위한 데이터를 담는 용도
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class TestDTO {
	private String testId;	   
	private String testPass;
	private String testName;
	
	// DB에서 select 해온 데이터 (Entity) 중
	// 사용자에게 보여줄 데이터만 추출해서 저장하는 생성자 작성
	public TestDTO(TestEntity entity) {
		this.testId = entity.getTestId();
		this.testPass = entity.getTestPass();
		this.testName = entity.getTestName();
	}
	
	// READ 제외한 경우에 사용?
	public static TestEntity toEntity(final TestDTO dto) {
		return TestEntity.builder()
						 .testId(dto.getTestId())
						 .testPass(dto.getTestPass())
						 .testName(dto.getTestName())
						 .build();
	}
}
