package main;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import object.ObjHeart;
import object.ObjKey;

public class UI {
    GamePanel gp;
    Font arial_40;
    BufferedImage keyImage, heartFullImage, heartHalfImage, heartBlankImage;
    public boolean messageOn = false;
    public String message = "";
    public boolean gameFinished = false;
    public String currentDialogue = "";
    public int commandNum = 0;

    public UI(GamePanel gp) {
        this.gp = gp;
        arial_40 = new Font("Monospaced", Font.BOLD, 30);
        ObjKey key = new ObjKey(gp);
        keyImage = key.image;

        ObjHeart heart = new ObjHeart(gp);
        heartFullImage = heart.image;
        heartHalfImage = heart.image2;
        heartBlankImage = heart.image3;
    }

    public void draw(Graphics2D g2) {
        g2.setFont(arial_40);
        g2.setColor(Color.WHITE);
        g2.drawImage(keyImage, gp.tileSize / 4, gp.tileSize / 4, gp.tileSize, gp.tileSize, null);
        g2.drawString("x" + gp.player.hasKey, 50, 58);
        if (gp.gameState == gp.titleState) {
            drawTitleScreen(g2);
        }

        if (gp.gameState == gp.playState) {
            drawPlayerLife();
        }

        if (gp.gameState == gp.pauseState) {
            drawPlayerLife();
            drawPauseScreen(g2);
        }

        if (gp.gameState == gp.dialogueState) {
            drawPlayerLife();
            drawDialogueScreen();
        }
    }

    public void drawPlayerLife() {
        int x = gp.tileSize / 2;
        int y = gp.tileSize / 2;
        int i = 0;

        while (i < gp.player.maxHP / 2) {
            g2.drawImage(heartBlankImage, x, y, null);
            i++;
            x += gp.tileSize;
        }

        x = gp.tileSize / 2;
        y = gp.tileSize / 2;
        i = 0;

        while (i < gp.player.hp) {
            g2.drawImage(heartHalfImage, x, y, null);
            i++;
            if (i < gp.player.hp) {
                g2.drawImage(heartFullImage, x, y, null);
            }
            i++;
            x += gp.tileSize;
        }
    }

    public void drawPauseScreen(Graphics2D g2) {
        g2.setFont(arial_40);
        String text = "PAUSED";
        int x = getXForCenteredText(text);
        int y = gp.screenHeight / 2;
    }

    public void drawDialogueScreen() {

    }

    public void drawTitleScreen(Graphics2D g2) {
        g2.setColor(new Color(0, 0, 0));
        g2.fillRect(0, 0, gp.screenWidth, gp.screenHeight);
        g2.setFont(arial_40);
        String text = "Something on The Everest";
        int x = getXForCenteredText(text);
        int y = gp.tileSize * 3;

        g2.setColor(Color.gray);
        g2.drawString(text, x + 5, y + 5);

        g2.setColor(Color.white);
        g2.drawString(text, x, y);

        x = gp.screenWidth / 2 - (gp.tileSize * 2) / 2;
        y += gp.tileSize * 2;
        g2.drawImage(gp.player.down1, x, y, gp.tileSize * 2, gp.tileSize * 2, null);

        g2.setFont(arial_40);

        text = "NEW GAME";
        x = getXForCenteredText(text);
        y = gp.tileSize * 3.5;
        g2.drawString(text, x, y);
        if (commandNum == 0) {
            g2.drawString(">", x - gp.tileSize, y);
        }
        text = "LOAD GAME";
        x = getXForCenteredText(text);
        y = gp.tileSize;
        g2.drawString(text, x, y);
        if (commandNum == 1) {
            g2.drawString(">", x - gp.tileSize, y);
        }

        text = "QUIT GAME";
        x = getXForCenteredText(text);
        y = gp.tileSize;
        g2.drawString(text, x, y);
        if (commandNum == 2) {
            g2.drawString(">", x - gp.tileSize, y);
        }
    }

    public int getXForCenteredText(String text) {
        int length = (int) g2.getFontMetrics().getStringBounds(text, g2).getWidth();
        int x = gp.screenWidth / 2 - length / 2;
        return x;
    }
}
