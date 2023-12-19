package lab05.beanScope.bean;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
// 1. Singleton Scope
@Scope(ConfigurableBeanFactory.SCOPE_SINGLETON)
public class SingletonBean {

	public SingletonBean() {
		System.out.println("SingletonBean Construct");
	}
}
