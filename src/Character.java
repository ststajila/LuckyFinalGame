import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;

public class Character {
    int x, y;

    Rectangle rectangle = new Rectangle(10, 10, 87, 158);
    BufferedImage front1;
    //Image front2 = new Image("character/front2.png");


    public Character(){
        front1 = ImageIO.read(getClass().getResourceAsStream("front1"));

    }


public void draw(Graphics g, JPanel panel){

   g.drawImage(front1, 10, 20, panel)


}


    public void move(){


        try {
            Thread.sleep(10);
        }
        catch(Exception e){

        }

    }

}
