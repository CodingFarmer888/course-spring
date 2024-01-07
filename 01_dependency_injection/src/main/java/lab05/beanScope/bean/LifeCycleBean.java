package lab05.beanScope.bean;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Component
public class LifeCycleBean implements InitializingBean, DisposableBean {

	public LifeCycleBean() {
		System.out.println("1. 我是建構式");
	}
	
	/**
	 * 建構完成之後呼叫
	 * 方法名稱任意，有@PostConstruct即可
	 */
	@PostConstruct
	public void init() {
		System.out.println("2. 我是PostConstruct");
	}
	
	/**
	 * 實作InitializingBean
	 * @throws Exception
	 */
	@Override
	public void afterPropertiesSet() throws Exception {
		System.out.println("3. 我是afterPropertiesSet，要實作 InitializingBean");
		
	}
	
	/**
	 * Bean要被銷毀前
	 * 方法名稱任意，有@PreDestroy即可
	 */
	@PreDestroy
	public void cleanup() {
		System.out.println("4. 我是@PreDestroy");
	}

	/**
	 * 實作DisposableBean
	 */
	@Override
	public void destroy() throws Exception {
		System.out.println("5. 我是destroy，要實作 DisposableBean");
	}


}
