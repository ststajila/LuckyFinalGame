import javax.swing.*;
import java.awt.*;

public class Main {
    public static void main(String[] args) {
        JLabel label = new JLabel("Hello");
        JFrame frame = new JFrame();
        frame.setSize(1080, 720);
        frame.setLayout(new BorderLayout());
        Panel panel = new Panel();
        frame.add(panel, BorderLayout.CENTER);
        frame.add(label, BorderLayout.NORTH);
        frame.setVisible(true);
    }
}