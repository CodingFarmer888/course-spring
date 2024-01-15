package lab04.annotation.bean;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
// @Primary
// 沒有特別指定名稱，默認為首字小寫 -> gta
public class Gta implements Game {

	@Override
	public void play() {
		System.out.println("遊玩GTA");
		
	}

}
