import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Objects;

public class Spaceship{
    private BufferedImage image;
    private int x;
    private int y;
    private int xSpeed = (int)(Math.random()*10)+1;
    private int height = 180;
    private int length = 200;

    public Spaceship(JPanel panel){
        try{
            image = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("spaceship/spaceship.png")));
        } catch(Exception e){

        }

        x = -1 * length - 10;
        y =(int)(Math.random() * (panel.getHeight() - height));

    }

    public void draw(Graphics g){
        g.setClip(new Rectangle(x, y, length, height));
        g.drawImage(image, x, y, length, height,null);
    }

    public void move(JPanel panel){
            x = x + xSpeed;
    }

    public boolean isTouch(Character character) {
        return x < character.getX() + character.getWidth() &&
                x + length > character.getX() &&
                y < character.getY() + character.getHeight() &&
                y + height > character.getY();
    }

    public int getX(){
        return x;
    }

    public int getY(){
        return y;
    }
}
