package lab04.annotation;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import lab04.annotation.bean.PlayStation2;
import lab04.annotation.bean.PlayStation3;

/**
 * Annotation 配置
 */
public class AnnotationMain {

	public static void main(String[] args) {
		// 1. 取得Spring Container -> ApplicationContext -> 讀取Java Config檔案 AnnotationConfigApplicationContext
		ApplicationContext ctx = new AnnotationConfigApplicationContext(AnnotationConfig.class);
		PlayStation2 ps2 = ctx.getBean(PlayStation2.class);
		ps2.run();
		
		PlayStation3 ps3 = ctx.getBean(PlayStation3.class);
		ps3.run();
		

	}

}
