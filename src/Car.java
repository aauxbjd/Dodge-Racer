
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import javax.swing.ImageIcon;

public class Car 
{
    Image carImage;
    int carXpos, carYpos;
    
    
    public Car()
    {
        ImageIcon imageFile = new ImageIcon("car.png");
        carImage = imageFile.getImage();
        carXpos  = 180;
        carYpos  = 450;
        
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
    
}