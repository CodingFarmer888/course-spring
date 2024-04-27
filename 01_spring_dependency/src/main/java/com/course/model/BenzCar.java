package com.course.model;

public class BenzCar {
	private int price;
	
	private Engine engine;

	public BenzCar() {
		System.out.println("BenzCar建構式");
	}

	// 建構式注入 Constructor Injection
	public BenzCar(int price, Engine engine) {
		this.price = price;
		this.engine = engine;
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
