package object;

import javax.imageio.ImageIO;
import java.io.IOException;

// klíč
public class OBJ_Mush3 extends SuperObject {
    public OBJ_Mush3(){
        String name = "Mushroom3";
        try{
            image = ImageIO.read(getClass().getClassLoader().getResourceAsStream("objects/mushroom3.png"));

        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
