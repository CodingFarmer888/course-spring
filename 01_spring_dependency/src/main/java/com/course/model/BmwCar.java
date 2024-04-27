package com.course.model;

public class BmwCar {
	
	private int price;
	
	private Engine engine;
	
	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		System.out.println("BmwCar setPrice");
		this.price = price;
	}
	
	public Engine getEngine() {
		return engine;
	}

	public BmwCar() {
		System.out.println("BmwCar建構式");
	}

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
