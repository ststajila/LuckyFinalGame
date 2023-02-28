import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;

public class Character {
    int x = 0;
    int y = 0;

    boolean steps = true;
    BufferedImage character;
    public Character(){
        try {
            character = ImageIO.read(getClass().getResourceAsStream("character/front1.png"));
        }
        catch(Exception e){
            System.out.println(e.toString());
            e.printStackTrace();
        }
    }


public void draw(Graphics g){

   Graphics2D g2 = (Graphics2D) g;
   g2.drawImage(character, x, y, null);

}
    public void moveUp(){
        y -= 10;
        try {
            if (steps == true) {
                character = ImageIO.read(getClass().getResourceAsStream("character/back1.png"));
                steps = false;
            }
            else{
                character = ImageIO.read(getClass().getResourceAsStream("character/back2.png"));
                steps = true;
            }
        }
        catch(Exception e){
            System.out.println(e.toString());
            e.printStackTrace();
        }
    }

    public void moveDown(){
        y += 10;
        try {
            if (steps == true) {
                character = ImageIO.read(getClass().getResourceAsStream("character/front1.png"));
                steps = false;
            }
            else{
                character = ImageIO.read(getClass().getResourceAsStream("character/front2.png"));
                steps = true;
            }
        }
        catch(Exception e){
            System.out.println(e.toString());
            e.printStackTrace();
        }
    }

    public void moveLeft(){
        x -= 10;
        try {
            if (steps == true) {
                character = ImageIO.read(getClass().getResourceAsStream("character/left1.png"));
                steps = false;
            }
            else{
                character = ImageIO.read(getClass().getResourceAsStream("character/left2.png"));
                steps = true;
            }
        }
        catch(Exception e){
            System.out.println(e.toString());
            e.printStackTrace();
        }
    }

    public void moveRight(){
        x += 10;
        try {
            if (steps == true) {
                character = ImageIO.read(getClass().getResourceAsStream("character/right1.png"));
                steps = false;
            }
            else{
                character = ImageIO.read(getClass().getResourceAsStream("character/right2.png"));
                steps = true;
            }
        }
        catch(Exception e){
            System.out.println(e.toString());
            e.printStackTrace();
        }
    }


}
