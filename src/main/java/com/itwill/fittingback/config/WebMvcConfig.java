package com.itwill.fittingback.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration // 스프링 빈 등록
public class WebMvcConfig implements WebMvcConfigurer {
	private final long MAX_AGE_SECS = 3600;
	
	@Override
	public void addCorsMappings(CorsRegistry registry) {
		// 모든 경로에 대해
		// Origin이 htpp://localhost:3000인 경우
		// GET POST ... OPTIONS 메서드를 이용한 요청을 허용한다.
		// 또한 모든 헤더와 인증에 관한 정보도 허용
		// 클라이언트가 응답을 캐시할 수 있는 시간 3600으로 설정
		registry.addMapping("/**")
			.allowedOrigins("http://localhost:3000")
			.allowedMethods("GET", "POST", "PUT", "DELETE", "PATCH", "OPTIONS")
			.allowedHeaders("*")
			.allowCredentials(true)
			.maxAge(MAX_AGE_SECS);
		
		/*
		 * < HTTP 메서드 종류 >
		 * GET, POST, DELETE, PUT, PATCH, HEAD, TRACE, OPTIONS, CONNECT 
		 * 
		 * GET		: 데이터 가져오기 (select)
		 * POST		: 데이터 새로생성 (insert)
		 * DELETE	: 데이터 삭제 (delete)
		 * PUT		: 데이터 수정 (전체)
		 * PATCH	: 데이터 수정 (부분)
		 * */
	}

}
