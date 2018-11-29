
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
