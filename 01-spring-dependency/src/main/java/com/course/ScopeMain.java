package com.course;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.course.scope.BeanConfig;
import com.course.scope.PrototypeBean;
import com.course.scope.SingletonBean;
import com.course.scope.SingletonObj;

public class ScopeMain {

	public static void main(String[] args) {
		ApplicationContext ctx = new AnnotationConfigApplicationContext(BeanConfig.class);
		
		System.out.println("====== Singleton 單一實例 ======");
		SingletonBean sBean = ctx.getBean("singletonBean", SingletonBean.class);
		System.out.println("sBean:" + sBean);
		
		SingletonBean sBean2 = ctx.getBean("singletonBean", SingletonBean.class);
		System.out.println("sBean2:" + sBean2);

		System.out.println("====== prototype 原型======");
		PrototypeBean pBean = ctx.getBean("prototypeBean", PrototypeBean.class);
		System.out.println("pBean:" + pBean);
		
		PrototypeBean pBean2 = ctx.getBean("prototypeBean", PrototypeBean.class);
		System.out.println("pBean2:" + pBean2);

		//		LazyBean lazyBean = ctx.getBean("lazyBean", LazyBean.class);
		
		// 相同的類別，不同名稱的Bean，會有多個實體
		SingletonBean s1 = ctx.getBean("bean1", SingletonBean.class);
		System.out.println("s1:" + s1);
		
		SingletonBean s2 = ctx.getBean("bean2", SingletonBean.class);
		System.out.println("s2:" + s2);
		
		// 設計模式當中的單一實例，只會有一個實體
		SingletonObj obj1 = SingletonObj.getInstance();
		System.out.println("obj1:" + obj1);
		
		SingletonObj obj2 = SingletonObj.getInstance();
		System.out.println("obj2:" + obj2);
		
	}

}
