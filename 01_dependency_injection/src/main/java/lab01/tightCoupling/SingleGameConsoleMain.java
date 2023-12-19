package lab01.tightCoupling;

public class SingleGameConsoleMain {

	public static void main(String[] args) {
		// 執行遊戲機
		SingleGameConsole console = new SingleGameConsole();
		console.run();
		
		// 遊戲注入
		SingleGameConsoleInject consoleInject = new SingleGameConsoleInject(new Tetris());
		consoleInject.run();
		
		// 依賴介面
	}
}
