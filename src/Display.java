import java.awt.*;
import java.awt.event.*;
import javax.swing.*;



public class Display extends JPanel implements ActionListener
{
    DodgeRacer_Road Road = new DodgeRacer_Road();
    Car playerCar = new Car();
    Obstacle obstacle1 = new Obstacle("ob1.png");
    Obstacle obstacle2 = new Obstacle("ob2.png");
    
    Timer time;
    int score;
    boolean lost = false;
    
    public Display()
    { 
        setFocusable(true);                      //setting focus to the screen
        addKeyListener(new ActionListener());    //adding keylistener on the screen
        time = new Timer(5,this);                // this calls actionPerformed every 5 miliseconds
        time.start();

    }
   
     public void actionPerformed(ActionEvent e)
    {
         
        repaint();
 
        Road.scroll();                         //updates road's xPos by adding 5
        playerCar.move();
        
        obstacle1.obstacleNumber=1;
        obstacle1.move();
        
        if(score>=2)
        {
           obstacle2.obstacleNumber=2;
//           if ( obstacle2.getObstacleXpos() - obstacle1.getObstacleXpos() <= 60 || obstacle1.getObstacleXpos() - obstacle2.getObstacleXpos() <= 60)
//           {
//              obstacle2.setObstacleXpos();
//           }
          
           obstacle2.move();
        }
         
        checkCollision();

        score();
         
        if(lost == true)
        {
            score=0;
            lost = false;
            obstacle2.setObstacleYpos();
        }
         
    }
     
     public void checkCollision()
     {
         Rectangle playerCarRect = playerCar.getBounds();
         Rectangle obstacleRect1 = obstacle1.getBounds();
         Rectangle obstacleRect2 = obstacle2.getBounds();
         
         
         if ( playerCarRect.intersects(obstacleRect1) || playerCar.getCarXpos() == -20 || playerCar.getCarXpos() == 385 ||
              playerCarRect.intersects(obstacleRect2))   
         {
             lost = true;
            // JOptionPane.showMessageDialog(f, "YOU LOST!!!!\n\n  \n");   
            //System.exit(0);
         }
         
         
     }
     
     public void score()
     {
         if(obstacle1.getObstacleYpos()==660) 
             score++;
         if(obstacle2.getObstacleYpos()==660) 
             score++;
     }
     


    public void paint (Graphics g)
    {
        
        super.paint(g);
        g.drawImage(Road.getImage(), 0, Road.getRoadYpos(), null); //first road image
        g.drawImage(Road.getImage(), 0, Road.getRoadY2pos(), null); //second road image
        g.drawImage(playerCar.getCarImage(), playerCar.getCarXpos(), playerCar.getCarYpos(), null);//car image
  
       
           g.drawImage(obstacle1.getObstacleImg(), obstacle1.obstacleXpos, obstacle1.obstacleYpos, null);
                // to see the rectangles that bound car and obstacle
                // g.drawRect(playerCar.carXpos+20,playerCar.carYpos+20, playerCar.CAR_WIDTH-20, playerCar.CAR_LENGTH-20);
                // g.drawRect(obstacle1.obstacleXpos+20,obstacle1.obstacleYpos+20, obstacle1.OBSTACLE_WIDTH-20, obstacle1.OBSTACLE_LENGTH-20);           
         if (obstacle2.obstacleXpos >= obstacle1.obstacleXpos && obstacle2.obstacleXpos- obstacle1.obstacleXpos <= 60)  //stopping ob2 to crash ob1 on right side
                {
                     obstacle2.setObstacleXpos();
                }
         else if (obstacle2.obstacleXpos <= obstacle1.obstacleXpos && obstacle1.obstacleXpos- obstacle2.obstacleXpos <= 60)  //stopping ob2 to crash ob1 on left side
                {
                     obstacle2.setObstacleXpos();
                }
            g.drawImage(obstacle2.getObstacleImg(), obstacle2.obstacleXpos, obstacle2.obstacleYpos, null);
        
        

        //for Score
        g.setColor(Color.green);    
        g.drawString("SCORE : " +score, 50, 50);
        
    }

     
    //connecting ActionListener to the car object to make it move
     private class ActionListener extends KeyAdapter
    {

        public void keyReleased(KeyEvent e) {
            playerCar.keyReleased(e);
        }

        public void keyPressed(KeyEvent e) {
            playerCar.keyPressed(e);
        }
    
    }
    
}
