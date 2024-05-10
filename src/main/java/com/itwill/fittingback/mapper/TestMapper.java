package com.itwill.fittingback.mapper;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface TestMapper {
	String selectByNum(String num);
}
