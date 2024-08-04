package object;
import javax.imageio.ImageIO;
import java.io.IOException;

public class OBJ_Statue extends SuperObject {
    public OBJ_Statue(){
        String name = "Statue";
        try{
            image = ImageIO.read(getClass().getClassLoader().getResourceAsStream("others/Statue-small.png"));


        }catch (IOException e){
            e.printStackTrace();
        }
        collision = true;
    }
}