package lab01.tightCoupling;

/**
 * 只能玩單一遊戲的遊戲機
 * 將遊戲用建構的方式傳入
 */
public class SingleGameConsoleInject {

	private Game game;
	
	public SingleGameConsoleInject(Game game) {
		this.game = game;
	}
	
	public void run() {
		game.play();
	}
}
