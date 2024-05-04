package com.course.lifecycle;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackageClasses = {LifeCycleBean.class})
public class LifeCycleConfig {

	
	@Bean("name")
	public String name() {
		return "Hello Name";
	}
}
