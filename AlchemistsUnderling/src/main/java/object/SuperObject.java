package object;

import main.GamePanel;

import java.awt.*;
import java.awt.image.BufferedImage;

// hlavní (parent) třída všech objektů - podobně jako je Entity vůči Player
public class SuperObject {

    public BufferedImage image;
    public String name;
    public boolean collision = false;
    public int worldX, worldY;
    public Rectangle solidArea = new Rectangle(0, 0, 48, 48); // celé by bylo asi 64 (16x4)
    public int solidAreaDefaultX = 0;
    public int solidAreaDefaultY = 0;

    public void draw(Graphics2D g2, GamePanel gp){
        int screenX = worldX - gp.player.x+gp.player.screenX;
        int screenY = worldY - gp.player.y+gp.player.screenY;

        if(worldX+gp.tileSize>gp.player.x - gp.player.screenX && worldX-gp.tileSize<gp.player.x + gp.player.screenX && worldY+gp.tileSize>gp.player.y - gp.player.screenY && worldY-gp.tileSize<gp.player.y + gp.player.screenY){

            g2.drawImage(image, screenX, screenY, gp.tileSize, gp.tileSize,  null);}
    }
}
