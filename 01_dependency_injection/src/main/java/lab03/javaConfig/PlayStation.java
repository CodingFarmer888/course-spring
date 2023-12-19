package lab03.javaConfig;

public class PlayStation {

	private Game game;
	
	public PlayStation(Game game) {
		this.game = game;
	}
	
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
