package com.course.annotation;

import org.springframework.stereotype.Component;

import com.course.model.Engine;

@Component
public class MazdaEngine implements Engine {

	@Override
	public void start() {
		System.out.println("馬自達 引擎發動");
		
	}

}
