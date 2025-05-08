import javafx.application.Application;

/**
 * Craig Parry
 * This class is used to make an instance of the BouncingBallGame and
 * initializes
 * the graphical interface for the game. It needs to be run with
 * Ball.java, BouncingBallGUI.java, Board.java, and Input.java
 */

public class BouncingBallGame {
    public static void main(String[] args) {

        /* initializes the game */
        // BouncingBallGUI game = new BouncingBallGUI();
        // Application.launch(args);
        Application.launch(BouncingBallGUI.class, args);
    }
}