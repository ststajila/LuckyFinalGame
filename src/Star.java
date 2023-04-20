import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Objects;

public class Star extends Items {

    private BufferedImage img;
    private int size = (int)(Math.random()*100)+50;
    private int x, y;

    public Star (Panel panel){
        super(panel, true);

        try{
            img = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("stars/star.png")));
        } catch (Exception e){

        }

        if(panel.getWidth() != 0){
           x = (int)(Math.random() * (panel.getWidth()-size));
           y = (int)(Math.random()* (panel.getHeight()-size));
        }
        else {
            x = (int)(Math.random() * (1080-size));
            y = (int)(Math.random() * (720-size));
        }
        }

    @Override
    public void drawItem(Graphics g){
        g.setClip(new Rectangle(x, y, size, size));
        g.drawImage(img, x, y, size, size, null);
    }

    @Override
    public void moveItem(){

    }

    @Override
    public boolean isTouch(Character character) {
        return x < character.getX() + character.getWidth() &&
                x + size > character.getX() &&
                y < character.getY() + character.getHeight() &&
                y + size > character.getY();
    }

    public int getX(){
        return x;
    }
    public int getY(){
        return y;
    }
}
