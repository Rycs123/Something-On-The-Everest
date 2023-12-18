package main;

import character.Character;

public class CollisionChecker {
	GamePanel gp;

	public CollisionChecker(GamePanel gp) {
		this.gp = gp;
	}

	public void checkTile(Character character) {
		int charLeftWorldX = character.worldX + character.solidArea.x;
		int charRightWorldX = character.worldX + character.solidArea.x + character.solidArea.width;
		int charTopWorldY = character.worldY + character.solidArea.y;
		int charBottomWorldY = character.worldY + character.solidArea.y + character.solidArea.height;

		int charLeftCol = charLeftWorldX / gp.tileSize;
		int charRightCol = charRightWorldX / gp.tileSize;
		int charTopRow = charTopWorldY / gp.tileSize;
		int charBottomRow = charBottomWorldY / gp.tileSize;

		int tile1, tile2;

		switch (character.direction) {
			case "up":
				charTopRow = (charTopWorldY - character.speed) / gp.tileSize;
				tile1 = gp.tileM.mapTileNum[charLeftCol][charTopRow];
				tile2 = gp.tileM.mapTileNum[charRightCol][charTopRow];
				if (gp.tileM.tile[tile1].collision == true || gp.tileM.tile[tile2].collision == true) {
					character.collisionOn = true;
				}
				break;
			case "down":
				charBottomRow = (charBottomWorldY + character.speed) / gp.tileSize;
				tile1 = gp.tileM.mapTileNum[charLeftCol][charBottomRow];
				tile2 = gp.tileM.mapTileNum[charRightCol][charBottomRow];
				if (gp.tileM.tile[tile1].collision == true || gp.tileM.tile[tile2].collision == true) {
					character.collisionOn = true;
				}
				break;
			case "left":
				charLeftCol = (charLeftWorldX - character.speed) / gp.tileSize;
				tile1 = gp.tileM.mapTileNum[charLeftCol][charTopRow];
				tile2 = gp.tileM.mapTileNum[charLeftCol][charBottomRow];
				if (gp.tileM.tile[tile1].collision == true || gp.tileM.tile[tile2].collision == true) {
					character.collisionOn = true;
				}
				break;
			case "right":
				charRightCol = (charRightWorldX + character.speed) / gp.tileSize;
				tile1 = gp.tileM.mapTileNum[charRightCol][charTopRow];
				tile2 = gp.tileM.mapTileNum[charRightCol][charBottomRow];
				if (gp.tileM.tile[tile1].collision == true || gp.tileM.tile[tile2].collision == true) {
					character.collisionOn = true;
				}
				break;
		}
	}

	public int checkObject(Character character, boolean player) {
		int index = 999;
		for (int i = 0; i < gp.obj.length; i++) {
			if (gp.obj[i] != null) {
				character.solidArea.x = character.worldX + character.solidArea.x;
				character.solidArea.y = character.worldY + character.solidArea.y;

				gp.obj[i].solidArea.x = gp.obj[i].worldX + gp.obj[i].solidArea.x;
				gp.obj[i].solidArea.y = gp.obj[i].worldY + gp.obj[i].solidArea.y;

				switch (character.direction) {
					case "up":
						character.solidArea.y -= character.speed;
						break;
					case "down":
						character.solidArea.y += character.speed;
						break;
					case "left":
						character.solidArea.x -= character.speed;
						break;
					case "right":
						character.solidArea.x += character.speed;
						break;
				}
				if (character.solidArea.intersects(gp.obj[i].solidArea)) {
					if (gp.obj[i].collision == true) {
						character.collisionOn = true;
					}
					if (player == true) {
						index = i;
					}
				}
				character.solidArea.x = character.solidAreaDefaultX;
				character.solidArea.y = character.solidAreaDefaultY;

				gp.obj[i].solidArea.x = gp.obj[i].solidAreaDefaultX;
				gp.obj[i].solidArea.y = gp.obj[i].solidAreaDefaultY;
			}
		}
		return index;
	}

	public int checkCharacter(Character character, Character[] target) {
		int index = 999;
		for (int i = 0; i < target.length; i++) {
			if (target[i] != null) {
				character.solidArea.x = character.worldX + character.solidArea.x;
				character.solidArea.y = character.worldY + character.solidArea.y;

				target[i].solidArea.x = target[i].worldX + target[i].solidArea.x;
				target[i].solidArea.y = target[i].worldY + target[i].solidArea.y;

				switch (character.direction) {
					case "up":
						character.solidArea.y -= character.speed;
						break;
					case "down":
						character.solidArea.y += character.speed;
						break;
					case "left":
						character.solidArea.x -= character.speed;
						break;
					case "right":
						character.solidArea.x += character.speed;
						break;
				}
				if (character.solidArea.intersects(target[i].solidArea)) {
					if (target[i] != character) {
						character.collisionOn = true;
						index = i;
					}

				}
				character.solidArea.x = character.solidAreaDefaultX;
				character.solidArea.y = character.solidAreaDefaultY;

				target[i].solidArea.x = target[i].solidAreaDefaultX;
				target[i].solidArea.y = target[i].solidAreaDefaultY;
			}

		}
		return index;

	}

	public boolean checkPlayer(Character character) {
		boolean contactPlayer = false;
		character.solidArea.x = character.worldX + character.solidArea.x;
		character.solidArea.y = character.worldY + character.solidArea.y;

		gp.player.solidArea.x = gp.player.worldX + gp.player.solidArea.x;
		gp.player.solidArea.y = gp.player.worldY + gp.player.solidArea.y;

		switch (character.direction) {
			case "up":
				character.solidArea.y -= character.speed;
				break;
			case "down":
				character.solidArea.y += character.speed;
				break;
			case "left":
				character.solidArea.x -= character.speed;
				break;
			case "right":
				character.solidArea.x += character.speed;
				break;
		}
		if (character.solidArea.intersects(gp.player.solidArea)) {
			character.collisionOn = true;
			contactPlayer = true;
		}

		character.solidArea.x = character.solidAreaDefaultX;
		character.solidArea.y = character.solidAreaDefaultY;

		gp.player.solidArea.x = gp.player.solidAreaDefaultX;
		gp.player.solidArea.y = gp.player.solidAreaDefaultY;

		return contactPlayer;
	}
}
