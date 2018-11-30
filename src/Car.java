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

import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.*;
import javax.swing.ImageIcon;

public class Car {

    final int CAR_WIDTH = 60;
    final int CAR_LENGTH = 100;

    Image carImage;
    public static int carXpos, carYpos, carDx;

    public Car() {
        ImageIcon imageFile = new ImageIcon("car.png");
        carImage = imageFile.getImage();
        carXpos = 180;
        carYpos = 450;

    }

    public Rectangle getBounds() {
        return new Rectangle(carXpos + 20, carYpos + 20, CAR_WIDTH - 20, CAR_LENGTH - 20);
    }

    public void move() {
        carXpos += carDx;
    }

    public int getCarXpos() {
        return carXpos;
    }

    public int getCarYpos() {
        return carYpos;
    }

    public Image getCarImage() {
        return carImage;
    }

    public void setCarXpos() {
        carXpos = 180;
    }

    //making car move with the arrow keys
    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();

        if (key == KeyEvent.VK_LEFT) {
            carDx = -5;
        }

        if (key == KeyEvent.VK_RIGHT) {
            carDx = 5;
        }
    }

    public void keyReleased(KeyEvent e) {
        int key = e.getKeyCode();

        if (key == KeyEvent.VK_LEFT) {
            carDx = 0;
        }

        if (key == KeyEvent.VK_RIGHT) {
            carDx = 0;
        }
    }

}
