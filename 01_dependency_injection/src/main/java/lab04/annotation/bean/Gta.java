package lab04.annotation.bean;

import org.springframework.stereotype.Component;

@Component("Gta")
public class Gta implements Game {

	@Override
	public void play() {
		System.out.println("遊玩GTA");
		
	}

}
