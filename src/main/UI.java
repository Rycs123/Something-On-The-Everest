package main;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import object.ObjHeart;
import object.ObjKey;
import object.SupObj;

public class UI {
    GamePanel gp;
    Graphics2D g2_2;
    Font mono_30, arial_80;
    BufferedImage keyImage;
    BufferedImage heart_full, heart_half, heart_blank;
    public String currentDialogue = "";

    public UI(GamePanel gp){
        this.gp = gp; 
        mono_30 = new Font("Monospaced", Font.BOLD, 30);
        arial_80 = new Font("Arial", Font.BOLD, 80);
        ObjKey key = new ObjKey();
        keyImage = key.image;

        SupObj heart = new ObjHeart();
        heart_full = heart.image;
        heart_half = heart.image2;
        heart_blank = heart.image3;
        

    }

    public void draw(Graphics2D g2){
        this.g2_2 = g2;
        g2.setFont(mono_30);
        g2.setColor(Color.BLACK);
        g2.drawImage(keyImage, gp.tileSize/4, gp.tileSize/4, gp.tileSize, gp.tileSize, null);
        g2.drawString("x" + gp.player.hasKey, 50, 58);
        
        int x = gp.screenWidth - (gp.tileSize + gp.tileSize/2);
        int y = gp.tileSize/4;
        int i = 0;

        while (i<gp.player.maxLife/2) {
            g2.drawImage(heart_blank, x, y, gp.tileSize, gp.tileSize, null);
            i++;
            x -= gp.tileSize;
        }

        x = gp.screenWidth - (gp.tileSize + gp.tileSize/2);
        y = gp.tileSize/4;
        i = 0;

        while (i<gp.player.life) {
            g2.drawImage(heart_half, x, y, gp.tileSize, gp.tileSize, null);
            i++;
            if(i < gp.player.life){
                g2.drawImage(heart_full, x, y, gp.tileSize, gp.tileSize, null);
            }
            i++;
            x -= gp.tileSize;
        }

        g2_2.setFont(arial_80);


        if(gp.gameState == gp.play_state){

        }
        if(gp.gameState == gp.pause_state){
            drawPauseScreen();
        }
        if(gp.gameState == gp.dialogue){
            drawDialogue();
        }
    }

    public void drawPauseScreen(){
        
        String text = "PAUSED";
        int x;

        int length = (int)g2_2.getFontMetrics().getStringBounds(text, g2_2).getWidth();
        x=gp.screenWidth/2 - length/2;

        int y = gp.screenHeight/2;

        g2_2.drawString(text, x, y);
    }

    public void drawDialogue(){
        int x = gp.tileSize/4;
        int y = gp.tileSize/4;
        int width = gp.screenWidth - (gp.tileSize/2);
        int height = gp.tileSize*4;

        drawSubWindow(x, y, width, height);

        g2_2.setFont(new Font("Monospaced", Font.PLAIN, 20));

        x += gp.tileSize;
        y += gp.tileSize;
        for(String line : currentDialogue.split("\n")){
            g2_2.drawString(line, x, y);
            y += 35;
        }
    }

    public void drawSubWindow(int x, int y, int width, int height){
        Color color = new Color(0, 0, 0);
        g2_2.setColor(color);
        g2_2.fillRoundRect(x, y, width, height, 35, 35);

        color = new Color(255, 255, 255);
        g2_2.setColor(color);
        g2_2.setStroke(new BasicStroke(5));
        g2_2.drawRoundRect(x+5, y+5, width-10, height-10, 25, 25);
    }
}
