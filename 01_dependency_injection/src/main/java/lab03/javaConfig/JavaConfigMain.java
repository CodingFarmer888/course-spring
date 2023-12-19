package lab03.javaConfig;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Java 配置
 */
public class JavaConfigMain {

	public static void main(String[] args) {
		
		// 1. 取得Spring Container -> ApplicationContext -> 讀取Java Config檔案 AnnotationConfigApplicationContext
		ApplicationContext ctx = new AnnotationConfigApplicationContext(GameConsoleConfig.class);
		
		// 2. 取得指定的Bean
		PlayStation ps = ctx.getBean(PlayStation.class);
		ps.run();
		Game game = ctx.getBean("dragonQuest", Game.class);
		ps.setGame(game);
		
		ps.run();
		
		String[] beanNames = ctx.getBeanDefinitionNames();
		for (String name : beanNames) {
			System.out.println(name);
		}
	}
}
