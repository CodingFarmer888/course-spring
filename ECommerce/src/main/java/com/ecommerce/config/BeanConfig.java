package com.ecommerce.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.annotation.SessionScope;

import com.ecommerce.model.sessionbean.LoginCustomer;

@Configuration
public class BeanConfig {

	@Bean
	@SessionScope
	LoginCustomer getSessionCustomer() {
		return new LoginCustomer();
	}
}
