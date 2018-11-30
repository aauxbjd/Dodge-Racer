/*

Authors : Ayush Banjade, safin Bjagai, Sagar Pandeya
Date :    11/30/2018

This is a car racing game based on java

Functions:
1. Save game (can use 'S' shortcut key to save)
2. Load game (can use 'A' shortcut key to load previously saved game)
3. Pause game ( use 'P' to pause and resume back)
4. Saves your score in a file which you can view in a Jwindow

*/

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
