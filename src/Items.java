import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

abstract public class Items {
    private boolean status;

    public Items (JPanel panel, boolean status){
        this.status = status;
    }

        public boolean getStatus(){
            return status;
    }
        public abstract int getX();
        public abstract int getY();

        public abstract void drawItem(Graphics g);
        public abstract void moveItem();
        public abstract boolean isTouch(Character character);

}
