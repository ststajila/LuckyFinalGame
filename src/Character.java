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
        try {
            front1 = ImageIO.read(getClass().getResourceAsStream("character/front1.png"));
        }
        catch(Exception e){
            System.out.println(e.toString());
            e.printStackTrace();
        }
    }


public void draw(Graphics g){

   Graphics2D g2 = (Graphics2D) g;
   g2.drawImage(front1, 0, 0, null);


}


    public void move(){


        try {
            Thread.sleep(10);
        }
        catch(Exception e){

        }

    }

}
