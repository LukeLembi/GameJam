package main;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

// pro nastavení ovládání

// KeyListener - en: The listener interface for receiving keyboard events (keystrokes)
public class KeyHandler implements KeyListener {

    public boolean upPress, downPress, leftPress, rightPress;



    // návrh po zadání - musí se vždy zadat - klávesa napsána(zvolena), stisknuta, puštěna(uvolněna)
    @Override
    public void keyTyped(KeyEvent e) {
    } // nepotřebujeme - zatím, asi

    @Override
    public void keyPressed(KeyEvent e) {
        int code = e.getKeyCode(); // vrátí integer keyCode spojený s klíčem(klávesou) v této události
        // POHYB
        //nahoru
        if(code == KeyEvent.VK_UP){
            upPress = true;

        }
        //dolů
        if(code == KeyEvent.VK_DOWN){
            downPress = true;

        }
        //doleva
        if(code == KeyEvent.VK_LEFT){
            leftPress = true;

        }
        //doprava
        if(code == KeyEvent.VK_RIGHT){
            rightPress = true;

        }
/**
        //OSTATNÍ
        // Interakce - potvrzení
        if(code == KeyEvent.VK_Y || code == KeyEvent.VK_Z){ // důvod proč tam jsou dvě různé klávesy - tlačítka jsou inspirována emulátorem VBA, kde se používá "Y" a "X" jako hlavní tlačítka, anglická klávesnice má však na stejném místě "Z", proto se prozatím zvolili dvě možnosti pro stejné tlačítko

        }
        // negace - případně něco dalšího do budoucna
        if(code == KeyEvent.VK_X){

        }
        // hlavní menu
        if(code == KeyEvent.VK_ENTER){

        }
*/
    }

    @Override
    public void keyReleased(KeyEvent e) {

        int code = e.getKeyCode();
        // zkopírovat kód z keyPressed

        // POHYB
        //nahoru
        if(code == KeyEvent.VK_UP){
            upPress = false;

        }
        //dolů
        if(code == KeyEvent.VK_DOWN){
            downPress = false;

        }
        //doleva
        if(code == KeyEvent.VK_LEFT){
            leftPress = false;

        }
        //doprava
        if(code == KeyEvent.VK_RIGHT){
            rightPress = false;

        }
/**
        //OSTATNÍ
        // Interakce - potvrzení
        if(code == KeyEvent.VK_Y || code == KeyEvent.VK_Z){ // důvod proč tam jsou dvě různé klávesy - tlačítka jsou inspirována emulátorem VBA, kde se používá "Y" a "X" jako hlavní tlačítka, anglická klávesnice má však na stejném místě "Z", proto se prozatím zvolili dvě možnosti pro stejné tlačítko

        }
        // negace - případně něco dalšího do budoucna
        if(code == KeyEvent.VK_X){

        }
        // hlavní menu
        if(code == KeyEvent.VK_ENTER){

        }
*/
    }
}
