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
import java.net.URL;
import javax.sound.sampled.*;
import javax.swing.*;

public class Sound {

    public void play(String sName) throws UnsupportedAudioFileException, LineUnavailableException, IOException {
        File soundFile = new File(sName);
        AudioInputStream audioIn = AudioSystem.getAudioInputStream(soundFile);
        Clip clip = AudioSystem.getClip();

        clip.open(audioIn);
        clip.start();
    }

    public void stop(String sName) throws UnsupportedAudioFileException, LineUnavailableException, IOException {
        File soundFile = new File(sName);
        AudioInputStream audioIn = AudioSystem.getAudioInputStream(soundFile);
        Clip clip = AudioSystem.getClip();
        clip.stop();
    }

}
