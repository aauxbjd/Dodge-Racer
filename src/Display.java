import java.awt.*;
import java.awt.event.*;
import javax.swing.*;



public class Display extends JPanel
{
    DodgeRacer_Road Road = new DodgeRacer_Road();
    
    
    public Display()
    {

        

    }
    

    @Override
    public void paint (Graphics g)
    {
        
        super.paint(g);
        g.drawImage(Road.getImage(), 0, Road.getRoadYpos(), null);
        
    }

    
   
}


//import javax.swing.*;
//import java.awt.*;
//
//public class Display extends Window {
//
//    public static void main(String[] args) {
//      // new Menu();
//      JFrame frame = new JFrame("Game");
//        frame.add(new Window());
//        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        frame.setSize(465, 700);
//        frame.setVisible(true);
//    }
//
//    public Display() {
//       
//    }
//
//}
