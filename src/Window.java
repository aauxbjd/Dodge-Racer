/*

Authors : Ayush Banjade.
Date :    11/30/2018

This is a car racing game based on java

Functions:
1. Save game (can use 'S' shortcut key to save)
2. Load game (can use 'A' shortcut key to load previously saved game)
3. Pause game ( use 'P' to pause and resume back)
4. Saves your score in a file which you can view in a Jwindow

*/

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Window extends JFrame {

    Display DisplayBg = new Display();
    LoadScore lScore = new LoadScore();

    public static void main(String[] args) {
        Window game = new Window();

    }

    public Window() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(466, 725);
        this.add(DisplayBg);
        initMenu();
        this.setVisible(true);
    }

    public void initMenu() {
        JMenuBar menu = new JMenuBar();
        this.setJMenuBar(menu);

        JMenu men1 = new JMenu("Menu");
        menu.add(men1);
        JMenuItem item1 = new JMenuItem("Scores     ");
        men1.add(item1);
        item1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ac) {
                try {
                    lScore.loadFile();
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Scores file not found!! ");
                }
            }

        });

        JMenu men2 = new JMenu("Options     ");
        menu.add(men2);
        JMenuItem item2 = new JMenuItem("Save Game");
        men2.add(item2);
        item2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ac) {
                DisplayBg.saveGame();
            }

        });

        JMenuItem item3 = new JMenuItem("Load Game");
        men2.add(item3);
        item3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ac) {
                DisplayBg.loadGame();
                JOptionPane.showMessageDialog(null, "GAME PAUSED\n PRESS 'p' TO RESUME ");
            }

        });
    }
}
