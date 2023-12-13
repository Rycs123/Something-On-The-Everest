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
    BufferedImage keyImage;
    BufferedImage heart_full, heart_half, heart_blank;

    public UI(GamePanel gp){
        this.gp = gp;
        arial_40 = new Font("Monospaced", Font.BOLD, 30);
        ObjKey key = new ObjKey();
        keyImage = key.image;

        SupObj heart = new ObjHeart();
        heart_full = heart.image;
        heart_half = heart.image2;
        heart_blank = heart.image3;
        

    }

    public void draw(Graphics2D g2){
        g2.setFont(arial_40);
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

                

        
    }

}
