package lab03.javaConfig;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

// 1. 宣告這個Class是個配置類別 -> Configuration
@Configuration
public class GameConsoleConfig {

	// 2. 宣告受到Spring管理的Bean
	@Bean
	public Game finalFantasy() {
		return new FinalFantasy();
	}
	
	@Bean 
	public Game dragonQuest() {
		return new DragonQuest();
	}
	
	@Bean
	public PlayStation playStation() {
		return new PlayStation(finalFantasy());
	}
}
