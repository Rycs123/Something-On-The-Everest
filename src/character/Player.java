package character;

import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import main.GamePanel;
import main.KeyHandler;

public class Player extends Character{
	KeyHandler key;
	
	public final int screenX;
	public final int screenY;
	public int hasKey = 0;

	boolean moving = false;
	int pixelCounter = 0;
	
	public Player(GamePanel gp, KeyHandler key) {
		super(gp);
		this.key = key;
		screenX = gp.screenWidth/2 - (gp.tileSize/2);
		screenY = gp.screenHeight/2 - (gp.tileSize/2);
		
		solidArea = new Rectangle();
		solidArea.x = 1;
		solidArea.y = 1;
		solidAreaDefaultX = solidArea.x;
		solidAreaDefaultY = solidArea.y;
		solidArea.width = 46;
		solidArea.height = 46;
		
		setDefaultValue();
		getPlayerImage();
	}
	
	public void setDefaultValue() {
		//starting position
		worldX = gp.tileSize * 23;
		worldY = gp.tileSize * 21;
		speed = 4;
		direction = "up";
		maxLife = 8;
		life = maxLife;
	}
	
	public void getPlayerImage() {
		try {
			up1 = ImageIO.read(getClass().getResourceAsStream("/player/boy_up_1.png"));
			up2 = ImageIO.read(getClass().getResourceAsStream("/player/boy_up_2.png"));
			down1 = ImageIO.read(getClass().getResourceAsStream("/player/boy_down_1.png"));
			down2 = ImageIO.read(getClass().getResourceAsStream("/player/boy_down_2.png"));
			left1 = ImageIO.read(getClass().getResourceAsStream("/player/boy_left_1.png"));
			left2 = ImageIO.read(getClass().getResourceAsStream("/player/boy_left_2.png"));
			right1 = ImageIO.read(getClass().getResourceAsStream("/player/boy_right_1.png"));
			right2 = ImageIO.read(getClass().getResourceAsStream("/player/boy_right_2.png"));
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void update() {

		if(moving == false){
			if(key.upPressed == true || key.downPressed == true || key.leftPressed == true || key.rightPressed == true) {
				if(key.upPressed == true) {
					direction = "up";
				}else if(key.downPressed == true) {
					direction = "down";
				}else if(key.leftPressed == true) {
					direction = "left";
				}else if(key.rightPressed == true) {
					direction = "right";
				}
				
				moving = true;
				//check collision, false = can move
				collisionOn = false;
				gp.collCheck.checkTile(this);
				
				int objIndex = gp.collCheck.checkObject(this, true);
				pickUpObj(objIndex);
				
				int npcIndex = gp.collCheck.checkCharacter(this, gp.npc);
				interactNpc(npcIndex);

				gp.eventHandler.checkEvent();
			}

		}

		if(moving == true){
			
			if(collisionOn == false) {
			switch(direction) {
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
			if(frameCounter > 15) {
				if(frameNum == 1) {
					frameNum = 2;
				}else if(frameNum == 2) {
					frameNum = 1;
				}
				frameCounter = 0;
			}

			pixelCounter += speed;

			if(pixelCounter == 48){
				moving = false;
				pixelCounter = 0;
			}
		}
	}
	
	public void pickUpObj(int index){
		if(index != 999){
			String objName = gp.obj[index].name;

			switch (objName) {
				case "key":
					hasKey++;
					gp.obj[index] = null;
					System.out.println("Key: "+hasKey);
					break;
				case "door":
					if(hasKey > 0){
						gp.obj[index] = null;
						hasKey--;
					}
					System.out.println("Key: "+hasKey);
					break;
			}
		}
	}

	public void interactNpc(int i){
		if(i != 999){
			System.out.println("Player hit NPC");
		}
	}

	public void draw (Graphics2D g2) {
		BufferedImage image = null;
		switch (direction) {
		case "up":
			if(frameNum == 1) {
				image = up1;
			}if(frameNum == 2) {
				image = up2;
			}
			break;
		case "down": 
			if(frameNum == 1) {
				image = down1;
			}if(frameNum == 2) {
				image = down2;
			}
			break;
		case "left": 
			if(frameNum == 1) {
				image = left1;
			}if(frameNum == 2) {
				image = left2;
			}
			break;
		case "right":
			if(frameNum == 1) {
				image = right1;
			}if(frameNum == 2) {
				image = right2;
			}
			break;
		}
		
		g2.drawImage(image, screenX, screenY, gp.tileSize, gp.tileSize, null);
	}
}
