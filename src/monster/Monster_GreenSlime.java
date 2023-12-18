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
        name = "Green Slime";
        speed = 1;
        maxLife = 4;
        life = maxLife;

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
            up1 = ImageIO.read(getClass().getResourceAsStream("/monster/greenslime_down_1"));
            up2 = ImageIO.read(getClass().getResourceAsStream("/monster/greenslime_down_2"));
            down1 = ImageIO.read(getClass().getResourceAsStream("/monster/greenslime_down_1"));
            down2 = ImageIO.read(getClass().getResourceAsStream("/monster/greenslime_down_2"));
            left1 = ImageIO.read(getClass().getResourceAsStream("/monster/greenslime_down_1"));
            left2 = ImageIO.read(getClass().getResourceAsStream("/monster/greenslime_down_2"));
            right1 = ImageIO.read(getClass().getResourceAsStream("/monster/greenslime_down_1"));
            right2 = ImageIO.read(getClass().getResourceAsStream("/monster/greenslime_down_2"));

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
