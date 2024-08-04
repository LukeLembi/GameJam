package object;

import javax.imageio.ImageIO;
import java.io.IOException;

// klíč
public class OBJ_Soulcore extends SuperObject {
    public OBJ_Soulcore(){
        String name = "Soulcore";
        try{
            image = ImageIO.read(getClass().getClassLoader().getResourceAsStream("others/Soulcore.png"));

        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
