import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;
import java.util.Objects;

public class Character {
    private int x, y, height, width;

    private boolean steps = true;
    private BufferedImage character;
    private JPanel panel;
    public Character(JPanel panel){

        try {
            character = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("character/front1.png")));
        }
        catch(Exception e){
            System.out.println(e.toString());
            e.printStackTrace();
        }

        height = character.getHeight();
        width = character.getWidth();

        this.panel = panel;
        x = 720;
        y = 600 - height;

    }


public void draw(Graphics g){

   Graphics2D g2 = (Graphics2D) g;
   g2.drawImage(character, x, y, null);

}
    public void moveUp(){
       if (y > 0) {
           y -= 10;
           try {
               if (steps == true) {
                   character = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("character/back1.png")));
                   steps = false;
               } else {
                   character = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("character/back2.png")));
                   steps = true;
               }
           } catch (Exception e) {
               System.out.println(e.toString());
               e.printStackTrace();
           }
       }
    }

    public void moveDown(){
        if(y + height < panel.getHeight()) {
            y += 10;
            try {
                if (steps) {
                    character = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("character/front1.png")));
                    steps = false;
                } else {
                    character = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("character/front2.png")));
                    steps = true;
                }
            } catch (Exception e) {
                System.out.println(e.toString());
                e.printStackTrace();
            }
        }
    }

    public void moveLeft(){
        if(x > 0) {
            x -= 10;
            try {
                if (steps) {
                    character = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("character/left1.png")));
                    steps = false;
                } else {
                    character = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("character/left2.png")));
                    steps = true;
                }
            } catch (Exception e) {
                System.out.println(e.toString());
                e.printStackTrace();
            }
        }
    }

    public void moveRight(){
       if(x + width < panel.getWidth()) {
           x += 10;
           try {
               if (steps) {
                   character = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("character/right1.png")));
                   steps = false;
               } else {
                   character = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("character/right2.png")));
                   steps = true;
               }
           } catch (Exception e) {
               System.out.println(e.toString());
               e.printStackTrace();
           }
       }
    }


    public int getX(){
        return x;
    }

    public int getY(){
        return y;
    }

    public int getWidth(){
        return width;
    }

    public int getHeight(){
        return height;
    }




}
