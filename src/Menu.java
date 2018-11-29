
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;

public class Menu implements MouseListener{
    String Images[] = {"menuName.png","menuNewGame.png","menuLead.png","menuLoad.png","menuQuit.png"};
    int mouseX;
        int mouseY;
        public static String playerName;
        LoadScore lScore = new LoadScore();
        Load loadGame = new Load();
    
    public void drawMenu(Graphics g)
    {
        g.setColor(Color.red);
        g.fillRect(100, 230, 250, 50);
        g.fillRect(55, 303, 340, 50);
        g.fillRect(100, 373, 250, 50);
        g.fillRect(170, 615, 115, 45);
         
        for(int i = 0; i < Images.length ; i++)
            {
                ImageIcon menuNames = new ImageIcon(Images[i]);
                Image menus = menuNames.getImage();
                
                g.drawImage(menus, 0, 0,null);
             }
        
     
        
        
    }
    

    @Override
    public void mouseClicked(MouseEvent e) {
       
        mouseX = e.getX();
        mouseY = e.getY();
        System.out.println("X: " + mouseX);
        System.out.println("y: " + mouseY);
        if ( mouseX >= 100 && mouseX <= 100 + 250)                    //100, 230, 250, 50
         {
            if ( mouseY >= 230 && mouseY <= 230 + 50)
            {
                //System.err.println("newGame");
                playerName = JOptionPane.showInputDialog(null,"Please enter your name:");
                Display.state = Display.STATE.GAME;
            }
          }
        
        if (  mouseX >= 170 && mouseX <= 170 + 115 )                       //(55, 303, 340, 50);         
        {
            if ( mouseY >= 615 && mouseY <= 615 + 50)
            {
                System.err.println("quit");
                System.exit(0);
             //   Display.state = Display.STATE.GAME;
            }
            
        }
        
        if (  mouseX >= 55 && mouseX <= 55 + 340)                                  //(55, 303, 340, 50);
        {
            if ( mouseY >= 303 && mouseY <= 303 + 50)
            {
                try {
                    lScore.loadFile();
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Scores file not found!! ");
                }
            }
            
        }
        
        //100, 373, 250, 50);
        if (  mouseX >= 100 && mouseX <= 100 + 250)                                
        {
            if ( mouseY >= 373 && mouseY <= 373 + 50)
            {      
                try {
                    loadGame.loadFile();
                } catch (Exception ex) {
                    Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);
                }
                  Display.life = loadGame.LIFE;
                  Display.score = loadGame.SCORE;
                  Display.collide = loadGame.hyperactive;
                  DodgeRacer_Road.RoadYpos = loadGame.RY;
                  DodgeRacer_Road.RoadY2pos = loadGame.RY2;
                  Car.carXpos = loadGame.CX;
                  Obstacle.obstacleXpos = loadGame.O1X;
                 // Obstacle.obstacle2Xpos = loadGame.O2X;
                  Obstacle.obstacleYpos = loadGame.O1Y;
                 // Obstacle.obstacleYpos = 
                  
                  Display.state = Display.STATE.GAME;
                  
                   // JOptionPane.showMessageDialog(null, "load ");
                
            }
            
        }
        
        
      
    }

    @Override
    public void mousePressed(MouseEvent e) {
       
    }

    @Override
    public void mouseReleased(MouseEvent e) {
      
    }

    @Override
    public void mouseEntered(MouseEvent e) {
       mouseX = e.getX();
        mouseY = e.getY();
        if ( mouseX >= 100 && mouseX <= 100 + 250)
         {
            if ( mouseY >= 230 && mouseY <= 230 + 50)
            {
                System.out.println("hit121212");
                Display.state = Display.STATE.GAME;
               
            }
          }
       
    }

    @Override
    public void mouseExited(MouseEvent e) {

    }


    
    

}
