package main;

import javax.swing.JFrame;

public class Main {

	public static void main(String[] args) {
		
		JFrame window = new JFrame();
		GamePanel gamePanel = new GamePanel();

		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setResizable(false);
		window.setTitle("Something on the Everest");
		window.add(gamePanel);
		window.pack(); //fit to size
		window.setLocationRelativeTo(null);
		window.setVisible(true);
		
		gamePanel.setupObject();
		gamePanel.startGameThread();
	}

}
