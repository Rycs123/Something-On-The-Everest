package monster;

import java.util.Random;
import java.io.IOException;
import character.Character;
import main.GamePanel;
import javax.imageio.ImageIO;

public class Monster_GreenSlime extends Character {
    public Monster_GreenSlime(GamePanel gp) {
        super(gp);
        type = 2;
        name = "Orc";
        speed = 1;
        maxLife = 4;
        life = maxLife;
        direction = "left";
        // ukuran monster
        solidArea.x = 3;
        solidArea.y = 18;
        solidArea.width = 42;
        solidArea.height = 30;
        solidArea.y = 18;
        solidAreaDefaultX = solidArea.x;
        solidAreaDefaultY = solidArea.y;
        getImage();
    }

    public void getImage() {
        try {
            up1 = ImageIO.read(getClass().getResourceAsStream("/monster/orc_up_1.png"));
            up2 = ImageIO.read(getClass().getResourceAsStream("/monster/orc_up_2.png"));
            down1 = ImageIO.read(getClass().getResourceAsStream("/monster/orc_down_1.png"));
            down2 = ImageIO.read(getClass().getResourceAsStream("/monster/orc_down_2.png"));
            left1 = ImageIO.read(getClass().getResourceAsStream("/monster/orc_left_1.png"));
            left2 = ImageIO.read(getClass().getResourceAsStream("/monster/orc_left_2.png"));
            right1 = ImageIO.read(getClass().getResourceAsStream("/monster/orc_right_1.png"));
            right2 = ImageIO.read(getClass().getResourceAsStream("/monster/orc_right_2.png"));

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
