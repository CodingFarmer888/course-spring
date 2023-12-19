package lab02.xmlConfig;

/**
 * Setter Injection(Setter注入)
 */
public class GameConsoleSetterInjection {

	private Game game;
	
	public void setGame(Game game) {
		this.game = game;
	}

	public void run() {
		game.play();
	}
}
