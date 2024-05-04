package com.course.model;

public class TeslaCar {
	private int price;
	
	private Engine engine;

	public TeslaCar() {
		System.out.println("Tesla建構式");
	}

	public TeslaCar(int price, Engine engine) {
		this.price = price;
		this.engine = engine;
	}
	
	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		System.out.println("Tesla setPrice");
		this.price = price;
	}
	
	public void setEngine(Engine engine) {
		this.engine = engine;
	}

	public Engine getEngine() {
		return engine;
	}

	public void move() {
		engine.start();
		
		System.out.println("Tesla 移動中");
	}
}
