package main;

import object.*;
import main.*;
import tile.*;
import entity.*;

public class AssetSetter {
    GamePanel gp;
    public AssetSetter(GamePanel gp){
        this.gp = gp;
    }
    public void setObject(){
        gp.obj[0] = new OBJ_Knife();
        gp.obj[0].worldX = 21*gp.tileSize;
        gp.obj[0].worldY = 66*gp.tileSize;
        gp.obj[0].name = "Knife";

        gp.obj[1] = new OBJ_Mold1();
        gp.obj[1].worldX = 67*gp.tileSize;
        gp.obj[1].worldY = 19*gp.tileSize;
        gp.obj[1].name = "Mold1";

        gp.obj[2] = new OBJ_Mold2();
        gp.obj[2].worldX = 60*gp.tileSize;
        gp.obj[2].worldY = 7*gp.tileSize;
        gp.obj[2].name = "Mold2";

        gp.obj[3] = new OBJ_Flo();
        gp.obj[3].worldX = 53*gp.tileSize;
        gp.obj[3].worldY = 2*gp.tileSize;
        gp.obj[3].name = "Flower";

        gp.obj[4] = new OBJ_Mush1();
        gp.obj[4].worldX = 2*gp.tileSize;
        gp.obj[4].worldY = 19*gp.tileSize;
        gp.obj[4].name = "Mushroom1";

        gp.obj[5] = new OBJ_Mush2();
        gp.obj[5].worldX = 3*gp.tileSize;
        gp.obj[5].worldY = 2*gp.tileSize;
        gp.obj[5].name = "Mushroom2";

        gp.obj[6] = new OBJ_Mush3();
        gp.obj[6].worldX = 9*gp.tileSize;
        gp.obj[6].worldY = 2*gp.tileSize;
        gp.obj[6].name = "Mushroom3";

        gp.obj[7] = new OBJ_Door();
        gp.obj[7].worldX = 37*gp.tileSize;
        gp.obj[7].worldY = 65*gp.tileSize;
        gp.obj[7].name = "Door";

        gp.obj[8] = new OBJ_Door();
        gp.obj[8].worldX = 57*gp.tileSize;
        gp.obj[8].worldY = 59*gp.tileSize;
        gp.obj[8].name = "Door";

        gp.obj[9] = new OBJ_Door();
        gp.obj[9].worldX = 58*gp.tileSize;
        gp.obj[9].worldY = 42*gp.tileSize;
        gp.obj[9].name = "Door";

        gp.obj[10] = new OBJ_Door();
        gp.obj[10].worldX = 57*gp.tileSize;
        gp.obj[10].worldY = 30*gp.tileSize;
        gp.obj[10].name = "Door";

        gp.obj[11] = new OBJ_Door();
        gp.obj[11].worldX = 45*gp.tileSize;
        gp.obj[11].worldY = 5*gp.tileSize;
        gp.obj[11].name = "Door";

        gp.obj[12] = new OBJ_Door();
        gp.obj[12].worldX = 8*gp.tileSize;
        gp.obj[12].worldY = 21*gp.tileSize;
        gp.obj[12].name = "Door";

        gp.obj[13] = new OBJ_Key();
        gp.obj[13].worldX = 55*gp.tileSize;
        gp.obj[13].worldY = 68*gp.tileSize;
        gp.obj[13].name = "Key";

        gp.obj[14] = new OBJ_Key();
        gp.obj[14].worldX = 9*gp.tileSize;
        gp.obj[14].worldY = 46*gp.tileSize;
        gp.obj[14].name = "Key";

        gp.obj[15] = new OBJ_Key();
        gp.obj[15].worldX = 38*gp.tileSize;
        gp.obj[15].worldY = 44*gp.tileSize;
        gp.obj[15].name = "Key";

        gp.obj[16] = new OBJ_Key();
        gp.obj[16].worldX = 30*gp.tileSize;
        gp.obj[16].worldY = 19*gp.tileSize;
        gp.obj[16].name = "Key";

        gp.obj[17] = new OBJ_Key();
        gp.obj[17].worldX = 36*gp.tileSize;
        gp.obj[17].worldY = 15*gp.tileSize;
        gp.obj[17].name = "Key";

        gp.obj[18] = new OBJ_Key();
        gp.obj[18].worldX = 38*gp.tileSize;
        gp.obj[18].worldY = 15*gp.tileSize;
        gp.obj[18].name = "Key";

        gp.obj[19] = new OBJ_Alchemist();
        gp.obj[19].worldX = 59*gp.tileSize;
        gp.obj[19].worldY = 69*gp.tileSize;
        gp.obj[19].name = "Alchemist";

        gp.obj[20] = new OBJ_Statue();
        gp.obj[20].worldX = 38*gp.tileSize;
        gp.obj[20].worldY = 64*gp.tileSize;
        gp.obj[20].name = "Statue";

        gp.obj[21] = new OBJ_Statue();
        gp.obj[21].worldX = 38*gp.tileSize;
        gp.obj[21].worldY = 66*gp.tileSize;
        gp.obj[21].name = "Statue";


    }
}
