package main;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import object.ObjKey;

public class UI {
    GamePanel gp;
    Font arial_40;
    BufferedImage keyImage;

    public UI(GamePanel gp){
        this.gp = gp;
        arial_40 = new Font("Monospaced", Font.BOLD, 30);
        ObjKey key = new ObjKey();
        keyImage = key.image;
    }

    public void draw(Graphics2D g2){
        g2.setFont(arial_40);
        g2.setColor(Color.WHITE);
        g2.drawImage(keyImage, gp.tileSize/4, gp.tileSize/4, gp.tileSize, gp.tileSize, null);
        g2.drawString("x" + gp.player.hasKey, 50, 58);
    }
}
