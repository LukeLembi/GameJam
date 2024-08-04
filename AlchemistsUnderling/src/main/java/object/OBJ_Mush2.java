package object;

import javax.imageio.ImageIO;
import java.io.IOException;

// klíč
public class OBJ_Mush2 extends SuperObject {
    public OBJ_Mush2(){
        String name = "Mushroom2";
        try{
            image = ImageIO.read(getClass().getClassLoader().getResourceAsStream("objects/mushroom2.png"));

        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
