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

import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.*;

public class Display extends JPanel implements ActionListener {

    DodgeRacer_Road Road = new DodgeRacer_Road();
    Sound sounds = new Sound();
    Car playerCar = new Car();
    Obstacle obstacle1 = new Obstacle("ob1.png");
    Obstacle obstacle2 = new Obstacle("ob2.png");
    Image lifeImage;
    Menu mainMenu = new Menu();
    Save saveFile = new Save();
    Load loadGame = new Load();
    SaveScore sScore = new SaveScore();
    LoadScore lScore = new LoadScore();
    Timer time;
    String Player = " ";

    public static int life = 3;
    public static int score;
    public static boolean collide = false;

    boolean pause;

    static int x, y;

    int obx = obstacle1.obstacleXpos;
    int oby = obstacle1.obstacleYpos;

    public static enum STATE {
        MENU,
        GAME,
        PAUSE
    };
    public static STATE state = STATE.MENU;

    public Display() {
        ImageIcon carLifeImgFile = new ImageIcon("carLife.png");
        lifeImage = carLifeImgFile.getImage();

        setFocusable(true);                      //setting focus to the screen
        addKeyListener(new ActionListener());    //adding keylistener on the screen
        time = new Timer(2, this);                // this calls actionPerformed every 5 miliseconds
        time.start();

        addMouseListener(mainMenu);
    }

