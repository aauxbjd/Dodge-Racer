import javax.swing.*;
import java.awt.*;

public class Window extends Display
{
    public static void main (String[] args)
    {
        Menu mainMenu = new Menu();
        Display DisplayBg = new Display();
        JFrame frame = new JFrame("Dodge Racer");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(466, 700);
        frame.add(mainMenu);
        if(mainMenu.startGame == true)
        {
        frame.remove(mainMenu);
        frame.add(DisplayBg);
        frame.setVisible(true);
        }
        
       // System.err.println(frame.getContentPane().getSize().width); // w = 434-450 = 16 / H = 661 - 700 = 39
    }
    
    public Window()
    {
        
    }
}

















//import java.awt.*;
//import java.awt.event.*;
//import javax.swing.*;
//
//public class Window extends JPanel implements ActionListener {
//
//    Car c;
//    Image img;
//    Timer time;
//
//    Obstacle ob1;
//    Obstacle ob2;
//    Obstacle ob3;
//     //Menu m1 = new Menu();
//    Boolean lost = false;
//    JFrame f;
//    static Font font = new Font("SanSerif", Font.BOLD, 24);
//    int score;
//
//    public Window() {
//
//        c = new Car();
//        addKeyListener(new ActionListener());
//        setFocusable(true); // allows to move left/right when key pressed
//        ImageIcon i = new ImageIcon("E://road1.png");
//        img = i.getImage(); //stores bg image
//        time = new Timer(5, this); // refresh every 5 miliseconds
//        time.start(); //runs method for action performed
//        ob1 = new Obstacle("E://ob1.png");
//        ob2 = new Obstacle("E://ob2.png");
//        ob3 = new Obstacle("E://ob3.png");
//        //ob3 = new Obstacle(200,000,"E://ob2.png");
//
//    }
//
//    public void actionPerformed(ActionEvent e) {
//        checkColisions();
//        ob1.move();
//        c.move();
//        repaint(); //draw image over again
//    }
//
//    public void checkColisions() {
//       
//        Rectangle r1 = ob1.getBounds();
//        Rectangle r2 = ob2.getBounds();
//        Rectangle rCar = c.getBounds();
//        if (r1.intersects(rCar) || r2.intersects(rCar) || c.x == -15 || c.x == 375) {
//            //lost = true;
//            f = new JFrame();
//            
//            JOptionPane.showMessageDialog(f, "YOU LOST!!!!\n\n Your Score: "+ score+"\n");
//            System.exit(0);
//            dispose();
//
//        }
//
//    }
//
//    public void paint(Graphics g) {
//        if (lost) {
//            System.exit(0);
//        }
//        
//
//
////        if (c.getNy() >= 1500 && c.getNy2() >= 1300) {
////            c.ny = 660;
////            c.ny2 = 0;
////        }
//
//        super.paint(g);
//        Graphics2D g2d = (Graphics2D) g; // casts graphics2d onto our graphics
//
//        g2d.drawImage(img, 0, c.getNy() - 1000, null);  //the first image 
//        System.err.println("Ny= "+c.ny);
//        c.ny += 5;
//        System.err.println("Ny2= "+c.ny2);
//        g2d.drawImage(img, 0, c.getNy2() - 1340, null);  // combining first image after it is completely scrolled
//        c.ny2 += 5;
//
//        g2d.drawImage(c.getImage(), c.getX(), c.getY(), null); //adds car
//
//        // System.err.println("x = "+Ob.x); 
//        
//      
//                
//        g2d.drawImage(ob1.getImage(), ob1.getX(), ob1.getY(), null);  //ob1stacle 1 -- x=360(frame length - carlength)
//        //System.err.println("x2 = "+Ob.x);  
//        g2d.drawImage(ob2.getImage(), ob2.getX(), ob2.getY(), null);
//        //g2d.drawImage(ob3.getImage(),ob3.getX(),Ob.getY()-500,null);
//        ob1.y += 3;
//        ob2.y += 6;
//        if (ob1.y > 650) {
//            ob1.y = -500;
//            ob1.setX();
//            ob2.setX();
//            score++;
//
//        }
//
//        if (ob2.y > 650) {
//            ob2.y = -500;
//            ob2.setX();
//            ob2.setX();
//            score++;
//        }
//        g2d.setFont(font);
//        g2d.setColor(Color.green);
//        g2d.drawString("Score \n "+score, 50, 50);
//
//        //System.err.println("y = " + ob1.y);
//        //System.err.println(score);
//    }
//
//    public int getScore() {
//        // String str1 = Integer.toString(score);
//        return score;
//    }
//
//    public String toString() {
//        return "" + getScore();
//    }
//
//    private void dispose() {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }
//
//    private class ActionListener extends KeyAdapter {
//
//        public void keyReleased(KeyEvent e) {
//            c.keyReleased(e);
//            // ob1.keyReleased(e);
//        }
//
//        public void keyPressed(KeyEvent e) {
//            c.keyPressed(e);
//            // ob1.keyPressed(e);
//        }
//    }
//
//}
