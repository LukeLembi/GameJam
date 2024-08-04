package object;

import javax.imageio.ImageIO;
import java.io.IOException;

// klíč
public class OBJ_Mold2 extends SuperObject {
    public OBJ_Mold2(){
        String name = "Mold2";
        try{
            image = ImageIO.read(getClass().getClassLoader().getResourceAsStream("objects/mold2.png"));

        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
