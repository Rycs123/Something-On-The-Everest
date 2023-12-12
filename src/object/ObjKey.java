package object;

import java.io.IOException;

import javax.imageio.ImageIO;

import main.GamePanel;

public class ObjKey extends SupObj {

    GamePanel gp;

    public ObjKey(GamePanel gp) {
        this.gp = gp;

        name = "key";
        try {
            image = ImageIO.read(getClass().getResourceAsStream("/objects/key.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        collision = true;
    }
}
