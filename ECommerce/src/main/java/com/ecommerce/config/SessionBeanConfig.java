package com.ecommerce.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.annotation.SessionScope;

import com.ecommerce.model.sessionbean.LoginCustomer;
import com.ecommerce.model.vo.Cart;

@Configuration
public class SessionBeanConfig {

	/**
	 * 顧客登入Session資料
	 * @return
	 */
	@Bean
	@SessionScope
	LoginCustomer getSessionCustomer() {
		return new LoginCustomer();
	}
	
	@Bean
	@SessionScope
	Cart getCart() {
		return new Cart();
	}
}
