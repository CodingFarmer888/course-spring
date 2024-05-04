package com.course;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.course.model.BenzCar;
import com.course.model.BmwCar;
import com.course.model.TeslaCar;

public class SpringMain {

	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("spring.xml");
//		Toyota car = ctx.getBean("toyota", Toyota.class);
//		car.move();
		
		System.out.println("=======================");
		
		BmwCar bmw = ctx.getBean("bmw",BmwCar.class);
		bmw.move();
		System.out.println(bmw.getPrice());
		
		System.out.println("=======================");
			
		BenzCar benz = ctx.getBean("benz",BenzCar.class);
		benz.move();
		System.out.println(benz.getPrice());
		
		System.out.println("=======================");
		
		TeslaCar tesla = ctx.getBean("tesla",TeslaCar.class);
		tesla.move();
		System.out.println(tesla.getPrice());

	}

}
