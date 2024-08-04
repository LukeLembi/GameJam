package entity;

import java.awt.*;
import java.awt.image.BufferedImage;

// tato třída bude obsahovat proměnné pro hráče, monstra a NPC
public class Entity {

    public int x, y;

    public int speed;

    public BufferedImage up1, up2, up3;// en: it describes an Image with an accessible buffer of image data (we use this to store our image files)

    // pro interakci s objekty
    public int solidAreaDefaultX, solidAreaDefaultY;

    /*
    prozatím jen up1 a up2, protože nemáme animaci, takže je zbytečné vytvářet další proměnné
    down1
    down2
    left1
    left2
    right1
    right2
     */

    public String direction; //pro určení směru a jaký obrázek nahrát - platí když budu používat více obrázků

    // část pokud budeme dělat nějakou "animaci"
    public int spriteCounter = 0;
    public int spriteNum = 1;
    public Rectangle solidArea; //ideální třída pro tvorbu neviditelných nebo abstraktních čtyřúhelníků? čtverců, obdelníků? a ukládat data
    public boolean collisionOn = false;
    public boolean collision;
    public String name;
}
