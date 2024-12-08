package com.course.controller;

import java.util.Locale;
import java.util.ResourceBundle;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MessageController {

	@GetMapping("/i18n/hello")
	public String sayHello() {
		Locale locale = Locale.getDefault();
		locale = new Locale("en", "Us");
		System.out.println("locale: " + locale);
		
		ResourceBundle bundle = ResourceBundle.getBundle("message/messageResource", locale);
		String hello = bundle.getString("hello");
		return hello;
	}
}
