package com.itwill.fittingback.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

// TodoDTO 뿐만아니라 다른 DTO클래스 또한 ResponseDTO를 사용할 수 있도록 Generic 사용
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class ResponseDTO<T> {
	private String error;
	private List<T> data;
}
