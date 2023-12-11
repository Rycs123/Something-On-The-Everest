package object;

import java.io.IOException;

import javax.imageio.ImageIO;

public class ObjDoor extends SupObj {
    public ObjDoor() {
        name = "door";
        try {
            image = ImageIO.read(getClass().getResourceAsStream("/objects/door.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        collision = true;
    }
}
