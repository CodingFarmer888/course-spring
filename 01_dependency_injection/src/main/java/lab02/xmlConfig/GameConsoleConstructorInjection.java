package lab02.xmlConfig;

/**
 * Constructor Injection(建構式注入)
 */
public class GameConsoleConstructorInjection {

	private Game game;
	
	public GameConsoleConstructorInjection() {
		
	}
	
	public GameConsoleConstructorInjection(Game game) {
		this.game = game;
	}
	
	public void run() {
		game.play();
	}
}
