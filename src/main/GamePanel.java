package main;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

import character.Character;
import character.Player;
import object.SupObj;
import tile.TileManager;

public class GamePanel extends JPanel implements Runnable {
	// SCREEN SETTINGS
	final int originalTileSize = 16; // 16x16px
	final int scale = 3;

	public final int tileSize = originalTileSize * scale; // 48px
	public final int maxScreenCol = 16;
	public final int maxScreenRow = 12;
	public final int screenWidth = tileSize * maxScreenCol;
	public final int screenHeight = tileSize * maxScreenRow;

	// WORLD SET
	public final int maxWorldCol = 50;
	public final int maxWorldRow = 50;
	public final int worldWidth = tileSize * maxWorldCol;
	public final int worldHeight = tileSize * maxWorldRow;

	// FPS SET
	int FPS = 60;

	TileManager tileM = new TileManager(this);
	KeyHandler keyH = new KeyHandler();
	public CollisionChecker collCheck = new CollisionChecker(this);
	public ObjectSetter objSetter = new ObjectSetter(this);
	public UI ui = new UI(this);
	Thread gameThread;
	public Player player = new Player(this, keyH);
	public SupObj obj[] = new SupObj[10];
	public Character npc[] = new Character[10];

	public int gameState;
	public final int titleState = 0;
	public final int playState = 1;
	public final int pauseState = 2;
	public final int dialogueState = 3;

	public GamePanel() {
		this.setPreferredSize(new Dimension(screenWidth, screenHeight));
		this.setBackground(Color.black);
		this.setDoubleBuffered(true);
		this.addKeyListener(keyH);
		this.setFocusable(true);
	}

	public void setupObject() {
		objSetter.setObject();
		objSetter.setNpc();
		// playMusic(0);
		gameState = titleState;
	}

	public void startGameThread() {
		gameThread = new Thread(this);
		gameThread.start();
	}

	public void run() {
		// game loop
		double drawInterval = 1000000000 / FPS;
		double delta = 0;
		long lastTime = System.nanoTime();
		long currentTime;

		while (gameThread != null) {
			currentTime = System.nanoTime();
			delta += (currentTime - lastTime) / drawInterval;
			lastTime = currentTime;

			if (delta >= 1) {
				update();
				repaint();
				delta--;
			}

		}
	}

	public void update() {
		player.update();
		for (int i = 0; i < npc.length; i++) {
			if (npc[i] != null) {
				npc[i].update();
			}
		}
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);

		Graphics2D g2 = (Graphics2D) g;

		g2.setColor(Color.white);
		g2.fillRect(100, 100, tileSize, tileSize);
		g2.dispose();
		// if (gameState == titleState) {
		// ui.draw(g2);
		// } else {
		// tileM.draw(g2);

		// for (int i = 0; i < obj.length; i++) {
		// if (obj[i] != null) {
		// obj[i].draw(g2, this);
		// }
		// }

		// for (int i = 0; i < npc.length; i++) {
		// if (npc[i] != null) {
		// npc[i].draw(g2);
		// }
		// }

		// player.draw(g2);

		// ui.draw(g2);
		// g2.dispose();

		// }

	}

}
