package com.course.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.course.model.BenzCar;
import com.course.model.BenzEngine;
import com.course.model.BmwCar;

// 宣告為配置類
@Configuration
public class CarConfiguration {

	// 宣告為Bean
	@Bean
	public BmwCar bmw() {
		return new BmwCar(new BenzEngine());
	}
	
	@Bean(name = {"ford"})
	public BenzCar benz() {
		return new BenzCar();
	}
}
