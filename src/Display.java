import java.awt.*;
import java.awt.event.*;
import javax.swing.*;



public class Display extends JPanel implements ActionListener
{
    DodgeRacer_Road Road = new DodgeRacer_Road();
    Car playerCar = new Car();
    Obstacle obstacle1 = new Obstacle();
    Timer time;
    int score;
    boolean lost = false;
    
    public Display()
    { 
        setFocusable(true);  //setting focus to the screen
        addKeyListener(new ActionListener());  //adding keylistener on the screen
        time = new Timer(5,this); // this calls actionPerformed every 5 miliseconds
        time.start();

    }
   
     public void actionPerformed(ActionEvent e)
    {
         checkCollision();
         repaint();   
         Road.scroll();  //updates road's xPos by adding 5
         playerCar.move();
         obstacle1.move();
         score();
         if(lost == true)
         {
             score=0;
             lost = false;
         }
         
    }
     
     public void checkCollision()
     {
         Rectangle playerCarRect = playerCar.getBounds();
         Rectangle obstacleRect1 = obstacle1.getBounds();
         if ( playerCarRect.intersects(obstacleRect1) || playerCar.getCarXpos() == -20 || playerCar.getCarXpos() == 385  )   
         {
             lost = true;
           // JOptionPane.showMessageDialog(f, "YOU LOST!!!!\n\n  \n");   
            //System.exit(0);
         }
         
     }
     
     public void score()
     {
         if(obstacle1.getObstacleYpos()==660 )
             score++;
         //System.out.println(score);
     }
     


    public void paint (Graphics g)
    {
        
        super.paint(g);
        g.drawImage(Road.getImage(), 0, Road.getRoadYpos(), null); //first road image
        g.drawImage(Road.getImage(), 0, Road.getRoadY2pos(), null); //second road image
        g.drawImage(playerCar.getCarImage(), playerCar.getCarXpos(), playerCar.getCarYpos(), null);//car image
        g.drawImage(obstacle1.getObstacleImg(), obstacle1.obstacleXpos, obstacle1.obstacleYpos, null);
        
       
            // g.drawRect(playerCar.carXpos+20,playerCar.carYpos+20, playerCar.CAR_WIDTH-20, playerCar.CAR_LENGTH-20);
            // g.drawRect(obstacle1.obstacleXpos+20,obstacle1.obstacleYpos+20, obstacle1.OBSTACLE_WIDTH-20, obstacle1.OBSTACLE_LENGTH-20);
        
        if (Road.getRoadYpos()>=661)             // puts the first road image to top after it ends
            Road.setRoadYpos();
        if (Road.getRoadY2pos()>=661)           // puts the second road image to top after it ends
            Road.setRoadY2pos();
        
        if (obstacle1.obstacleYpos >= 661)
        {
            obstacle1.setObstacleYpos();
            obstacle1.setObstacleXpos();   
        }
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
