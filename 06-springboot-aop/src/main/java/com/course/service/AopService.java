package com.course.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.course.aspect.AopAspect;

@Service
public class AopService {

	// 日誌記錄器
	Logger logger = LoggerFactory.getLogger(AopAspect.class);
	
	public void serviceMethodOne() {
		logger.info("我是被切的方法 AopService.serviceMethodOne()");
	}
	
	
	public String serviceMethodWithReturn() {
		logger.info("我是被切的方法 AopService.serviceMethodWithReturn()");
		return "serviceMethodWithReturn的回傳值";
	}
	
	public String serviceMethodWithException() {
		logger.info("我是被切的方法 AopService.serviceMethodWithException()");
		// 觸發例外
		Integer.parseInt("abc");
		return "serviceMethodWithException的回傳值";
	}
}
