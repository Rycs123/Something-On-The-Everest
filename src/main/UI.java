package main;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import object.ObjHeart;
import object.ObjKey;
import object.SupObj;

public class UI {
    GamePanel gp;
    Font arial_40;
    Graphics2D g2;
    public boolean messageOn = false;
    public String message = "";
    public int messageCounter = 0;
    public boolean gameFinished = false;

    // BufferedImage keyImage;
    BufferedImage heart_full, heart_half, heart_blank;

    public UI(GamePanel gp) {
        this.gp = gp;
        arial_40 = new Font("Monospaced", Font.BOLD, 30);
        ObjKey key = new ObjKey();
        // keyImage = key.image;

        SupObj heart = new ObjHeart();
        heart_full = heart.image;
        heart_half = heart.image2;
        heart_blank = heart.image3;

    }

    public void draw(Graphics2D g2) {
        this.g2 = g2;
        g2.setFont(arial_40);
        g2.setColor(Color.BLACK);
        // g2.drawImage(keyImage, gp.tileSize / 4, gp.tileSize / 4, gp.tileSize,
        // gp.tileSize, null);
        g2.drawString("x" + gp.player.hasKey, 50, 58);

        if (gp.gameState == gp.titleState) {
            drawTitleScreen();
        }

        if (gp.gameState == gp.titleState) {
            drawPlayerLife();
        }

        if (gp.gameState == gp.titleState) {
            drawPauseScreen();
        }

        if (gp.gameState == gp.titleState) {
            drawDialogueScreen();
        }

        int x = gp.screenWidth - (gp.tileSize + gp.tileSize / 2);
        int y = gp.tileSize / 4;
        int i = 0;

        while (i < gp.player.maxLife / 2) {
            g2.drawImage(heart_blank, x, y, gp.tileSize, gp.tileSize, null);
            i++;
            x -= gp.tileSize;
        }

        x = gp.screenWidth - (gp.tileSize + gp.tileSize / 2);
        y = gp.tileSize / 4;
        i = 0;

        while (i < gp.player.life) {
            g2.drawImage(heart_half, x, y, gp.tileSize, gp.tileSize, null);
            i++;
            if (i < gp.player.life) {
                g2.drawImage(heart_full, x, y, gp.tileSize, gp.tileSize, null);
            }
            i++;
            x -= gp.tileSize;
        }

    }

    public void drawPlayerLife() {
        gp.player.life = 6;
        int x = gp.tileSize / 2;
        int y = gp.tileSize / 2;

        int i = 0;
        // draw maxlife
        while (i < gp.player.maxLife / 2) {
            g2.drawImage(heart_blank, x, y, null);
            i++;
            x += gp.tileSize;
        }
        // reset
        x = gp.tileSize / 2;
        y = gp.tileSize / 2;
        i = 0;

        // draw currentlife
        while (i < gp.player.life) {
            g2.drawImage(heart_blank, x, y, null);
            i++;
            if (i < gp.player.life) {
                g2.drawImage(heart_full, x, y, null);
            }
            i++;
            x += gp.tileSize;
        }
    }

    public void drawTitleScreen() {
    }

    public void drawPauseScreen() {
        g2.setFont(g2.getFont().deriveFont(Font.PLAIN, 80f));
    }

    public void drawDialogueScreen() {
        int x = gp.tileSize * 2;
        int y = gp.tileSize / 2;
        int width = gp.screenWidth - (gp.tileSize * 4);
        int height = gp.tileSize * 5;
        drawSubWindow(x, y, width, height);
    }

    public void drawSubWindow(int x, int y, int width, int height) {
        Color c = new Color(0, 0, 0);
        g2.setColor(c);
        g2.fillRoundRect(x, y, width, height, 35, 35);
    }

    // public int getXforCenteredText(String text) {
    // int length = (int) g2.setFontMetrics().getStringBounds(text, g2).getWidth();
    // int x = gp.screenWidth / 2 - length / 2;
    // return x;
    // }
}
