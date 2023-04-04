import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

abstract public class Items {
    private int x;
    private int y;
    private boolean status;


        public Items (JPanel panel, boolean status,int x, int y){

            this.x = x;
            this.y = y;
            this.status = status;
        }

        public int getX(){
            return x;
        }

        public int getY(){
            return y;
        }

        public boolean getStatus(){
            return status;
    }
        public void setY(int value){
            y = value;
    }

        public abstract void drawItem(Graphics g);
        public abstract void moveItem();
        public abstract boolean isTouch(Character character);

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

}
