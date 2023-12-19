package lab05.beanScope;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import lab05.beanScope.bean.LazyBean;
import lab05.beanScope.bean.PrototypeBean;
import lab05.beanScope.bean.SingletonBean;
import lab05.beanScope.config.BeanConfig;

public class BeanScopeMain {

	public static void main(String[] args) {

		ApplicationContext ctx = new AnnotationConfigApplicationContext(BeanConfig.class);
		
		System.out.println("====== Singleton ======");
		SingletonBean sBean = ctx.getBean("singletonBean", SingletonBean.class);
		System.out.println("sBean:" + sBean);
		
		SingletonBean sBean2 = ctx.getBean("singletonBean", SingletonBean.class);
		System.out.println("sBean2:" + sBean2);

		System.out.println("====== prototype ======");
		PrototypeBean pBean = ctx.getBean("prototypeBean", PrototypeBean.class);
		System.out.println("pBean:" + pBean);
		
		PrototypeBean pBean2 = ctx.getBean("prototypeBean", PrototypeBean.class);
		System.out.println("pBean2:" + pBean2);
		
		PrototypeBean pBean3 = ctx.getBean("prototypeBean", PrototypeBean.class);
		System.out.println("pBean3:" + pBean3);
		
		LazyBean lazyBean = ctx.getBean("lazyBean", LazyBean.class);

	}

}
