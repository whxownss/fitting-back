package com.itwill.fittingback.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.itwill.fittingback.dto.ResponseDTO;
import com.itwill.fittingback.dto.TestDTO;
import com.itwill.fittingback.model.TestEntity;
import com.itwill.fittingback.service.TestService;

import lombok.RequiredArgsConstructor;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequiredArgsConstructor
@RequestMapping("test")
public class TestController {

    private final TestService service;

    @PostMapping("/create")
	public ResponseEntity<?> createTest(@RequestBody TestDTO dto){
		String tempTestId = "hello";
		
		TestEntity entity = TestDTO.toEntity(dto);
		entity.setTestId(tempTestId);
		
		List<TestEntity> entities = service.create(entity);
	
		System.out.println();
		System.out.println("무창푸시중");

		return response(entities);
	}
	
	@GetMapping("/select")
	public ResponseEntity<?> selectTest(){
		String tempTestId = "muchang";
		
		List<TestEntity> entities = service.select(tempTestId);
		
		System.out.println("=============");
		System.out.println(entities);
		System.out.println("=============");
		
		System.out.println("123");

		return response(entities);
	}
	
	@GetMapping("/mybatisTest")
	public String mybatisTest(@RequestParam(value = "num", required = false) String num){
		System.out.println(num);
		return "name : " + service.getTest(num);
	}


    public static ResponseEntity<?> response(List<TestEntity> entities) {
		List<TestDTO> dtos = entities.stream().map(TestDTO::new).collect(Collectors.toList());
		ResponseDTO<TestDTO> res = ResponseDTO.<TestDTO>builder().data(dtos).build();
		return ResponseEntity.ok().body(res);
	}
}
