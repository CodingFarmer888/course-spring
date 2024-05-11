package com.course.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BenzCar {
	private int price;
	
	@Autowired
	private Engine engine;

	public BenzCar() {
		System.out.println("BenzCar建構式");
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		System.out.println("BenzCar setPrice");
		this.price = price;
	}
	
	// Setter注入 Setter Injection
	public void setEngine(Engine engine) {
		this.engine = engine;
	}

	public Engine getEngine() {
		return engine;
	}

	public void move() {
		engine.start();
		
		System.out.println("Benz 移動中");
	}
}
