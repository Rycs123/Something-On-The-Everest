package character;

import java.io.IOException;

import javax.imageio.ImageIO;

import main.GamePanel;

public class Npc_Oldman extends Character {

    public Npc_Oldman(GamePanel gp) {
        super(gp);
        direction = "down";
        speed = 0;
        getImage();
        setDialogue();
    }

    public void getImage() {
        try {
            down1 = ImageIO.read(getClass().getResourceAsStream("/npc/orc_down_1.png"));
            down2 = ImageIO.read(getClass().getResourceAsStream("/npc/orc_down_2.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void setDialogue() {
        dialogues = "Halo-halo, Selamat Datang di Everest.\nKonon katanya ada sebuah harta karun yang tersembunyi \ndi gunung ini.\nKau hebat jika menemukannya";
    }

    public void speak() {

        gp.ui.currentDialogue = dialogues;

    }
}
