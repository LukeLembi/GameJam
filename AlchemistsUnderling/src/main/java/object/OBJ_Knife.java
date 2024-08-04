package object;

import javax.imageio.ImageIO;
import java.io.IOException;

public class OBJ_Knife extends SuperObject {
    public OBJ_Knife(){
        String name = "Knife";
        try{
            image = ImageIO.read(getClass().getClassLoader().getResourceAsStream("objects/knife.png"));

        }catch (IOException e){
            e.printStackTrace();
        }
    }
}