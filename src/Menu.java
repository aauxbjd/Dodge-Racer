
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.*;

public class Menu implements MouseListener{
    String Images[] = {"menuName.png","menuNewGame.png","menuLead.png","menuLoad.png","menuQuit.png"};
    int mouseX;
        int mouseY;
    
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
        if ( mouseX >= 100 && mouseX <= 100 + 250)
         {
            if ( mouseY >= 230 && mouseY <= 230 + 50)
            {
                //System.err.println("newGame");
                Display.state = Display.STATE.GAME;
            }
          }
        
        if (  mouseX >= 170 && mouseX <= 170 + 115 )
        {
            if ( mouseY >= 615 && mouseY <= 615 + 50)
            {
                System.err.println("quit");
                System.exit(0);
             //   Display.state = Display.STATE.GAME;
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
