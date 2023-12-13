package object;

import java.io.IOException;

import javax.imageio.ImageIO;

public class ObjHeart extends SupObj {
    public ObjHeart(){
        name = "heart";
        try {
            image = ImageIO.read(getClass().getResourceAsStream("/objects/heart_full.png"));
            image2 = ImageIO.read(getClass().getResourceAsStream("/objects/heart_half.png"));
            image3 = ImageIO.read(getClass().getResourceAsStream("/objects/heart_blank.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        collision = true;
    }
}
