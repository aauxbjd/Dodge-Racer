

import java.io.*;

public class Load{

     int LIFE,SCORE, RY , RY2, CX , O1X , O1Y, O2X, O2Y ;
        boolean hyperactive;
    public void loadFile() throws Exception {
        
       

        BufferedReader saveFile = new BufferedReader(new FileReader("TextSave.txt"));

        // Throw away the blank line at the top.
        saveFile.readLine(); 
        // Get the integer value from the String.
        LIFE = Integer.parseInt(saveFile.readLine());
        SCORE =Integer.parseInt(saveFile.readLine());
        RY =Integer.parseInt(saveFile.readLine());
        RY2 =Integer.parseInt(saveFile.readLine());
        CX =Integer.parseInt(saveFile.readLine());
        O1X =Integer.parseInt(saveFile.readLine());
        O1Y=Integer.parseInt(saveFile.readLine());
        O2X=Integer.parseInt(saveFile.readLine());
        O2Y=Integer.parseInt(saveFile.readLine());
        hyperactive=Boolean.parseBoolean(saveFile.readLine());
        
        // Not needed, but read blank line at the bottom.
        saveFile.readLine(); 

        saveFile.close();

        // Print out the values.
        System.out.println("x=" + LIFE + " y=" + SCORE + " z=" + RY + "\n");
        System.out.println("name: " + RY2 + " race: " + CX + "\n");
        System.out.println();

    } //main()
} // TextRead
