package object;
import javax.imageio.ImageIO;
import java.io.IOException;

public class OBJ_Alchemist extends SuperObject {
    public OBJ_Alchemist(){
        String name = "Alchemist";
        try{
            image = ImageIO.read(getClass().getClassLoader().getResourceAsStream("others/alchemist.png"));


        }catch (IOException e){
            e.printStackTrace();
        }
        collision = true;
    }
}