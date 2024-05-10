package com.itwill.fittingback.model;

import org.hibernate.annotations.GenericGenerator;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "test")
public class TestEntity {
	@Id
	@GeneratedValue(generator = "system-uuid")
	@GenericGenerator(name = "system-uuid", strategy = "uuid")
	private String testNum;
	private String testId;	   
	private String testPass;
	private String testName; 
}
//@Table(name = "TEST"): TEST는 테이블명
//@Table을 추가하지않으면 @Entity("테이블명")
//@Entity를 추가하지 않으면 클래스명이 테이블명

//@Id: id멤버변수를 pk로 지정
//@GenericGenerator(name = "system-uuid", strategy = "uuid")
//- strategy 에 INCREMENTAL, SEQUENCE, IDENTITY 등 사용가능

//lombok 되는지 확인용 (Gradle에서 디펜던시 추가한거로는 안돼서 jar 따로 설치해야 됨)
class Test {
	public void test() {
		// @Builder
		TestEntity test = TestEntity.builder()
									.testNum("000")
									.testId("test1")
									.testPass("1234")
									.testName("테스트1")
									.build();
		
		// @NoArgsConstructor
		new TestEntity();
		
		// @AllArgsConstructor
		new TestEntity(null, null, null, null);
		
		// @Data
		// => 각 멤버변수에 get/set 메서드 및 toString() 오버라이딩 되어있음
		test.getTestId();
		test.setTestId("123");
	}
}
