package com.course.lazy;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan
public class LazyMain {

	public static void main(String[] args) {
		
		ApplicationContext ctx = new AnnotationConfigApplicationContext(BeanConfig.class);
		
		System.out.println("===== Lazy =====");
		LazyBean lazy = ctx.getBean(LazyBean.class);
		lazy.sayHello();

	}

}
