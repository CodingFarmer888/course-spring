package com.course;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.course.configuration.CarConfiguration;
import com.course.model.BenzCar;
import com.course.model.BmwCar;

public class ConfigurationMain {

	public static void main(String[] args) {
		ApplicationContext ctx = new AnnotationConfigApplicationContext(CarConfiguration.class);

		BmwCar bwm = (BmwCar)ctx.getBean("bmw");
		bwm.move();

		BenzCar benz = ctx.getBean(BenzCar.class);
		
		BenzCar ford = (BenzCar)ctx.getBean("ford");
	}

}
