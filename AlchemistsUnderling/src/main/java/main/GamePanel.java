package main;

import entity.Entity;
import entity.Player;
//import enviroment.EnviManager;
import object.SuperObject;
import tile.TileManager;

import javax.swing.*;
import java.awt.*;

// třída dědí JPanel class
public class GamePanel extends JPanel implements Runnable {

    //Nastavení obrazu
    final int originalTileSize = 16; // 16x16 tile - jedno pole má 16x16 pixelů
    final int scale = 4; //integer kolikrát větší chceme aby pole bylo oproti originálu

    public final int tileSize = originalTileSize*scale;// 16x4 - i když děláme hru 16x16, zobrazí se jako 64x64 - z final se změnilo na public, protože se využívá v jiných balících
    public final int maxColumn = 19; // kolik sloupců polí chceme, aby se zobrazilo na obrazovce
    public final int maxRows = 11; // kolik řad polí chceme, aby se zobrazilo na obrazovce
    public final int gameWidth = tileSize*maxColumn; // výpočet polí na šířku (sloupce*velikost)
    public final int gameHeight = tileSize*maxRows;// výpočet polí na výšku (řady*velikost)

    // World Settings
    public final int maxWorldColumn = 70;
    public final int maxWorldRows = 72;
    public final int worldWidth = tileSize*maxWorldColumn;
    public final int worldHeight = tileSize*maxWorldRows;

    //FPS
    int FPS = 60;

    //Entity and Object
    //public Entity obj[] = new Entity[15];
  //  public InteractiveTile iTile [][] = new InteractiveTile[maxMap][20];


    TileManager tileM = new TileManager(this);
    KeyHandler keyH = new KeyHandler();
   // EnviManager eManager = new EnviManager(this);
    Thread gameThread; // nastaví běh hry - je potřeba implementovat Runnable
    public CollisionChecker cChecker = new CollisionChecker(this);
    public AssetSetter setter = new AssetSetter(this);
    public Player player = new Player(this,keyH);
    public SuperObject obj[] = new SuperObject[30];
    // práce a přechod na více map


    // konstruktor herního panelu
    public GamePanel(){
        this.setPreferredSize(new Dimension(gameWidth, gameHeight)); // nastaví rozměry této třídy (Jpanel)
        this.setBackground(Color.black); // nastaví pozadí hry na černou barvu - přesně se hodí k první verzi hry (DOS-like)

        this.setDoubleBuffered(true); // pokud se nastaví true, všechny kresby z tohoto komponentu budou udělány mimo obrazovku
        // anglický text: if set true, all the drawing from this component will be done in an offscreen painting buffer
        // toto nastavení by mělo zlepšit renderování a výkon hry

        this.addKeyListener(keyH); // pozná input klávesy
        this.setFocusable(true); // takto se tento GamePanel může "soustředit" ná získání inputu klávesy
    }
    public void setupGame(){
        setter.setObject();
     //   eManager.setup();
    }

    public void startGameThread(){
        gameThread = new Thread(this); // passing GamePanel class (pozn. nevím přímý český překlad)
        gameThread.start(); // automaticky zavolá metodu run

    }

    @Override
    public void run() {
        // zde vytvoříme Herní cyklus (Game Loop) jakožto jádro hry

//jsou 2 metody - "sleep" a "delta/accumulator" - v současnosti použiji "Delta"
        double drawInterval = 1000000000/FPS;
        double delta = 0;
        long lastTíme = System.nanoTime();
        long currentTime;


        while (gameThread !=null){ // dokud gameThread existuje(běží) bude opakovat proces, který je napsaný uvnitř složených závorek

/**
            // vytvoření aktuálního času, abychom mohli nastavit proces, který bude určovat FPS
            long currentTime = System.nanoTime(); // vrátí(zobrazí) současnou hodnotu JVM "high-resolution time source" v nanosekundách ( 1 sek = 1 miliarda nano sekund)
            long currentTime2 =System.currentTimeMillis(); // vrátí současnou hodnotu v milisekundách - je ok jí použít také ale nano je preciznější
*/
        currentTime = System.nanoTime();
        delta += (currentTime-lastTíme) / drawInterval;
        lastTíme = currentTime;

        if(delta >= 1) {
            // 1 UPDATE: update informací jako pozice postavy
            update();
            // 2 DRAW (Vykreselení): vykreslí obrazovku s updatovanými informacemi
            repaint(); // takto se zavolá metoda paintComponent
            delta--;

        }

        }

    }
    public void update() {
        player.update();
    }

    public void paintComponent(Graphics g) { // nejedná se o orignální název - je to standardní metoda vykreslování na JPanelu - existují však i jiné způsoby kreslení/vykreslování
        super.paintComponent(g); // formát, kdykoliv chci použít tuto metodu paintComponents na Jpanelu, je potřeba to napsat
        // super = parent Class of this Class - třída rodič je v tomto případě JPanel, protože GamePanel je podtřída JPanelu

        // před použitím Graphics konvertujeme na třidu Graphics2D
        Graphics2D g2 = (Graphics2D) g; // má více funkcí než Graphics

       tileM.draw(g2); // zavolá metodu draw uvnitř TileManager - napsat tuto metodu před player.draw(g2), aby nejprve vykreslila pozadí(bloky) a poté až hráče
        for (int i = 0; i < obj.length; i++){
            if(obj[i] != null){
                obj[i].draw(g2, this);
            }

        }
     //   eManager.draw(g2);
        player.draw(g2);

        /* toto zde bylo původně - zanecháno v rámci tutoriálu
        g2.setColor(Color.white); // nastaví barvu na kreslení objektů
        g2.fillRect(pX, pY, tileSize, tileSize);// nakreslí obdelník a vyplní ho specifickou barvou - chce polohu (x,y), šířku a výšku

         */
        g2.dispose(); // en text: Dispose of this graphics context and release any system resources that is using - program funguje i bez tohoto, ale jedná se o dobrou praktiku jak ušetřit paměť



    }
}

    /**
     * v lokaci X představuje horizontální (vodorovnou) polohu (levá - pravá), kde 0 začíná úplně vlevo
     * v lokaci Y představuje vertikální (svislou) polohu (nahoru - dolu), kde 0 začíná úplně nahoře
     * tím pádem X:0 a Y:0 je levý horní roh
     * */