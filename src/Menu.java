
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Menu {
    String Images[] = {"menuName.png","menuNewGame.png","menuLead.png","menuLoad.png","menuQuit.png"};
   
    
    public void drawMenu(Graphics g)
    {
         
        for(int i = 0; i < Images.length ; i++)
            {
                ImageIcon menuNames = new ImageIcon(Images[i]);
                Image menus = menuNames.getImage();
                
                g.drawImage(menus, 0, 0,null);
                System.err.println(Images.length);
             }
    }
    

}
