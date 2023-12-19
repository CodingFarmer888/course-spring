package lab01.tightCoupling;

/**
 * 只能玩單一遊戲的遊戲機
 */
public class SingleGameConsole {

	private Tetris tetris = new Tetris();
	
	public SingleGameConsole() {
	}
	
	public void run() {
		tetris.play();
	}
}
