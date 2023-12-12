package object;

import java.io.IOException;

import javax.imageio.ImageIO;

import main.GamePanel;

public class ObjHeart extends SupObj {
    GamePanel gp;

    public ObjHeart(GamePanel gp) {
        this.gp = gp;

        name = "heart";
        try {
            image = ImageIO.read(getClass().getResourceAsStream("/objects/heart_full.png"));
            image2 = ImageIO.read(getClass().getResourceAsStream("/objects/heart_half.png"));
            image3 = ImageIO.read(getClass().getResourceAsStream("/objects/heart_blank.png"));
            // image = uTool.scale(image, gp.tileSize, gp.tileSize);
            // image2 = uTool.scale(image, gp.tileSize, gp.tileSize);
            // image3 = uTool.scale(image, gp.tileSize, gp.tileSize);

        } catch (IOException e) {
            e.printStackTrace();
        }

        collision = true;
    }
}
