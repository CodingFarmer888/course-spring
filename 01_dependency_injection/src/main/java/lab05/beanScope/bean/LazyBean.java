package lab05.beanScope.bean;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
@Lazy
public class LazyBean {
	
	public LazyBean() {
		System.out.println("Lazy constructor");
	}
	
	
	public void sayHello() {
		System.out.println("I am Lazy sayHello");
	}
}
