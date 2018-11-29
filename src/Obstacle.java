
import java.awt.*;
import java.util.Random;
import javax.swing.*;

public class Obstacle 
{
    final int OBSTACLE_WIDTH = 80;
    final int OBSTACLE_LENGTH = 130;
    
    int obstacleNumber;
    Image obstacleImg;
    public static int obstacleXpos, obstacleYpos, obstacleDYpos,obstacle2Xpos;
    Random randomX = new Random();
    
    
    public Obstacle(String obstacleFile)
    {
        ImageIcon obstacleImgFile = new ImageIcon(obstacleFile);
        obstacleImg = obstacleImgFile.getImage();
        obstacleYpos = -700;    
    }
    
     public Rectangle getBounds() 
    {
        return new Rectangle(obstacleXpos+20,obstacleYpos+20, OBSTACLE_WIDTH-20, OBSTACLE_LENGTH-20);
    }
    
    public void move()
    {   
        switch (obstacleNumber)
        {
            case 1:
                if (obstacleYpos >= 661)    //making the obstacle disappear after it reaches ebd of bottom frame
                {
                    setObstacleYpos();  //same old Ypos
                    setObstacleXpos();  //new X pos

                }
                obstacleYpos += 5;
                break;
                
            case 2:
                if (obstacleYpos >= 661)    //making the obstacle disappear after it reaches ebd of bottom frame
                {
                    setObstacleYpos();  //same old Ypos
                    setObstacleXpos();  //new X pos

                }
               
                obstacleYpos += 8;
                break;
                
            
                
        }
            
        
        
    }
    
    public Image getObstacleImg()
    {
        return obstacleImg;
    }
    
    public int getObstacleXpos()
    {
        return obstacleXpos;
    }
    
    public int getObstacleYpos()
    {
        return obstacleYpos;
    }
    
        public void setObstacleYpos()
    {
        obstacleYpos = -700;
    }
        public void setObstacleXpos()
    {
        obstacleXpos = randomX.nextInt(351) ;
    }
        

}
