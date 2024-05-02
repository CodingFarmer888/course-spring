package com.course.lifecycle;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class LifeCycleMain {

	public static void main(String[] args) {

		System.out.println("ApplicationContext 要被new了");
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(LifeCycleConfig.class);
		
		System.out.println("===== Do Something =====");
		System.out.println("ApplicationContext 要被Close了");
		ctx.close();
	}

}
