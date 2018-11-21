import java.awt.*;
import java.awt.event.*;
import javax.swing.*;



public class Display extends JPanel implements ActionListener
{
    DodgeRacer_Road Road = new DodgeRacer_Road();
    Car playerCar = new Car();
    Timer time;
    
    public Display()
    { 
        setFocusable(true);  //setting focus to the screen
        addKeyListener(new ActionListener());  //adding keylistener on the screen
        time = new Timer(5,this); // this calls actionPerformed every 5 miliseconds
        time.start();

    }
   
     public void actionPerformed(ActionEvent e)
    {
         repaint();   
         Road.scroll();  //updates road's xPos by adding 5
         playerCar.move();
    }

    public void paint (Graphics g)
    {
        
        super.paint(g);
        g.drawImage(Road.getImage(), 0, Road.getRoadYpos(), null); //first road image
        g.drawImage(Road.getImage(), 0, Road.getRoadY2pos(), null); //second road image
        //System.err.println(Road.RoadY2pos); 
        g.drawImage(playerCar.getCarImage(), playerCar.getCarXpos(), playerCar.getCarYpos(), null);//car image
        
        if(Road.getRoadYpos()>=661) // puts the first road image to top after it ends
            Road.setRoadYpos();
        if (Road.getRoadY2pos()>=661) // puts the second road image to top after it ends
            Road.setRoadY2pos();
            
        
        
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
