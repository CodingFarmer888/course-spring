package lab02.xmlConfig;

/**
 * 自動裝配
 */
public class GameConsoleAutowire {

	private Game game;
	
	public void run() {
		game.play();
	}

	public Game getGame() {
		return game;
	}

	public void setGame(Game game) {
		this.game = game;
	}
	
}
