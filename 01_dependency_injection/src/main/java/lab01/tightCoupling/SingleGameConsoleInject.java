package lab01.tightCoupling;

/**
 * 只能玩單一遊戲的遊戲機
 * 將遊戲用建構的方式傳入
 */
public class SingleGameConsoleInject {

	private Tetris tetris;
	
	public SingleGameConsoleInject(Tetris tetris) {
		this.tetris = tetris;
	}
	
	public void run() {
		tetris.play();
	}
}
