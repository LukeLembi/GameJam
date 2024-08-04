/**
package enviroment;

import main.GamePanel;

import java.awt.*;
import java.awt.geom.Area;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;

public class Lightning {
    GamePanel gp;
    BufferedImage darknessFilter;

    public Lightning(GamePanel gp, int circleSize){

        // Create a buffered image
        darknessFilter = new BufferedImage(gp.gameWidth, gp.gameHeight, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2 = (Graphics2D) darknessFilter.getGraphics();
        // Create a screen-size rectangle area
        Area screenArea = new Area(new Rectangle2D.Double(0, 0, gp.gameWidth, gp.gameHeight));

        // Get the center x and y of the light circle
        //for player
        int centerX = gp.player.screenX + (gp.tileSize)/2;
        int centerY = gp.player.screenY + (gp.tileSize)/2;

        // Get the top left x and Y of the light circle
        //for player
        double playerX = centerX - (circleSize/2);
        double playerY = centerY - (circleSize/2);

        // Create a light cirle shape
        Shape circleShape = new Ellipse2D.Double(playerX, playerY, circleSize, circleSize);

        // Create a light circle area
        Area lightArea = new Area(circleShape);

        //Subtract the light circle from the screen rectangle
        screenArea.subtract(lightArea);

        // Set a color (black) to draw the rectangle
        g2.setColor(new Color(0,0,0,0.85f));

        // Draw the screen rectangle without the light circle area
        g2.fill(screenArea);
        g2.dispose();



    }

    public void draw(Graphics2D g2){
        g2.drawImage(darknessFilter, 0, 0, null);
    }

}
*/