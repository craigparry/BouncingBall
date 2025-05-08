
/**
 * Craig Parry
 * This class is used to make an instance of the Ball Class for the game
 * BouncingBall. It needs to be run with BouncingBallGame.java,
 * Ball.java, Board.java, and Input.java
 */

import java.time.Duration;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.stage.*;
import javafx.scene.control.*;
import javafx.scene.*;
import javafx.scene.layout.*;
import javafx.scene.canvas.*;
import javafx.scene.paint.*;
import javafx.event.*;

public class BouncingBallGUI extends Application {

    private Board board = new Board();
    private Ball ball = new Ball();

    /**
     * Overrides the start method for the application class to
     * set up the GUI stage and apply the canvas
     *
     * @param stage
     * @return none
     */
    @Override
    public void start(Stage stage) {

        stage.setTitle("Bouncing Ball");
        Canvas canvas = new Canvas(250, 520);
        GraphicsContext gc = canvas.getGraphicsContext2D();
        /**
         * anonymous class to track the movement of the mouse
         * 
         * @param event
         * @return void
         *
         */
        canvas.setOnMouseMoved(event -> {
            // if gamestate is new game
            if (board.getState() == Input.NEW_GAME) {
                if (event.getY() <= 520 && event.getY() >= 500)
                    ball.setx(event.getX());
            }

            // System.out.println(" moved "
            // + event.getX() + " " + event.getY());
        });
        // canvas.addEventHandler(MouseEvent.MOUSE_PRESSED, event -> {
        // if(board.getState() == Input.NEW_GAME){
        // board.ballPlayed();
        // }
        //
        // // make button activated
        //
        // System . out . println (" pressed "
        // + event . getX () + " " + event . getY ());
        // });
        // MAKE A LABEL AND A BUTTON TO PUT ON THE 2ND PANE
        // MAKE A NEW PANE TO PUT AT THE BOTTOM OF THE MAIN PANE
        // WHICH WILL HOLD THE SLIDER AND THE BUTTON/LABEL
        Button reset = new Button("Reset");
        reset.setDisable(true);

        /**
         * anonymous class that handles button clicks on the reset button
         * 
         * @param EventHandler
         */
        reset.setOnAction(new EventHandler<ActionEvent>() {

            /**
             * overrides the handle method for the button event resets game
             * disables button, initializes new game and new ball
             * 
             * @param ActionEvent
             * @return void
             */
            @Override
            public void handle(ActionEvent event) {
                board.initGame();
                ball = new Ball();
                // deactivate button
                reset.setDisable(true);

            }
        });

        Button play = new Button("Play");
        play.setDisable(false);
        /**
         * anonymous class that handles button clicks on the play button
         * 
         * @param EventHandler
         */
        play.setOnAction(new EventHandler<ActionEvent>() {
            /**
             * This method overrides the handle method for the action event
             * sets the ball in play and disables the play button
             *
             * @param event
             * @return void
             */
            @Override
            public void handle(ActionEvent event) {
                // board.initGame();
                // ball = new Ball();
                // // deactivate button
                // reset.setDisable(true);
                if (board.getState() == Input.NEW_GAME) {
                    board.ballPlayed();
                    ball.sety(480);
                    play.setDisable(true);
                }
            }
        });
        Label scoreLabel = new Label("Points: " + board.getScore());
        BorderPane.setAlignment(canvas, Pos.CENTER);

        BorderPane.setAlignment(reset, Pos.CENTER_RIGHT);
        BorderPane.setAlignment(scoreLabel, Pos.CENTER_LEFT);
        BorderPane.setAlignment(scoreLabel, Pos.CENTER);

        BorderPane buttonPane = new BorderPane();
        buttonPane.setRight(reset);
        buttonPane.setLeft(scoreLabel);
        buttonPane.setCenter(play);
        BorderPane.setAlignment(buttonPane, Pos.BOTTOM_CENTER);

        BorderPane borderPane = new BorderPane();
        borderPane.setCenter(canvas);
        borderPane.setBottom(buttonPane);
        stage.setScene(new Scene(new StackPane(borderPane)));
        stage.show();

        AnimationTimer a = new AnimationTimer() {
            private long nextTime = 0;

            /**
             * This method handles the animation timer and draws the state
             * of the gameboard and the ball on the canvas
             *
             * @param long now
             * @return void
             */
            @Override
            public void handle(long now) {
                if (now > nextTime) {

                    if (board.getState() != Input.NEW_GAME) {
                        reset.setDisable(false);
                    }
                    if (board.getState() == Input.NEW_GAME) {
                        play.setDisable(false);
                    }
                    nextTime = now + Duration.ofNanos(1).toNanos();

                    for (int i = 0; i < 5; i++) {
                        for (int j = 0; j < 10; j++) {
                            if (board.getBoard()[i][j].getCover()) {
                                gc.setFill(Color.YELLOW);
                            } else {
                                gc.setFill(Color.BLUE);
                            }

                            gc.fillRect(i * 50, j * 50, 50, 50);
                            gc.setStroke(Color.RED);
                            gc.strokeRect(i * 50, j * 50, 50, 50);
                        }

                    }
                    gc.setFill(Color.GRAY);
                    gc.fillRect(0, 500, 250, 20);
                    gc.setFill(Color.RED);
                    if (board.getState() == Input.BALL_MOVING) {
                        ball.setx(ball.getx() + ball.getXDir());
                        ball.sety(ball.gety() + ball.getYDir());
                        if (board.boardLocation(ball.getx(), ball.gety())) {
                            board.hitWall(false);
                        }
                        scoreLabel.setText("Points: " + board.getScore());

                        // if the ball reaches the edges flip the direction of the ball
                        // logic to count the number of edges hit on the board
                        if (ball.getx() >= 230 || ball.getx() <= 0) {
                            ball.reverseXDir();
                            board.hitWall(true);
                        }

                        if (ball.gety() >= 480 || ball.gety() <= 0) {
                            ball.reverseYDir();
                            board.hitWall(true);
                        }

                    }

                    gc.fillOval(ball.getx(), ball.gety(), ball.getSize(), ball.getSize());

                }
            }
        };
        a.start();

    }
}
