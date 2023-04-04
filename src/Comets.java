import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Objects;

public class Comets extends Items{

    private BufferedImage cometImg;
    private int width = (int)(Math.random()*100)+30;
    private int height = width * 3;;
    private int ySpeed;

    public Comets(JPanel panel){

        super(panel, false, (int)(Math.random()* panel.getWidth()-50), -90);

        try{
            cometImg = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("comets/comet.png")));
            resize(cometImg, width, height);
        } catch(Exception e){

        }
        ySpeed = (int)(Math.random()*3)+1;

    }

    @Override
    public void drawItem(Graphics g){
        g.setClip(new Rectangle(getX(), getY(), width, height));
        g.drawImage(cometImg, getX(), getY(), null);
    }

    public void moveItem(){

        setY(getY() + ySpeed);
    }

    public int getWidth(){
        return width;
    }

    public int getHeight(){
        return height;
    }

    @Override
    public boolean isTouch(Character character) {
        return getX() < character.getX() + character.getWidth() && getX() + width > character.getX() && getY() + height - width < character.getY() + character.getHeight() && getY() + height > character.getY();
    }


}
