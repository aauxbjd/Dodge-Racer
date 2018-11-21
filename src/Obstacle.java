
import java.awt.*;
import java.util.Random;
import javax.swing.*;

public class Obstacle 
{
    final int OBSTACLE_WIDTH = 80;
    final int OBSTACLE_LENGTH = 130;
    
    Image obstacleImg;
    int obstacleXpos, obstacleYpos, obstacleDYpos;
    Random randomX = new Random();
    
    public Obstacle()
    {
        ImageIcon obstacleImgFile = new ImageIcon("ob1.png");
        obstacleImg = obstacleImgFile.getImage();
        obstacleYpos = -200;
        
        
    }
    
     public Rectangle getBounds() 
    {
        return new Rectangle(obstacleXpos+20,obstacleYpos+20, OBSTACLE_WIDTH-20, OBSTACLE_LENGTH-20);
    }
    
    public void move()
    {
        obstacleYpos += 5;
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
        obstacleYpos = -200;
    }
        public void setObstacleXpos()
    {
        obstacleXpos = randomX.nextInt(251+100) ;
    }

}
