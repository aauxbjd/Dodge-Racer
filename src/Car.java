
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import javax.swing.ImageIcon;

public class Car {

    int x, y, dx, ny2, ny, dy, nf;
    Image still;

    public Car() {
        ImageIcon i = new ImageIcon("E://car.png");
        still = i.getImage();
        x = 150;
        y = 450;
        ny = 660; //frame size
        ny2 = 0;
        nf = 1340;

    }

    public Rectangle getBounds() {
        return new Rectangle(x, y, 60, 100);
    }

    public void move() {
        x = x + dx;  //for car 

        ny = ny + dy;  //for backimage1
        ny2 = ny2 + dy;  //for backimage2

    }

    public int getNy() {
        return ny;
    }

    public int getNy2() {
        return ny2;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public Image getImage() {
        return still;
    }

    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();

        if (key == KeyEvent.VK_LEFT) {
            dx = -5;
        }

        if (key == KeyEvent.VK_RIGHT) {
            dx = 5;
        }
        if (key == KeyEvent.VK_UP) {
            dy = -5;
        }
    }

    public void keyReleased(KeyEvent e) {
        int key = e.getKeyCode();

        if (key == KeyEvent.VK_LEFT) {
            dx = 0;
        }

        if (key == KeyEvent.VK_RIGHT) {
            dx = 0;
        }
        if (key == KeyEvent.VK_UP) {
            dy = 0;
        }

    }

}
