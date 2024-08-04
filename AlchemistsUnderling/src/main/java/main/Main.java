package main;
/*
 herní projekt pro Pirate Software's Game Jam (od 17.7. do 31.7.)
 první kód: 23.07.
 hra je uzpůsobena dle tutoriálu od RyiSnow

 /*
  komentáře jsou převážně v češtině, kromě těch částí, které jsem nedokázal řádně přeložit nebo doplnit - názvy zůstávají v angličtině, abych se vyhl konstantnímu překladu (v současnosti jde spíše o dokončení projektu než konzistenci)
  comments are mostly in czech language, except parts that i couldn't translate properly or i just don't understand them - names are in english to avoid translating everything
 */


import javax.swing.*;

public class Main {
    public static void main(String[] args) {

        JFrame gameWindow = new JFrame (); // zavolá spuštění okna
        gameWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // okno se může jednoduše zavřít, když uživatel klikne na tlačítko "x"
        gameWindow.setResizable(false); // nelze změnit velikost okna
        gameWindow.setTitle("Alchemist's underling"); // nastaví název hry

        // použití třídy GamePanel v Main
        GamePanel gamePanel = new GamePanel();
        gameWindow.add(gamePanel); // přida gamePanel do JFrame gameWindow
        gameWindow.pack(); // způsobí že velikost okna bude nastavena preferované velikosti a layoutu je ho ostatních komponentů (subcomponents)


        gameWindow.setLocationRelativeTo(null); // nespecifikuje místo kde se okno otevře, takže se otevře uprostřed obrazovky
        gameWindow.setVisible(true);

        gamePanel.setupGame();
        gamePanel.startGameThread();


    }
}

/*
základní mechaniky:
běh času - některé hry čekají než hráč něco udělá, některé běží konstantně
 */