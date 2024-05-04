package com.course.annotation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.course.model.Engine;

@Component
public class KiaCar {

	@Autowired
	//@Qualifier(value = "mazdaEngine")
	private Engine engine;

	public KiaCar() {
		
	}
	
	// @Autowired
	public KiaCar(Engine engine) {
		this.engine = engine;
	}

	// @Autowired
	public void setEngine(Engine engine) {
		this.engine = engine;
	}
	
	public Engine getEngine() {
		return engine;
	}
	
	public void move() {
		engine.start();
		System.out.println("KIA 移動中");
	}
	
}
