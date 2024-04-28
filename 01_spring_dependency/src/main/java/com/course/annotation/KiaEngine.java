package com.course.annotation;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import com.course.model.Engine;

@Component
@Primary
public class KiaEngine implements Engine {

	@Override
	public void start() {
		System.out.println("KIA 引擎發動");
		
	}

}
