package com.course;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
		
		// Logger
		System.out.println("============= Logger ===============");
		
		Logger logger = LoggerFactory.getLogger(Application.class);
		logger.trace("我是trace");
		logger.debug("我是debug");
		logger.info("我是info");
		logger.warn("我是warn");
		logger.error("我是error");
	}

}
