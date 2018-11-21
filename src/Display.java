import java.awt.*;
import java.awt.event.*;
import javax.swing.*;



public class Display extends JPanel implements ActionListener
{
    DodgeRacer_Road Road = new DodgeRacer_Road();
    //DodgeRacer_Road Road1 = new DodgeRacer_Road();
    Timer time;
    
    public Display()
    {
        // setFocusable(true);
        time = new Timer(5,this); // this calls actionPerformed every 5 miliseconds
        time.start();

    }
   
     public void actionPerformed(ActionEvent e)
    {
         repaint();   
         Road.scroll();  //updates road's xPos by adding 5
    }

    public void paint (Graphics g)
    {
        
        super.paint(g);
        g.drawImage(Road.getImage(), 0, Road.getRoadYpos(), null);
        g.drawImage(Road.getImage(), 0, Road.getRoadY2pos(), null);
        System.err.println(Road.RoadY2pos);
        
        if(Road.getRoadYpos()>=661)
            Road.setRoadYpos();
        if (Road.getRoadY2pos()>=661)
             Road.setRoadY2pos();
            
        
        
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
