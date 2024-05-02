package com.course.scope;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "com.course.scope")
public class BeanConfig {

	
	@Bean("bean1")
	public SingletonBean bean1() {
		return new SingletonBean();
	}
	
	@Bean("bean2")
	public SingletonBean bean2() {
		return new SingletonBean();
	}

}
