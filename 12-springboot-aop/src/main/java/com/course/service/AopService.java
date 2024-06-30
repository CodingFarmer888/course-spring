package com.course.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.course.aspect.AopAspect;
import com.course.exception.ActionException;

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
	
	public void serviceMethodWithActionException() throws ActionException {
		logger.info("我是被切的方法 AopService.serviceMethodWithActionException()");
		// 觸發例外
		throw new ActionException("自定義ActionException");
	}
}
