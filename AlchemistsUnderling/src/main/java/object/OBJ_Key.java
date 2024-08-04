package object;

import javax.imageio.ImageIO;
import java.io.IOException;

// klíč
public class OBJ_Key extends SuperObject {
    public OBJ_Key(){
        String name = "Key";
        try{
            image = ImageIO.read(getClass().getClassLoader().getResourceAsStream("objects/key.png"));

        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
