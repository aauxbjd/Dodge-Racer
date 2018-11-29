import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Window extends JFrame
{
    LoadScore lScore = new LoadScore();
    public static void main (String[] args)
    {
        Window game = new Window();
        
    }
            
    
    public Window()
    {
        Display DisplayBg = new Display();
        
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
        
        JMenu men1 = new JMenu("Menu1");
        menu.add(men1);
        JMenuItem item1 = new JMenuItem("HighScore");
        men1.add(item1);
        item1.addActionListener (new ActionListener()
        {
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
        
        JMenu men2 = new JMenu("Menu2");
        menu.add(men2);
        JMenuItem item2 = new JMenuItem("item2");
        men2.add(item2);
    }
}
