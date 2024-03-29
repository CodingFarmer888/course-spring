package lab02.xmlConfig;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * XML 配置
 */
public class GameConsoleMain {

	public static void main(String[] args) {
		
		// 取得Spring Container -> ApplicationContext -> 讀取xml檔案 ClassPathXmlApplicationContext
		ApplicationContext ctx = new ClassPathXmlApplicationContext("game-console.xml");
		
		// 2. 取得指定的Bean
		GameConsoleConstructorInjection console = ctx.getBean("gameConsoleConstructorInjection", GameConsoleConstructorInjection.class);
		console.run();
		
		// Setter注入
		System.out.println("===== Setter注入 =====");
		GameConsoleSetterInjection consoleSetterInjection = ctx.getBean("gameConsoleSetterInjection", GameConsoleSetterInjection.class);
		consoleSetterInjection.run();
		
		// 自動裝配
		System.out.println("===== 自動裝配 =====");
		GameConsoleAutowire consoleAutowire = ctx.getBean("gameConsoleAutowire", GameConsoleAutowire.class);
		consoleAutowire.run();
		
	}

}
