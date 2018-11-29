
import java.awt.*;
import javax.swing.*;


public class DodgeRacer_Road 
{
    Image road;
    public static int RoadXpos,RoadYpos,RoadY2pos;
    
    public DodgeRacer_Road()
    {
        ImageIcon roadImg = new ImageIcon("road1.png");
        road = roadImg.getImage();
        RoadXpos = 0;
        RoadYpos = -339;
        RoadY2pos = -1339;
    }
    
    public void scroll()
    {
        RoadYpos+=5;
        RoadY2pos+=5;
        
        if (getRoadYpos()>=661)             // puts the first road image to top after it ends
            setRoadYpos();
        if (getRoadY2pos()>=661)           // puts the second road image to top after it ends
            setRoadY2pos();
        
    }
    
    public Image getImage()
    {
      return road;  
    }
    
    public int getRoadYpos()
    {
        return RoadYpos;
    }
    
      public int getRoadY2pos()
    {
        return RoadY2pos;
    }
      
      public void setRoadYpos()
    {
        RoadYpos = -1339;
    }
    
      public void setRoadY2pos()
    {
        RoadY2pos = -1339;
    }
    
}
