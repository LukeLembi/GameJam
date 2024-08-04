package object;

import javax.imageio.ImageIO;
import java.io.IOException;

// klíč
public class OBJ_Mold1 extends SuperObject {
    public OBJ_Mold1(){
        String name = "Mold1";
        try{
            image = ImageIO.read(getClass().getClassLoader().getResourceAsStream("objects/mold1.png"));

        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
