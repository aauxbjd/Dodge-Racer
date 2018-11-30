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

public class SaveScore {

    int fScore;

    public void saveScore(int Score) throws Exception {
        fScore = Score;
        try (
                FileWriter saveFile = new FileWriter("Scores.txt", true)) {
            saveFile.append("\n" + Menu.playerName + "    " + fScore + "\n");
        }

    }
}
