
import java.io.*;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

public class Save {

    // life, score, collide, Road.RoadYpos , Road.RoadY2pos, playerCar.carXpos,obstacle1.obstacleXpos,obstacle1.obstacleYpos,obstacle2.obstacleXpos,obstacle2.obstacleYpos
    String fileName;

    public void saveScore(String player,int lif, int scor, boolean collide, int rY, int rY2, int cX, int o1X, int o1Y, int o2X, int o2Y) throws Exception {
        // Create some data to write.
        if (Display.state == Display.STATE.GAME) {
            Display.state = Display.state.PAUSE;
        }
        String playerN = player;
        int LIFE = lif, SCORE = scor, RY = rY, RY2 = rY2, CX = cX, O1X = o1X, O1Y = o1Y, O2X = o2X, O2Y = o2Y;
        boolean hyperactive = collide;

        JFileChooser chooser = new JFileChooser();
        int returnVal = chooser.showSaveDialog(null);

        if (returnVal == JFileChooser.APPROVE_OPTION) {

            fileName = chooser.getSelectedFile().getName();

            // Set up the FileWriter with our file name.
            FileWriter saveFile = new FileWriter(chooser.getCurrentDirectory() + "\\" + fileName);

            // Write the data to the file.
            saveFile.write("\n");
            saveFile.write(playerN+ "\n");
            saveFile.write(LIFE + "\n");
            saveFile.write(SCORE + "\n");
            saveFile.write(RY + "\n");
            saveFile.write(RY2 + "\n");
            saveFile.write(CX + "\n");
            saveFile.write(O1X + "\n");
            saveFile.write(O1Y + "\n");
            saveFile.write(O2X + "\n");
            saveFile.write(O2Y + "\n");
            saveFile.write(Boolean.toString(hyperactive) + "\n");
            saveFile.write("\n");

            saveFile.close();

        } else if (returnVal == JFileChooser.CANCEL_OPTION) {

        }

    }
}
