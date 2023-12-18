package main;

import character.Npc_Oldman;
import monster.Monster_GreenSlime;
import object.ObjDoor;

public class AssetSetter {
    GamePanel gp;

    public AssetSetter(GamePanel gp) {
        this.gp = gp;
    }

    public void setObj() {

    }

    public void setNPC() {
        gp.npc[0] = new Npc_Oldman(gp);
        gp.npc[0].worldX = gp.tileSize * 21;
        gp.npc[0].worldY = gp.tileSize * 21;
    }

    public void setMonster() {
        gp.monster[0] = new Monster_GreenSlime(gp);
        gp.monster[0].worldX = gp.tileSize * 21;
        gp.monster[0].worldY = gp.tileSize * 21;
    }
}
