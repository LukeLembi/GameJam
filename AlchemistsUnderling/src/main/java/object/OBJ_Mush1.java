package object;

import javax.imageio.ImageIO;
import java.io.IOException;

// klíč
public class OBJ_Mush1 extends SuperObject {
    public OBJ_Mush1(){
        String name = "Mushroom1";
        try{
            image = ImageIO.read(getClass().getClassLoader().getResourceAsStream("objects/mushroom1.png"));

        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
