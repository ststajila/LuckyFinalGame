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
    private BufferedImage win;
    private BufferedImage lose;
    private Character character = new Character(this);

    private Spaceship spaceship = new Spaceship(this);
    private ArrayList<Items> items = new ArrayList<Items>();
    private static int amountOfItems = 10;
    private int amountOfLives = 5;
    private int amountOfStars = 0;
    private boolean spaceshipStatus = false;
    private boolean status = false;


    public Panel() {

        setBackground(Color.GREEN);
        setFocusable(true);
        addKeyListener(new KeyListener() {
                           @Override
                           public void keyTyped(KeyEvent e) {

                           }

                           @Override
                           public void keyPressed(KeyEvent e) {
                               if (e.getKeyCode() == 38 || e.getKeyCode() == 87) {
                                   character.moveUp();
                               }
                               if (e.getKeyCode() == 40 || e.getKeyCode() == 83) {
                                   character.moveDown();
                               }
                               if (e.getKeyCode() == 37 || e.getKeyCode() == 65) {
                                   character.moveLeft();
                               }
                               if (e.getKeyCode() == 39 || e.getKeyCode() == 68) {
                                   character.moveRight();
                               }
                           }

                           @Override
                           public void keyReleased(KeyEvent e) {

                           }
                       }
        );

        int starPosition = (int) (Math.random() * amountOfItems);
        for (int i = 0; i < amountOfItems; i++) {

            if (i != starPosition) {
                items.add(new Comets(this));
            } else {
                items.add(new Star(this));
            }
        }

        try {
            background = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("background/background.jpg")));
        } catch (Exception e) {

        }

        try {
            win = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("background/won.jpeg")));
            lose = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("background/lose.jpeg")));
        } catch (Exception e){

        }

    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        g.drawImage(background, 0, 0, this.getWidth(), this.getHeight(), null);
        character.draw(g);



        for (int i = 0; i < items.size(); i++) {
            items.get(i).moveItem();
            items.get(i).drawItem(g);

            if (!items.get(i).getStatus()) {
                if (items.get(i).isTouch(character)) {
                    amountOfLives--;
                    Main.label.setText(toString());
                    System.out.println("Amount Of Lives: " + amountOfLives);
                    items.remove(i);
                    items.add(new Comets(this));
                    if (amountOfLives <= 0) {
                        Main.label.setText(toString());
                        break;
                    }
                } else if (items.get(i).getY() > this.getHeight()) {
                    items.set(i, new Comets(this));
                }
            } else if (items.get(i).isTouch(character)) {
                items.set(i, new Star(this));
                amountOfStars++;
                Main.label.setText(toString());
                System.out.println("Amount of stars: " + amountOfStars);
            }


            }

        if (amountOfStars != 0 && amountOfStars % 1 == 0 && !spaceshipStatus){
            spaceship = new Spaceship(this);
            System.out.println("Created");
            spaceshipStatus = true;
        }

        if (spaceshipStatus) {
            if (spaceshipStatus) {
                spaceship.draw(g);
                spaceshipStatus = true;
            }

            if (spaceship.getX() < getWidth() && spaceshipStatus) {
                spaceship.move(this);
            } else {
                spaceship = null;
                spaceshipStatus = false;
            }
        }


        try {
            Thread.sleep(10);
        } catch (Exception e) {
            System.out.println(e.toString());
        }


        if (amountOfLives > 0 && (spaceship == null || !spaceship.isTouch(character))) {
            repaint();
        } else if (spaceship.isTouch(character)){
            System.out.println("You won!");
            g.setClip(0, 0, this.getWidth(), this.getHeight());
            g.drawImage(win, 0, 0, this.getWidth(), this.getHeight(), null);
            status = true;
        } else {
            System.out.println("Done");
            g.setClip(0, 0, this.getWidth(), this.getHeight());
            g.drawImage(lose, 0, 0, this.getWidth(), this.getHeight(), null);
        }

    }

    public String toString(){
            return "Amount of lives: " + amountOfLives + "   Amount of stars: " + amountOfStars;
    }
}
