
import java.io.*;

public class SaveScore {

    int fScore;
    // life, score, collide, Road.RoadYpos , Road.RoadY2pos, playerCar.carXpos,obstacle1.obstacleXpos,obstacle1.obstacleYpos,obstacle2.obstacleXpos,obstacle2.obstacleYpos

    public void saveScore(int Score) throws Exception {
        fScore = Score;
        try (
        FileWriter saveFile = new FileWriter("Scores.txt", true)) 
        {

            saveFile.append("\n" + Menu.playerName+"    " + fScore + "\n");
        
        }

    }
}
