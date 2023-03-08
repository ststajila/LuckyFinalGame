import java.awt.*;
import java.awt.image.*;
import javax.imageio.ImageIO;
import javax.swing.*;
public class Grades {
    private BufferedImage a;
    private int x, y;
    private int size = 30;

    public Grades(JPanel panel){
        try {
            a =ImageIO.read(getClass().getResource("grades/a.png"));
            a = resize(a, size, size);
        } catch (Exception e){
            e.toString();
        };
        x = (int)(Math.random()*(panel.getWidth()+1));
        y = (int)(Math.random()*(panel.getHeight()+1));
        System.out.println(panel.getHeight());
    }

    public void draw(Graphics g){

        Graphics2D g2 = (Graphics2D) g;
        g2.drawImage(a, x, y, null);

    }

    public static BufferedImage resize(BufferedImage img, int newW, int newH) {
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

