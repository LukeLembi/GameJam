package tile;

import main.GamePanel;


import javax.imageio.ImageIO;
import java.awt.*;
import java.io.*;

public class TileManager {
    GamePanel gp;
   public Tile[] tile;

   // kód pro načtení "mapy" vytvořené v txt formátu
    public int mapTileNum[][];

    // konstruktor
    public TileManager(GamePanel gp){
        this.gp = gp;
        // počet typů bloků
        tile = new tile.Tile[10];

        mapTileNum = new int[gp.maxWorldColumn][gp.maxWorldRows];
        getTileImage();
        loadMap("maps/map.txt");

    }

    // metoda
    public void getTileImage(){
// zavolání obrázků do programu a určení jejich pozice v poli
        try{
            tile[0] = new Tile();
            tile[0].image = ImageIO.read(getClass().getClassLoader().getResourceAsStream("tiles/floor.png"));

            tile[1] = new Tile();
            tile[1].image = ImageIO.read(getClass().getClassLoader().getResourceAsStream("tiles/wall.png"));
            tile[1].collision = true;

            tile[2] = new Tile();
            tile[2].image = ImageIO.read(getClass().getClassLoader().getResourceAsStream("tiles/water.png"));
            tile[2].collision = true;

            tile[3] = new Tile();
            tile[3].image = ImageIO.read(getClass().getClassLoader().getResourceAsStream("tiles/fall.png"));

            tile[4] = new Tile();
            tile[4].image = ImageIO.read(getClass().getClassLoader().getResourceAsStream("tiles/blank.png"));
            tile[4].collision = true;

            tile[5] = new Tile();
            tile[5].image = ImageIO.read(getClass().getClassLoader().getResourceAsStream("tiles/blank2.png"));



        }catch(IOException e){
            e.printStackTrace();
        }

    }
    public void loadMap (String filePath) {
        try {
            InputStream is = getClass().getClassLoader().getResourceAsStream(filePath);
            BufferedReader br = new BufferedReader(new InputStreamReader(is));

            int col = 0;
            int row = 0;

            while (col < gp.maxWorldColumn && row < gp.maxWorldRows) {
                String line = br.readLine(); // read a line of text - jako String
                while (col < gp.maxWorldColumn) {
                    String numbers[] = line.split(" "); // Splits this string around matches of the given regular expression

                    int num = Integer.parseInt(numbers[col]); // je potřeba změnit String na integer

                    mapTileNum[col][row] = num;
                    col++;
                }
                if (col == gp.maxWorldColumn) {
                    col = 0;
                    row++;
                }
            }
            br.close();

        } catch (Exception e) {
        }
    }
    public void draw(Graphics2D g2){
//        g2.drawImage(tile[1].image, 20, 20 , gp.tileSize, gp.tileSize, null);
//        g2.drawImage(tile[0].image, 52, 52 , gp.tileSize, gp.tileSize, null);
// kreslení přes while
        int col = 0;
        int row = 0;

        while (col < gp.maxWorldColumn && row < gp.maxWorldRows){
            int tileNum = mapTileNum[col][row];
            int x = col*gp.tileSize;
            int y = row*gp.tileSize;
            int screenX = x - gp.player.x+gp.player.screenX;
            int screenY = y - gp.player.y+gp.player.screenY;

            if(x+gp.tileSize>gp.player.x - gp.player.screenX && x-gp.tileSize<gp.player.x + gp.player.screenX && y+gp.tileSize>gp.player.y - gp.player.screenY && y-gp.tileSize<gp.player.y + gp.player.screenY){

            g2.drawImage(tile[tileNum].image, screenX, screenY, gp.tileSize, gp.tileSize,  null);}

            col++;

            if(col == gp.maxWorldColumn){
                col =0;
                row++;

            }

        }
    }
}


