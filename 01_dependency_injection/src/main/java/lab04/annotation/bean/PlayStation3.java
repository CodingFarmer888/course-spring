package lab04.annotation.bean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class PlayStation3 {
	
	@Autowired
	@Qualifier("Gta")
	private Game gta2;
	
	public void run() {
		gta2.play();
	}

	public Game getGta2() {
		return gta2;
	}

	public void setGta2(Game gta2) {
		this.gta2 = gta2;
	}

}
