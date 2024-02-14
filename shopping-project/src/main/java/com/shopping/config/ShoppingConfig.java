package com.shopping.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.annotation.SessionScope;

import com.shopping.model.CartInfo;

@Configuration
public class ShoppingConfig {
	
	@Bean
	@SessionScope
	CartInfo cartInSession() {
		return new CartInfo();
	}

}
