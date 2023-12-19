package main;

import character.Npc_pink;
import character.Npc_purple;
import monster.Monster_yeti;
import object.ObjDoor;
import object.ObjKey;

public class ObjectSetter {
    GamePanel gp;

    public ObjectSetter(GamePanel gp){
        this.gp = gp;
    }

    public void setObject(){
        gp.obj[0] = new ObjKey();
        gp.obj[0].worldX = 14 * gp.tileSize;
        gp.obj[0].worldY = 11 * gp.tileSize;

        gp.obj[1] = new ObjKey();
        gp.obj[1].worldX = 21 * gp.tileSize;
        gp.obj[1].worldY = 18 * gp.tileSize;

        gp.obj[2] = new ObjDoor();
        gp.obj[2].worldX = 41 * gp.tileSize;
        gp.obj[2].worldY = 8 * gp.tileSize;

        gp.obj[3] = new ObjDoor();
        gp.obj[3].worldX = 38 * gp.tileSize;
        gp.obj[3].worldY = 10 * gp.tileSize;
    }

    public void setNpc(){
        gp.npc[0] = new Npc_purple(gp);
        gp.npc[0].worldX = 12 * gp.tileSize;
        gp.npc[0].worldY = 43 * gp.tileSize;

        gp.npc[1] = new Npc_pink(gp);
        gp.npc[1].worldX = 29 * gp.tileSize;
        gp.npc[1].worldY = 23 * gp.tileSize;

    }

    public void setMonster() {
        gp.monster[0] = new Monster_yeti(gp);
        gp.monster[0].worldX = gp.tileSize * 13;
        gp.monster[0].worldY = gp.tileSize * 11;

        gp.monster[1] = new Monster_yeti(gp);
        gp.monster[1].worldX = gp.tileSize * 22;
        gp.monster[1].worldY = gp.tileSize * 19;
    }
}
