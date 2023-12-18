package character;

import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

import main.GamePanel;

public class Character {
	GamePanel gp;
	public int worldX, worldY, speed;
	public BufferedImage up1, up2, down1, down2, left1, left2, right1, right2;
	public String direction;
	public int frameCounter = 0;
	public int frameNum = 1;
	public Rectangle solidArea = new Rectangle(1, 1, 46, 46);
	public int solidAreaDefaultX, solidAreaDefaultY;
	public boolean collisionOn = false;
	public int actionLockCounter = 0;

	// life
	public int maxLife;
	public int life;

	public Character(GamePanel gp) {
		this.gp = gp;
	}

	public void setAction() {
	}

	public void update() {
		setAction();
		collisionOn = false;
		gp.collCheck.checkTile(this);
		gp.collCheck.checkObject(this, false);
		gp.collCheck.checkCharacter(this, gp.npc);
		gp.collCheck.checkCharacter(this, gp.monster);
		gp.collCheck.checkPlayer(this);

		if (collisionOn == false) {
			switch (direction) {
				case "up":
					worldY -= speed;
					break;
				case "down":
					worldY += speed;
					break;
				case "left":
					worldX -= speed;
					break;
				case "right":
					worldX += speed;
					break;
			}
		}

		frameCounter++;
		if (frameCounter > 15) {
			if (frameNum == 1) {
				frameNum = 2;
			} else if (frameNum == 2) {
				frameNum = 1;
			}
			frameCounter = 0;
		}
	}

	public void draw(Graphics2D g2) {
		BufferedImage image = null;

		int screenX = worldX - gp.player.worldX + gp.player.screenX;
		int screenY = worldY - gp.player.worldY + gp.player.screenY;
		switch (direction) {
			case "up":
				if (frameNum == 1) {
					image = up1;
				}
				if (frameNum == 2) {
					image = up2;
				}
				break;
			case "down":
				if (frameNum == 1) {
					image = down1;
				}
				if (frameNum == 2) {
					image = down2;
				}
				break;
			case "left":
				if (frameNum == 1) {
					image = left1;
				}
				if (frameNum == 2) {
					image = left2;
				}
				break;
			case "right":
				if (frameNum == 1) {
					image = right1;
				}
				if (frameNum == 2) {
					image = right2;
				}
				break;
		}
		g2.drawImage(image, screenX, screenY, gp.tileSize, gp.tileSize, null);
	}
}
