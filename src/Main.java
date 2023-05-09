import javax.swing.*;
import java.awt.*;

public class Main {
    public static JLabel label;
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setSize(1080, 720);
        frame.setLayout(new BorderLayout());
        Panel panel = new Panel();
        frame.add(panel, BorderLayout.CENTER);
        label = new JLabel(panel.toString());
        frame.add(label, BorderLayout.NORTH);
        frame.setVisible(true);
    }
}