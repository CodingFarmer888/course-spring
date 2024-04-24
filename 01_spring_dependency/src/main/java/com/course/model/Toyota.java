package com.course.model;

public class Toyota {

	// 1. 創建物件
	// ToyotaEngine engine = new ToyotaEngine();
	
	// 抽換引擎，需要改變Toyota類別本身
	BenzEngine engine = new BenzEngine();
	
	public void move() {
		// Toyota要能夠移動，必須要有可以啟動的引擎
		engine.start();
		
		System.out.println("Toyota移動");
	}
}
