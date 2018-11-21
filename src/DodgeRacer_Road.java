
import java.awt.*;
import javax.swing.*;


public class DodgeRacer_Road 
{
    Image road;
    int RoadXpos,RoadYpos,RoadY2pos,RoadDy;
    
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
