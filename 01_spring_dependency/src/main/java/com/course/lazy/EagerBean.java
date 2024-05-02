package com.course.lazy;

import org.springframework.stereotype.Component;

@Component
// 就是默認的Bean
public class EagerBean {

	public EagerBean() {
		System.out.println("EagerBean 建構式");
	}
}
