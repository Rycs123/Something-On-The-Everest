package main;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyHandler implements KeyListener {
	GamePanel gp;
	public boolean upPressed, downPressed, leftPressed, rightPressed;

	public KeyHandler(GamePanel gp) {
		this.gp = gp;
	}

	public void keyTyped(KeyEvent e) {
	}

	public void keyPressed(KeyEvent e) {
		int code = e.getKeyCode();
		if (gp.gameState == gp.title_state) {
			if (code == KeyEvent.VK_W) {
				gp.ui.selectOptionMenu--;
				if (gp.ui.selectOptionMenu < 0) {
					gp.ui.selectOptionMenu = 2;
				}
			}
			if (code == KeyEvent.VK_S) {
				gp.ui.selectOptionMenu++;
				if (gp.ui.selectOptionMenu > 2) {
					gp.ui.selectOptionMenu = 0;
				}
			}
			if (code == KeyEvent.VK_ENTER) {
				if (gp.ui.selectOptionMenu == 0) {
					gp.gameState = gp.play_state;
					gp.playMusic(0);
				}
				if (gp.ui.selectOptionMenu == 1) {
					// add later
				}
				if (gp.ui.selectOptionMenu == 2) {
					System.exit(0);
				}
			}
		}

		if (gp.gameState == gp.play_state) {
			if (code == KeyEvent.VK_W) {
				upPressed = true;
			}
			if (code == KeyEvent.VK_A) {
				leftPressed = true;
			}
			if (code == KeyEvent.VK_S) {
				downPressed = true;
			}
			if (code == KeyEvent.VK_D) {
				rightPressed = true;
			}
			if (code == KeyEvent.VK_SPACE) {
				gp.gameState = gp.pause_state;
			}
		} else if (gp.gameState == gp.pause_state) {
			if (code == KeyEvent.VK_SPACE) {
				gp.gameState = gp.play_state;
			}
		} else if (gp.gameState == gp.dialogue) {
			if (code == KeyEvent.VK_SPACE) {
				gp.gameState = gp.play_state;
			}
		}

	}

	public void keyReleased(KeyEvent e) {
		int code = e.getKeyCode();

		if (code == KeyEvent.VK_W) {
			upPressed = false;
		}
		if (code == KeyEvent.VK_A) {
			leftPressed = false;
		}
		if (code == KeyEvent.VK_S) {
			downPressed = false;
		}
		if (code == KeyEvent.VK_D) {
			rightPressed = false;
		}
	}

}
