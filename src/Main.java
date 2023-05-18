import javax.swing.*;
import java.awt.*;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

public class Main {
    public static JLabel label;


    public static void main(String[] args) {
        JFrame frame = new JFrame();
        Panel panel = new Panel();
        label = new JLabel(panel.toString());
//        frame.addComponentListener(new ComponentAdapter() {
//            @Override
//            public void componentResized(ComponentEvent e) {
//                //super.componentResized(e);
//
//                //panel.repaint();
//            }
//        });
        frame.setSize(1080, 720);
        frame.setLayout(new BorderLayout());


        frame.add(label, BorderLayout.NORTH);
        frame.add(panel, BorderLayout.CENTER);



        frame.setVisible(true);
    }
}