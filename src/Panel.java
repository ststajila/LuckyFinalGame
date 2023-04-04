import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Objects;

public class Panel extends JPanel {

    private BufferedImage background;
    private Character character = new Character(this);
    private ArrayList <Items> items = new ArrayList<Items>();
    private static int amountOfItems = 6;


    public Panel(){

        setBackground(Color.GREEN);

        setFocusable(true);
        addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {

            }

            @Override
            public void keyPressed(KeyEvent e) {
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

    for(int i = 0; i < amountOfItems; i++){

        //if (i != (int)(Math.random()*amountOfItems)) {
            items.add(new Comets(this));
        //}
        //else{
            items.add(new Star(this));
        //}
    }

        try{
            background = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("background/background.jpg")));
        } catch(Exception e){

        }
    }

    @Override
    protected void  paintComponent(Graphics g) {
        super.paintComponent(g);

        g.drawImage(background, 0, 0, this.getWidth(), this.getHeight(), null);
        character.draw(g);

     for(int i = 0; i < items.size(); i++) {
         items.get(i).moveItem();
         items.get(i).drawItem(g);

         if (!items.get(i).getStatus()) {
             if (items.get(i).getY() > this.getHeight()) {
                 items.set(i, new Comets(this));
             }
         }
         else if (items.get(i).isTouch(character)){
             items.set(i, new Star(this));
             System.out.println("Touch!");
         }

     }

        try{
            Thread.sleep(10);
        }
        catch(Exception e){
            System.out.println(e.toString());
        }

        repaint();
    }

}
