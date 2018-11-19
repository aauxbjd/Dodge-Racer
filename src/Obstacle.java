
import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.Random;
import javax.swing.*;

public class Obstacle {

    Image img;
    int x, y, dy;
    Random rand = new Random();

    public Obstacle(String ObLocation) {

        x = setX();
        y = -500;
        ImageIcon l = new ImageIcon(ObLocation);
        img = l.getImage();

    }

    public Rectangle getBounds() {
        return new Rectangle(x, y, 60, 100);
    }

    public int setX() {
        x = rand.nextInt(351);
        return x;
    }

//    public int setY()
//    {
//        y = rand.nextInt(-150);
//        return y;
//    }
//     
    public Image getImage() {
        return img;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void move() {
        y = y + dy;
    }

}
