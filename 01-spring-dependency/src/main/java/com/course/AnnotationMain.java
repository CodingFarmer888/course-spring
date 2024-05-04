package com.course;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.course.annotation.AppConfig;
import com.course.annotation.KiaCar;

public class AnnotationMain {

	public static void main(String[] args) {
		ApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);
		KiaCar kia = ctx.getBean(KiaCar.class);
		kia.move();
	
	}

}
