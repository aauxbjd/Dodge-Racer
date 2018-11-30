import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Window extends JFrame
{ 
    Display DisplayBg = new Display();
    LoadScore lScore = new LoadScore();
    
    public static void main (String[] args)
    {
        Window game = new Window();
        
    }
            
    
    public Window()
    {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(466, 725);
        this.add(DisplayBg);
        initMenu();
        this.setVisible(true);
    }
    
    public void initMenu()
    {
        JMenuBar menu = new JMenuBar();
        this.setJMenuBar(menu);
        
        JMenu men1 = new JMenu("Menu");
        menu.add(men1);
        JMenuItem item1 = new JMenuItem("Scores     ");
        men1.add(item1);
        item1.addActionListener (new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent ac)
            {
                try {
                    lScore.loadFile();
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Scores file not found!! ");
                }
                //JOptionPane.showMessageDialog(null,"These are all the High Scores\n" + lScore.Lscore);
            }

        });
        
        JMenu men2 = new JMenu("Instructions     ");
        menu.add(men2);
        //JMenuItem item2 = new JMenuItem("");
        //men2.add(item2);
    }
}
