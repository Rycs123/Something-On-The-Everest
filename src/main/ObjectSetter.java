package main;

import character.Npc_Oldman;
import monster.Monster_GreenSlime;
import object.ObjDoor;
import object.ObjKey;

public class ObjectSetter {
    GamePanel gp;

    public ObjectSetter(GamePanel gp){
        this.gp = gp;
    }

    public void setObject(){
        gp.obj[0] = new ObjKey();
        gp.obj[0].worldX = 23 * gp.tileSize;
        gp.obj[0].worldY = 22 * gp.tileSize;

        gp.obj[1] = new ObjKey();
        gp.obj[1].worldX = 18 * gp.tileSize;
        gp.obj[1].worldY = 20 * gp.tileSize;

        gp.obj[2] = new ObjDoor();
        gp.obj[2].worldX = 23 * gp.tileSize;
        gp.obj[2].worldY = 24 * gp.tileSize;
    }

    public void setNpc(){
        gp.npc[0] = new Npc_Oldman(gp);
        gp.npc[0].worldX = 29 * gp.tileSize;
        gp.npc[0].worldY = 23 * gp.tileSize;

    }

    public void setMonster() {
        gp.monster[0] = new Monster_GreenSlime(gp);
        gp.monster[0].worldX = gp.tileSize * 23;
        gp.monster[0].worldY = gp.tileSize * 23;

        gp.monster[1] = new Monster_GreenSlime(gp);
        gp.monster[1].worldX = gp.tileSize * 23;
        gp.monster[1].worldY = gp.tileSize * 37;
    }
}
