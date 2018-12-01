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

import java.io.*;
import javax.swing.JOptionPane;

public class LoadScore {

    String line;
    StringBuilder builder = new StringBuilder();

    public void loadFile() throws Exception {

        BufferedReader loadFile = new BufferedReader(new FileReader("Scores.txt"));

        while ((line = loadFile.readLine()) != null) {

            line = loadFile.readLine();
            builder.append(line);
            builder.append("\n");
        }
        System.err.println("score: " + builder);
        JOptionPane.showMessageDialog(null, "SCORES" + "\n" + builder);
    }
}
