package character;

import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;

import main.GamePanel;

public class Npc_Oldman extends Character {

    public Npc_Oldman(GamePanel gp) {
        super(gp);
        direction = "right";
        speed = 1;
        getImage();
    }

    public void getImage() {
        try {
            up1 = ImageIO.read(getClass().getResourceAsStream("/npc/orc_up_1.png"));
            up2 = ImageIO.read(getClass().getResourceAsStream("/npc/orc_up_2.png"));
            down1 = ImageIO.read(getClass().getResourceAsStream("/npc/orc_down_1.png"));
            down2 = ImageIO.read(getClass().getResourceAsStream("/npc/orc_down_2.png"));
            left1 = ImageIO.read(getClass().getResourceAsStream("/npc/orc_left_1.png"));
            left2 = ImageIO.read(getClass().getResourceAsStream("/npc/orc_left_2.png"));
            right1 = ImageIO.read(getClass().getResourceAsStream("/npc/orc_right_1.png"));
            right2 = ImageIO.read(getClass().getResourceAsStream("/npc/orc_right_2.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void setAction() {
        actionLockCounter++;
        if (actionLockCounter == 96) {
            Random random = new Random();
            int i = random.nextInt(100) + 1;
            if (i <= 25) {
                direction = "up";
            }
            if (i > 25 && i <= 50) {
                direction = "down";
            }
            if (i > 50 && i <= 75) {
                direction = "left";
            }
            if (i > 75 && i <= 100) {
                direction = "right";
            }
            actionLockCounter = 0;
        }
    }
}
