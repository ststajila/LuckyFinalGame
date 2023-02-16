import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Panel extends JPanel {

   Character character = new Character();

    public Panel(){
        setBackground(Color.BLACK);

        this.setFocusable(true);
        this.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {

            }

            @Override
            public void keyPressed(KeyEvent e) {
                System.out.println(e.getKeyCode());
            }

            @Override
            public void keyReleased(KeyEvent e) {

            }
        }
    );
    }

    @Override
    protected void  paintComponent(Graphics g){
        super.paintComponent(g);

        character.draw(g);

        repaint();
    }
}
