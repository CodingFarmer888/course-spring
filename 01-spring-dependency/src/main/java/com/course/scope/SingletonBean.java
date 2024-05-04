package com.course.scope;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
// 默認單例作用域，不宣告就是Singleton
@Scope(ConfigurableBeanFactory.SCOPE_SINGLETON)
public class SingletonBean {

	public SingletonBean() {
		System.out.println("單例Bean 建構式");
	}
}
