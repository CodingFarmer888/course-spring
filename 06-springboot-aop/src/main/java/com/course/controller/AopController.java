package com.course.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.course.exception.ActionException;
import com.course.service.AopService;

@RestController
public class AopController {

	
	@Autowired
	private AopService aopService;
	
	@GetMapping("/serviceMethodOne")
	public String serviceMethodOne() {
		aopService.serviceMethodOne();
		return "serviceMethodOne";
	}
	
	@GetMapping("/serviceMethodWithReturn")
	public String serviceMethodWithReturn() {
		String result = aopService.serviceMethodWithReturn();
		return result;
	}
	
	@GetMapping("/serviceMethodWithException")
	public String serviceMethodWithException() {
		String result = aopService.serviceMethodWithException();
		return result;
	}
	
	@GetMapping("/serviceMethodWithActionException")
	public String serviceMethodWithActionException() throws ActionException {
		aopService.serviceMethodWithActionException();
		return "XXX";
	}
	
}
