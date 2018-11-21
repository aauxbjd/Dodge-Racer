
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.*;
import javax.swing.ImageIcon;

public class Car 
{
    Image carImage;
    int carXpos, carYpos, carDx;
    
    
    public Car()
    {
        ImageIcon imageFile = new ImageIcon("car.png");
        carImage = imageFile.getImage();
        carXpos  = 180;
        carYpos  = 450;
        
    }
    
    public void move()       
    {
        carXpos += carDx;
    }
            
    
    
    public int getCarXpos()
    {
        return carXpos;
    }
    
    public int getCarYpos()
    {
        return carYpos;
    }
       
    public Image getCarImage()
    {
        return carImage;
    }
    
    //making car move with the arrow keys
    public void keyPressed(KeyEvent e) 
    {
        int key = e.getKeyCode();

        if (key == KeyEvent.VK_LEFT) {
            carDx = -5;
        }

        if (key == KeyEvent.VK_RIGHT) {
            carDx = 5;
        }
    }
    
     public void keyReleased(KeyEvent e) {
        int key = e.getKeyCode();

        if (key == KeyEvent.VK_LEFT) {
            carDx = 0;
        }

        if (key == KeyEvent.VK_RIGHT) {
            carDx = 0;
        }
    }

    
}