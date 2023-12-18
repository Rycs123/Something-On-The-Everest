package object;

import java.io.IOException;

import javax.imageio.ImageIO;

public class ObjHeart extends SupObj {
    public ObjHeart() {
        name = "heart";
        try {
            image = ImageIO.read(getClass().getResourceAsStream("/objects/heart_full.png"));
            image2 = ImageIO.read(getClass().getResourceAsStream("/objects/heart_half.png"));
            image3 = ImageIO.read(getClass().getResourceAsStream("/objects/heart_blank.png"));
            // image = uTool.scaleImage(image, gp.titleSize, gp.titleSize);
            // image2 = uTool.scaleImage(image2, gp.titleSize, gp.titleSize);
            // image3 = uTool.scaleImage(image3, gp.titleSize, gp.titleSize);
        } catch (IOException e) {
            e.printStackTrace();
        }

        collision = true;
    }
}
