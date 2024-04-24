package com.course;

import com.course.model.BmwCar;
import com.course.model.BmwEngine;

public class InterfaceMain {

	public static void main(String[] args) {
		// Setter注入 (Setter Injection)
		// BmwCar bmw = new BmwCar();
		// bmw.setEngine(new BmwEngine());
		
		// 建構式注入 (Constructor Injection)
		BmwCar bmw = new BmwCar(new BmwEngine());
		bmw.move();

	}

}
