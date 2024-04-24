package com.course.model;

public class BmwCar {
	Engine engine;
	
	// 建構式注入 Constructor Injection
	public BmwCar(Engine engine) {
		this.engine = engine;
	}
	
	// Setter注入 Setter Injection
	public void setEngine(Engine engine) {
		this.engine = engine;
	}

	public void move() {
		engine.start();
		
		System.out.println("BMW 移動中");
	}
}
