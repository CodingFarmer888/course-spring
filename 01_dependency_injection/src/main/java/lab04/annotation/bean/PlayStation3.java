package lab04.annotation.bean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class PlayStation3 {
	
	@Autowired
	@Qualifier("I_AM_GTA2")
	private Game gta2;
	
	public void run() {
		System.out.println("===== run PlayStation3 ======");
		gta2.play();
	}

}
