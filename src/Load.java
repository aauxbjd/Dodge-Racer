/*

Authors : Ayush Banjade, safin Bjagai, Sagar Pandeya
Date :    11/30/2018

This is a car racing game based on java

Functions:
1. Save game (can use 'S' shortcut key to save)
2. Load game (can use 'A' shortcut key to load previously saved game)
3. Pause game ( use 'P' to pause and resume back)
4. Saves your score in a file which you can view in a Jwindow

*/

import java.io.*;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

public class Load {

    int LIFE, SCORE, RY, RY2, CX, O1X, O1Y, O2X, O2Y;
    boolean hyperactive;
    String fileName;
    String PlayerNam;

    public void loadFile() throws Exception {


        JFileChooser chooser = new JFileChooser();
        int returnVal = chooser.showOpenDialog(null);

        if (returnVal == JFileChooser.APPROVE_OPTION) {
           
            fileName = chooser.getSelectedFile().getName();

            BufferedReader saveFile = new BufferedReader(new FileReader(chooser.getCurrentDirectory() + "\\" + fileName));

            // Throw away the blank line at the top.
            saveFile.readLine();
            // Get the integer value from the String.
            PlayerNam = saveFile.readLine();
            LIFE = Integer.parseInt(saveFile.readLine());
            SCORE = Integer.parseInt(saveFile.readLine());
            RY = Integer.parseInt(saveFile.readLine());
            RY2 = Integer.parseInt(saveFile.readLine());
            CX = Integer.parseInt(saveFile.readLine());
            O1X = Integer.parseInt(saveFile.readLine());
            O1Y = Integer.parseInt(saveFile.readLine());
            O2X = Integer.parseInt(saveFile.readLine());
            O2Y = Integer.parseInt(saveFile.readLine());
            hyperactive = Boolean.parseBoolean(saveFile.readLine());

            // Not needed, but read blank line at the bottom.
            saveFile.readLine();
                        

            saveFile.close();

            System.err.println(LIFE +"\n" +SCORE+"\n" +RY+"\n" +RY2+"\n" +CX+"\n" +O1X+"\n" +
                    O1Y+"\n" +O2X+"\n" +O2Y+"\n" +hyperactive);
          //  Display.state = Display.STATE.GAME;
          if(Display.state == Display.STATE.MENU )
                        {
                            Display.state = Display.STATE.PAUSE;
                        }
        
        
        } if (returnVal == JFileChooser.CANCEL_OPTION) {
            JOptionPane.showMessageDialog(null, "No File Selected ");
                    if(Display.state == Display.STATE.MENU )
                        {
                            Display.state = Display.STATE.MENU;
                        }
        }

    }
} 
