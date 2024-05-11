package com.course;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.course.model.BenzCar;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		ApplicationContext ctx = SpringApplication.run(Application.class, args);
		for (String name : ctx.getBeanDefinitionNames()) {
			System.out.println("Bean name: " + name);
		}
		
		BenzCar benz = ctx.getBean(BenzCar.class);
		benz.move();
	}

}
