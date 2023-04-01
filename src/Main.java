import javax.swing.*;
public class Main {
    public static void main(String[] args) {

        JFrame frame = new JFrame();
        frame.setSize(1080, 720);
        Panel panel = new Panel();

        frame.add(panel);
        frame.setVisible(true);
    }
}