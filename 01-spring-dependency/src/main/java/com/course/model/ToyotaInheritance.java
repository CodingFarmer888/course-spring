package com.course.model;

public class ToyotaInheritance extends ToyotaEngine {
	public void move() {
		// 車子要能夠移動，必須要有可以啟動的引擎
		// 2. 從引擎繼承的start方法
		start();
		System.out.println("(繼承)Toyota移動");
	}
}
