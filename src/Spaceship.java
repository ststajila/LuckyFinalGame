import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Objects;

public class Spaceship{
    private BufferedImage image;
    private int x;
    private int y;
    private int xSpeed = (int)(Math.random()*3)+1;
    private int ySpeed = (int)(Math.random()*3)+1;
    private int height = 50;
    private int length = height * 3;

    public Spaceship(JPanel panel){
        try{
            image = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("spaceship/spacecraft.png")));
            image = resize(image, length, height);
        } catch(Exception e){

        }

        x = -1 * length;
        y =(int)(Math.random() * (panel.getHeight()-height));

    }

    public void drawItem(Graphics g){
        g.setClip(new Rectangle(x, y, length, height));
        g.drawImage(image, x, y, length, height,null);
    }

    public void  move(JPanel panel){
        x += xSpeed;
        y += ySpeed;
    }

    public boolean isTouch(Character character) {
        return x < character.getX() + character.getWidth() &&
                x + length > character.getX() &&
                y < character.getY() + character.getHeight() &&
                y + height > character.getY();
    }

    public BufferedImage resize(BufferedImage img, int newW, int newH) {
        int w = img.getWidth();
        int h = img.getHeight();
        BufferedImage dimg = new BufferedImage(newW, newH, img.getType());
        Graphics2D g = dimg.createGraphics();
        g.setRenderingHint(RenderingHints.KEY_INTERPOLATION,
                RenderingHints.VALUE_INTERPOLATION_BILINEAR);
        g.drawImage(img, 0, 0, newW, newH, 0, 0, w, h, null);
        g.dispose();
        return dimg;
    }

    public int getX(){
        return x;
    }

    public int getY(){
        return y;
    }
}
