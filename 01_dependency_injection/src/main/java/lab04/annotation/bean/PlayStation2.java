package lab04.annotation.bean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

// 1. 要能被掃描
@Component
public class PlayStation2 {

	/**
	 * 2. 透過 Autowired 關鍵字把Game裝配進PlayStation2
	 * 		位置 -> 1. Constructor 2. Setter 3. Field
	 * 3. 如果有多個Bean符合自動裝配，會讓程式無法啟動，必須加入能夠讓Spring判讀的註解
	 * 		1. Primary 
	 * 		2. Qualifier -> byName，Component在沒有設定的情況下，名稱為首字小寫
	 * 		
	 */
	
	// @Autowired
	private Game game;

	@Autowired
	public PlayStation2(@Qualifier("gta") Game game) {
		this.game = game;
	}
	
	public void run() {
		System.out.println("===== run PlayStation2 ======");
		game.play();
	}
	
	public Game getGame() {
		return game;
	}

//	@Autowired
	public void setGame(Game game) {
		this.game = game;
	}
	
}
