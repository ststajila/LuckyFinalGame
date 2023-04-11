import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Objects;

public class Star extends Items {

    private BufferedImage img;
    private int size = (int)(Math.random()*100)+50;

    public Star (Panel panel){
        super(panel, true, (int)(Math.random() * (panel.getWidth()-100)), (int)(Math.random()* (panel.getHeight()-100)));

        try{
            img = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("stars/star.png")));
        } catch (Exception e){

        }

        img = resize(img, size, size);
    }

    @Override
    public void drawItem(Graphics g){
        g.setClip(new Rectangle(getX(), getY(), size, size));
        g.drawImage(img, getX(), getY(), null);
    }

    @Override
    public void moveItem(){

    }

    @Override
    public boolean isTouch(Character character) {
        return getX() < character.getX() + character.getWidth() &&
                getX() + size > character.getX() &&
                getY() < character.getY() + character.getHeight() &&
                getY() + size > character.getY();
    }
}
