import javax.swing.*;
import java.awt.*;
import java.awt.image.ImageObserver;

public class Character {
    int x, y;

    Rectangle rectangle = new Rectangle(10, 10, 87, 158);
    ImageIcon front1 = new ImageIcon("character/front1.png");
    ImageIcon front2 = new ImageIcon("character/front2.png");


    public Character(){

    }


public void draw(Graphics g){

    g.setColor(Color.cyan);
    g.fillRect(0, 0, 87, 158);


}


    public void move(){


        try {
            Thread.sleep(10);
        }
        catch(Exception e){

        }

    }

}
