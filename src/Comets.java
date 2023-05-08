import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Objects;

public class Comets extends Items{

    private BufferedImage cometImg;
    private int x;
    private int y;
    private int width = (int)(Math.random()*100)+30;
    private int height = width * 3;
    private int ySpeed;

    public Comets(JPanel panel){

        super(panel, false);

        try{
            cometImg = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("comets/comet.png")));
        } catch(Exception e){

        }

        if(panel.getWidth() != 0){
            x = (int)(Math.random() * (panel.getWidth()-width));
            y = -2 * height;
        }
        else {
            x = (int)(Math.random() * (1080 - width));
            y = -2 * height;
        }

        ySpeed = (int)(Math.random()*3)+1;

    }

    @Override
    public void drawItem(Graphics g){
        g.setClip(new Rectangle(x, y, width, height));
        g.drawImage(cometImg, x, y, width, height,null);
    }

    public void moveItem(){
        y += ySpeed;
    }

    public int getX(){
        return x;
    }
    public int getY(){
        return y;
    }

    @Override
    public boolean isTouch(Character character) {
        return x < character.getX() + character.getWidth() && x + width > character.getX() && y + height - width < character.getY() + character.getHeight() && y + height > character.getY();
    }


}
