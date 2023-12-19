package character;

import java.io.IOException;

import javax.imageio.ImageIO;

import main.GamePanel;

public class Npc_pink extends Character{
    public Npc_pink(GamePanel gp) {
        super(gp);
        direction = "down";
        speed = 0;
        getImage();
        setDialogue();
    }

	public void getImage() {
		try {
			down1 = ImageIO.read(getClass().getResourceAsStream("/npc/pink_1.png"));
			down2 = ImageIO.read(getClass().getResourceAsStream("/npc/pink_2.png"));
	
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

    public void setDialogue(){
        dialogues = "Konon katanya harta karun bersembunyi di balik sebuah\npintu dan kuncinya tersembunyi di sekitar sini";
    }
    public void speak(){
    
        gp.ui.currentDialogue = dialogues;

    }
}
