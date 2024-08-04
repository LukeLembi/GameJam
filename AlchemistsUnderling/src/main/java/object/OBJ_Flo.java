package object;

import javax.imageio.ImageIO;
import java.io.IOException;

// klíč
public class OBJ_Flo extends SuperObject {
    public OBJ_Flo(){
        String name = "Flower";
        try{
            image = ImageIO.read(getClass().getClassLoader().getResourceAsStream("objects/flower.png"));

        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