    public void actionPerformed(ActionEvent e) {

        if (state == STATE.GAME) {

            Player = Menu.playerName;

            repaint();

            Road.scroll();                         //updates road's xPos by adding 5
            playerCar.move();

            obstacle1.obstacleNumber = 1;
            obstacle1.move();

            checkCollision();
            score();
            boolean lost = false;
            if (life <= 0) {
                lost = true;
                try {
                    sScore.saveScore(score);
                } catch (Exception ex) {
                    Logger.getLogger(Display.class.getName()).log(Level.SEVERE, null, ex);
                }

                JOptionPane.showMessageDialog(null, "YOU LOST!! \n\n your score: " + score);
                System.exit(0);
            }
            if (lost == false) {
                try {
                    sounds.play("carsound.wav");
                } catch (UnsupportedAudioFileException ex) {
                    Logger.getLogger(Display.class.getName()).log(Level.SEVERE, null, ex);
                } catch (LineUnavailableException ex) {
                    Logger.getLogger(Display.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IOException ex) {
                    Logger.getLogger(Display.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (lost == true) {
                try {
                    lost = true;
                    sounds.stop("carsound.wav");
                } catch (UnsupportedAudioFileException ex) {
                    Logger.getLogger(Display.class.getName()).log(Level.SEVERE, null, ex);
                } catch (LineUnavailableException ex) {
                    Logger.getLogger(Display.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IOException ex) {
                    Logger.getLogger(Display.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

        }

    }

    public void checkCollision() {

        Rectangle playerCarRect = playerCar.getBounds();
        Rectangle obstacleRect1 = obstacle1.getBounds();
        Rectangle obstacleRect2 = obstacle2.getBounds();

        if (playerCarRect.intersects(obstacleRect1)) {
            collide = true;
            try {
                sounds.play("crash.wav");
            } catch (UnsupportedAudioFileException ex) {
                Logger.getLogger(Display.class.getName()).log(Level.SEVERE, null, ex);
            } catch (LineUnavailableException ex) {
                Logger.getLogger(Display.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(Display.class.getName()).log(Level.SEVERE, null, ex);
            }
            obstacle1.setObstacleYpos();
        } else if (playerCarRect.intersects(obstacleRect2)) {
            collide = true;
            try {
                sounds.play("crash.wav");
            } catch (UnsupportedAudioFileException ex) {
                Logger.getLogger(Display.class.getName()).log(Level.SEVERE, null, ex);
            } catch (LineUnavailableException ex) {
                Logger.getLogger(Display.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(Display.class.getName()).log(Level.SEVERE, null, ex);
            }
            obstacle2.setObstacleYpos();
        } else if (playerCar.getCarXpos() == -20 || playerCar.getCarXpos() == 385) {
            try {
                sounds.play("crash.wav");
            } catch (UnsupportedAudioFileException ex) {
                Logger.getLogger(Display.class.getName()).log(Level.SEVERE, null, ex);
            } catch (LineUnavailableException ex) {
                Logger.getLogger(Display.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(Display.class.getName()).log(Level.SEVERE, null, ex);
            }
            collide = true;
            playerCar.setCarXpos();
        }

        //avoiding obstacle 1 colliding with obstacle 2
        if (obstacleRect2.intersects(obstacleRect1)) {
            if (obstacle2.obstacleXpos - 175 >= 0) {
                obstacle2.obstacleXpos -= 100;
            } else if (obstacle2.obstacleXpos - 175 < 0) {
                obstacle2.obstacleXpos += 100;
            }
        }
    }

    public void score() {
        if (obstacle1.getObstacleYpos() == 660) {
            score++;
        }
        if (obstacle2.getObstacleYpos() == 660) {
            score++;
        }

        if (collide == true) {
            life += -1;
            obstacle2.setObstacleYpos();
            collide = false;
        }

        // making obstacle 2 visible after score is reached to 2. 
        if (score >= 2) {
            obstacle2.obstacleNumber = 2;
            obstacle2.move();
        }
    }

    public void paint(Graphics g) {

        super.paint(g);

        int j = 0;
        g.drawImage(Road.getImage(), 0, Road.getRoadYpos(), null); //first road image
        g.drawImage(Road.getImage(), 0, Road.getRoadY2pos(), null); //second road image
        g.drawImage(playerCar.getCarImage(), playerCar.getCarXpos(), playerCar.getCarYpos(), null);//car image

        //obstacles
        g.drawImage(obstacle1.getObstacleImg(), obstacle1.obstacleXpos, obstacle1.obstacleYpos, null);
        g.drawImage(obstacle2.getObstacleImg(), obstacle2.obstacleXpos, obstacle2.obstacleYpos, null);

        //System.err.println("obx: "+obx+ "\n OBX: " + obstacle1.obstacleXpos);
        g.setColor(Color.yellow);
        g.drawString(Player, 20, 20);

        g.setColor(Color.blue);
        g.drawString("LIVES : ", 20, 60);

        for (int i = 1; i <= life; i++) {
            g.drawImage(lifeImage, 60 + j, 45, null);
            j += 25;
        }
        //  to see the rectangles that bound car and obstacle
        //g.setColor(Color.blue);
        //  g.drawRect(playerCar.carXpos+20,playerCar.carYpos+20, playerCar.CAR_WIDTH-20, playerCar.CAR_LENGTH-20);
        // g.drawRect(obstacle1.obstacleXpos + 20, obstacle1.obstacleYpos + 20, obstacle1.OBSTACLE_WIDTH - 20, obstacle1.OBSTACLE_LENGTH - 20);
        //  g.drawRect(obstacle2.obstacleXpos+20,obstacle2.obstacleYpos+20, obstacle2.OBSTACLE_WIDTH-20, obstacle2.OBSTACLE_LENGTH-20);  
        //printing Score on screen
        g.setColor(Color.green);
        g.drawString("SCORE : " + score, 20, 40);

        if (state == STATE.MENU) {
            mainMenu.drawMenu(g);
        }

    }

    //connecting ActionListener to the car object to make it move
    private class ActionListener extends KeyAdapter {

        public void keyReleased(KeyEvent e) {  //sent to car
            playerCar.keyReleased(e);
        }

        public void keyPressed(KeyEvent e) {
            playerCar.keyPressed(e);

            int axx = e.getKeyCode();
            if (axx == KeyEvent.VK_S) {

                if (state == STATE.GAME) {
                    state = STATE.PAUSE;

                    saveGame();
                    JOptionPane.showMessageDialog(null, "GAME PAUSED\n PRESS 'p' TO RESUME ");
                }
            }

            if (axx == KeyEvent.VK_A) {

                if (state == STATE.GAME) {
                    state = STATE.PAUSE;
                    loadGame();
                    JOptionPane.showMessageDialog(null, "GAME PAUSED\n PRESS 'p' TO RESUME ");
                }

                if (state == STATE.MENU) {

                    loadGame();

                    state = STATE.PAUSE;
                    JOptionPane.showMessageDialog(null, "GAME PAUSED\n PRESS 'p' TO RESUME ");

                }

            }

            if (axx == KeyEvent.VK_P) {

                if (state == STATE.GAME) {
                    state = STATE.PAUSE;
                    JOptionPane.showMessageDialog(null, "GAME PAUSED\n PRESS 'p' TO RESUME ");

                } else if (state == STATE.PAUSE) {

                    state = STATE.GAME;
                }

                if (state == STATE.MENU) {
                    state = STATE.MENU;
                }

            }

        }

    }

    public void saveGame() {
        try {
            saveFile.saveScore(Menu.playerName, life, score, collide, Road.RoadYpos, Road.RoadY2pos, playerCar.carXpos, obstacle1.obstacleXpos, obstacle1.obstacleYpos, obstacle2.obstacleXpos, obstacle2.obstacleYpos);
        } catch (Exception ex) {
            Logger.getLogger(Display.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void loadGame() {

        try {
            loadGame.loadFile();

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "wronggg ");
        }

        Menu.playerName = loadGame.PlayerNam;
        life = loadGame.LIFE;
        score = loadGame.SCORE;
        collide = loadGame.hyperactive;
        Road.RoadYpos = loadGame.RY;
        Road.RoadY2pos = loadGame.RY2;
        Car.carXpos = loadGame.CX;
        obstacle1.obstacleXpos = loadGame.O1X;
        obstacle1.obstacleYpos = loadGame.O1Y;
        obstacle2.obstacleXpos = loadGame.O2X;
        obstacle2.obstacleYpos = loadGame.O2Y;

    }

}
