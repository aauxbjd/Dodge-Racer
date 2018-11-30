
import java.io.*;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

public class Load {

    int LIFE, SCORE, RY, RY2, CX, O1X, O1Y, O2X, O2Y;
    boolean hyperactive;
    String fileName;

    public void loadFile() throws Exception {
//        if (Display.state == Display.STATE.GAME) {
//            Display.state = Display.state.PAUSE;
  //      }

        JFileChooser chooser = new JFileChooser();
        int returnVal = chooser.showOpenDialog(null);

        if (returnVal == JFileChooser.APPROVE_OPTION) {
            System.out.println("You chose to open this file: "
                    + chooser.getSelectedFile().getName());
            fileName = chooser.getSelectedFile().getName();

            BufferedReader saveFile = new BufferedReader(new FileReader(fileName));

            // Throw away the blank line at the top.
            saveFile.readLine();
            // Get the integer value from the String.
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

            // Print out the values.
            Display.state = Display.STATE.GAME;
            System.out.println("x=" + LIFE + " y=" + SCORE + " z=" + RY + "\n");
            System.out.println("name: " + RY2 + " race: " + CX + "\n");
            System.out.println();
        } else if (returnVal == JFileChooser.CANCEL_OPTION) {
            JOptionPane.showMessageDialog(null, "No File Selected ");
//                    if(Display.state == Display.STATE.MENU )
//                        {
//                            Display.state = Display.STATE.MENU;
//                        }
//                    if(Display.state == Display.STATE.PAUSE )
//                        {
//                            Display.state = Display.STATE.PAUSE;
//                            //JOptionPane.showMessageDialog(null, "GAME PAUSED\n PRESS 'p' TO RESUME ");
//                        }
//                    if(Display.state == Display.STATE.GAME )
//                        {
//                            Display.state = Display.STATE.GAME;
//                            //JOptionPane.showMessageDialog(null, "GAME PAUSED\n PRESS 'p' TO RESUME ");
//                        } 

        }

    } //main()
} // TextRead
