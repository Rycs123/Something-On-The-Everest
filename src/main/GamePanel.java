package main;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

import character.Character;
import character.Player;
import monster.Monster_GreenSlime;
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
	// 2 di bawah ini bisa dihapus cad
	public final int worldWidth = tileSize * maxWorldCol;
	public final int worldHeight = tileSize * maxWorldRow;

	// FPS SET
	int FPS = 60;

	TileManager tileM = new TileManager(this);
	KeyHandler keyH = new KeyHandler();
	public CollisionChecker collCheck = new CollisionChecker(this);
	public ObjectSetter objSetter = new ObjectSetter(this);
	public UI ui = new UI(this);
	public EventHandler eventHandler = new EventHandler(this);
	// Sound
	Sound sound = new Sound();
	Thread gameThread;

	// entity and obj
	public Player player = new Player(this, keyH);
	public SupObj obj[] = new SupObj[10];
	public Character npc[] = new Character[10];
	public Character monster[] = new Character[20];

	public GamePanel() {
		this.setPreferredSize(new Dimension(screenWidth, screenHeight));
		this.setBackground(Color.black);
		this.setDoubleBuffered(true);
		this.addKeyListener(keyH);
		this.setFocusable(true);
	}

	public void setUpGame() {
		aSetter.setMonster();
	}

	public void setupObject() {
		objSetter.setObject();
		objSetter.setNpc();
		playMusic(0);
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
				;
			}
		}

		// monster
		for (int i = 0; i < monster.length; i++) {
			if (monster[i] != null) {
				monster.update();
			}
		}
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);

		Graphics2D g2 = (Graphics2D) g;

		tileM.draw(g2);

		for (int i = 0; i < obj.length; i++) {
			if (obj[i] != null) {
				obj[i].draw(g2, this);
			}
		}

		for (int i = 0; i < npc.length; i++) {
			if (npc[i] != null) {
				npc[i].draw(g2);
			}
		}

		for (int i = 0; i < monster.length; i++) {
			if (monster[i] != null) {
				monster[i].draw(g2);
			}
		}

		player.draw(g2);

		ui.draw(g2);

		g2.dispose();

	}

	public void playMusic(int number) {
		sound.setFile(number);
		sound.play();
		sound.loop();
	}

	public void stopMusic(int number) {
		sound.loop();
	}

	public void playSE(int number) {
		sound.setFile(number);
		sound.play();
	}
}
