import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Panel extends JPanel {

   Character character = new Character();

    public Panel(){
        setBackground(Color.gray);

        this.setFocusable(true);
        this.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {

            }

            @Override
            public void keyPressed(KeyEvent e) {
                System.out.println(e.getKeyCode());

                if (e.getKeyCode() == 38 || e.getKeyCode() == 87){
                    character.moveUp();
                }
                if (e.getKeyCode() == 40 || e.getKeyCode() == 83){
                    character.moveDown();
                }
                if (e.getKeyCode() == 37 || e.getKeyCode() == 65){
                    character.moveLeft();
                }
                if (e.getKeyCode() == 39 || e.getKeyCode() == 68){
                    character.moveRight();
                }

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
