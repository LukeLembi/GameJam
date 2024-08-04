package entity;
// import tříd z balíku main
import main.GamePanel;
import main.KeyHandler;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;


public class Player extends Entity {

    GamePanel gp;
    KeyHandler keyH;
    public final int screenX;
    public final int screenY;
    int hasKey = 0;
    boolean hasKnife =false;

  int hasResource;

    // konstruktor třídy
    public Player (GamePanel gp, KeyHandler keyH){
        this.gp = gp;
        this.keyH = keyH;

        screenX = gp.gameWidth/2 - (gp.tileSize/2);
        screenY = gp.gameHeight/2 - (gp.tileSize/2);

        solidArea = new Rectangle(12, 12, 38, 38) ;
        solidAreaDefaultX = x;
        solidAreaDefaultY = y;

        setDefaultValues();
        getPlayerImage();
    }
    // výchozí postavení postavy
    public void setDefaultValues(){
        x = 58*gp.tileSize;
        y = 70*gp.tileSize;
        speed = 6;
        direction = "down";
    }

    // tuhle část jsem bohužel úplně nepochytil - try/catch mi zatím dělá problémy
    public void getPlayerImage(){
        try {
            up1 = ImageIO.read(getClass().getClassLoader().getResourceAsStream("player/player-1.png"));//zaříkávadlo na vyvolání obrázku
            up2 = ImageIO.read(getClass().getClassLoader().getResourceAsStream("player/player-2.png"));
            up3 = ImageIO.read(getClass().getClassLoader().getResourceAsStream("player/player-3.png"));
        }catch(IOException e) {
            e.printStackTrace();
        }
    }

    public void update(){
        if (keyH.upPress == true || keyH.downPress == true || keyH.rightPress == true || keyH.leftPress == true){

            if (keyH.upPress == true) {
                direction = "up";
                 // zkráceně pY -= pSpeed - platí i pro ostatní
            }
            else if (keyH.downPress == true){
                direction = "down";

            }
            else if( keyH.leftPress == true){
                direction = "left";

            } else if (keyH.rightPress == true) {
                direction = "right";
            }

            // Check tile collision

            collisionOn = false;
            gp.cChecker.checkTile(this);

            // check object collision
           int objIndex = gp.cChecker.checkObject(this, true);
           pickUpObject (objIndex);

            // if collision is false, player can move
            if (collisionOn == false){
                switch (direction){
                    case "up": y = y - speed;
                        break;
                    case "down": y = y + speed;
                        break;
                    case "left": x = x - speed;
                        break;
                    case "right": x = x + speed;
                        break;

                }
            }


            spriteCounter++;
            if (spriteCounter > 15){
                if(spriteNum == 1) {
                    spriteNum = 2;
                } else if (spriteNum == 2) {
                    spriteNum = 3;
                }
                else if (spriteNum == 3) {
                    spriteNum = 1;
                }
                spriteCounter = 0;
            }
        }
    }

    public void pickUpObject (int i){
        if (i != 999){
  //         gp.obj[i] = null;
            String objectName = gp.obj[i].name;

            switch(objectName){
                case "Key":
                    hasKey++;
                    gp.obj[i] = null;
                    break;
                case "Door":
                    if(hasKey > 0){
                        gp.obj[i] = null;
                        hasKey--;
                    }break;
                case "Knife":
                    gp.obj[i] = null;
                    hasKnife = true;
                    break;
                case "Flower":
                case "Mushroom1":
                case "Mushroom2":
                case "Mushroom3":
                    gp.obj[i] = null;
                    hasResource++;
                    System.out.println("Player has: "+ hasResource + " ingredients.");
                    break;
                case "Mold1":
                case "Mold2":
                    if(hasKnife==true) {
                        gp.obj[i] = null;
                        hasResource++;
                        System.out.println("Player has: "+ hasResource + " ingredients.");
                    }
                    break;


            }

        }

    }
    public void draw(Graphics2D g2){
        /*
        g2.setColor(Color.white); // nastaví barvu na kreslení objektů
        g2.fillRect(x, y, gp.tileSize, gp.tileSize);// nakreslí obdelník a vyplní ho specifickou barvou - chce polohu (x,y), šířku a výšku
        */
        BufferedImage image = up1;

        // za normálních okolností bude ve switchi
        if(spriteNum == 1){
            image = up1;
        }
        else if(spriteNum == 2){
            image = up2;
        }
        else if(spriteNum == 3){
            image = up3;
        }

        /* pro případ více obrázků - tutoriál 3 kolem 17.minuty - nemá cenu přepisovat - animace je na posledním místě
        switch (direction) {
        case "up":
            image = up1;
            break;
        case "down":
            image = down1;
            break;
        case "left":
            image = left1;
            break;
        case "right":
            image = right1;
            break;
            }
         */
        g2.drawImage(image, screenX, screenY, gp.tileSize, gp.tileSize, null);
    }



}
