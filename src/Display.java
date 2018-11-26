import java.awt.*;
import java.awt.event.*;
import javax.swing.*;



public class Display extends JPanel implements ActionListener
{
    DodgeRacer_Road Road = new DodgeRacer_Road();
    Car playerCar = new Car();
    Obstacle obstacle1 = new Obstacle("ob1.png");
    Obstacle obstacle2 = new Obstacle("ob2.png");
    Image lifeImage;
    
    
    Timer time;
    int life = 3;
    int score;
    boolean lost = false;
    
    public Display()
    { 
        ImageIcon carLifeImgFile = new ImageIcon("carLife.png");
        lifeImage = carLifeImgFile.getImage();
        
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
        

       
         
        checkCollision();

        score();
         
        
        
        if ( life <=0)
        {
            JOptionPane.showMessageDialog(null, "YOU LOST!!");
            System.exit(0);
            
        }
         
    }
     
     public void checkCollision()
     {

         Rectangle playerCarRect = playerCar.getBounds();
         Rectangle obstacleRect1 = obstacle1.getBounds();
         Rectangle obstacleRect2 = obstacle2.getBounds();
         
         
         if ( playerCarRect.intersects(obstacleRect1))   
         {
             lost = true;
             obstacle1.setObstacleYpos();
         }
         else if (playerCarRect.intersects(obstacleRect2))
         {
             lost = true;
             obstacle2.setObstacleYpos();
         }
         else if (playerCar.getCarXpos() == -20 || playerCar.getCarXpos() == 385)
         {
              lost = true;
              playerCar.setCarXpos();
         }
         
         
         //avoiding obstacle 1 colliding with obstacle 2
          if ( obstacleRect2.intersects(obstacleRect1))
           {
              if( obstacle2.obstacleXpos - 175 >= 0)
                  obstacle2.obstacleXpos -= 100;
              else if ( obstacle2.obstacleXpos - 175 < 0)
                  obstacle2.obstacleXpos += 100;
            }
          }
          
              
         
         
     
     public void score()
     {
         if(obstacle1.getObstacleYpos()==660) 
             score++;
         if(obstacle2.getObstacleYpos()==660) 
             score++;
         
         if(lost == true)
        {
            if(score-5 >=0)
            {
                score+=-5;
            }
            else if(score-10 >=0)
            {
                score+=-5;
            }
            else
                score = 0;
            
            life+=-1;
            obstacle2.setObstacleYpos();
            lost = false;
        }
         
       // making obstacle 2 visible after score is reached to 2. 
       if(score>=2)
        {
           obstacle2.obstacleNumber=2;
          
           obstacle2.move();
        }
     }
     


    public void paint (Graphics g)
    {
        
        super.paint(g);
        
        
        int j = 0;
        g.drawImage(Road.getImage(), 0, Road.getRoadYpos(), null); //first road image
        g.drawImage(Road.getImage(), 0, Road.getRoadY2pos(), null); //second road image
        g.drawImage(playerCar.getCarImage(), playerCar.getCarXpos(), playerCar.getCarYpos(), null);//car image
        
        //obstacles
        g.drawImage(obstacle1.getObstacleImg(), obstacle1.obstacleXpos, obstacle1.obstacleYpos, null);
        g.drawImage(obstacle2.getObstacleImg(), obstacle2.obstacleXpos, obstacle2.obstacleYpos, null);
        
        g.setColor(Color.blue);
        g.drawString("LIVES : ", 20, 40);
        
        for(int i = 1; i<=life; i++)
        {
            g.drawImage(lifeImage, 60+j, 25, null);
            j+=25;
        }
               //  to see the rectangles that bound car and obstacle
               //  g.setColor(Color.blue);
               //  g.drawRect(playerCar.carXpos+20,playerCar.carYpos+20, playerCar.CAR_WIDTH-20, playerCar.CAR_LENGTH-20);
               //  g.drawRect(obstacle1.obstacleXpos+20,obstacle1.obstacleYpos+20, obstacle1.OBSTACLE_WIDTH-20, obstacle1.OBSTACLE_LENGTH-20);  
               //  g.drawRect(obstacle2.obstacleXpos+20,obstacle2.obstacleYpos+20, obstacle2.OBSTACLE_WIDTH-20, obstacle2.OBSTACLE_LENGTH-20);  
        //printing Score on screen
        g.setColor(Color.green);
        
        g.drawString("SCORE : " +score, 20, 20);
        
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
