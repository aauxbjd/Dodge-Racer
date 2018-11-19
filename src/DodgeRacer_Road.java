
import java.awt.*;
import javax.swing.*;


public class DodgeRacer_Road 
{
    Image road;
    int RoadXpos,RoadYpos,RoadDy;
    
    public DodgeRacer_Road()
    {
        ImageIcon roadImg = new ImageIcon("E://road1.png");
        road = roadImg.getImage();
        RoadXpos = 0;
        RoadYpos = -339;
    }
    
    public void scroll()
    {
        RoadYpos+=5;
        
    }
    
    public Image getImage()
    {
      return road;  
    }
    
    public int getRoadYpos()
    {
        return RoadYpos;
    }
    
}
