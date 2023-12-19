package lab04.annotation.bean;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component(value = "I_AM_GTA2")
//@Primary
public class Gta2 implements Game {
	
	@Override
	public void play() {
		System.out.println("遊玩GTA2");
		
	}
}
