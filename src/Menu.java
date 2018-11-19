
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Menu extends JFrame {
    String name;

    public Menu() {

        JButton button1 = new JButton("Start Game");
        button1.setAlignmentX(Component.CENTER_ALIGNMENT);
        button1.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent ac) {
                JFrame userName = new JFrame("User Name");
                name = JOptionPane.showInputDialog(userName, "Enter Player's Name?");
                JOptionPane.showMessageDialog(userName,"Welcome "+name+"!!\n Click OK to Race");
                new Display();
                dispose();
            }
        });

        JButton button2 = new JButton("Quit");
        button2.setAlignmentX(Component.BOTTOM_ALIGNMENT);

        button2.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent ac) {
                dispose();
            }
        });

        this.add(button2);
        this.add(button1);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new FlowLayout());
        this.setSize(465, 700);
        this.setVisible(true);
    }
    
    public  String getName()
    {
        return name;
    }

}
