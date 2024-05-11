package com.course.model;

import org.springframework.stereotype.Component;

@Component
public class BenzEngine implements Engine {
	
	public void start() {
		System.out.println("Benz引擎發動");
	}
}
