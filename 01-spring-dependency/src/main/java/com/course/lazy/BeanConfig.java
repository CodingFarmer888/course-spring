package com.course.lazy;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "com.course.lazy")
public class BeanConfig {

	
//	@Bean("bean1")
//	public LazyBean bean1() {
//		return new LazyBean();
//	}
//	
//	@Bean("bean2")
//	public EagerBean eager() {
//		return new EagerBean();
//	}

}
