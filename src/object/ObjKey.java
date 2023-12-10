package object;

import java.io.IOException;

import javax.imageio.ImageIO;

public class ObjKey extends SupObj{
    public ObjKey(){
        name = "key";
        try {
            image = ImageIO.read(getClass().getResourceAsStream("/objects/key.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        collision = true;
    }
}
