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
import javafx.scene.input.MouseEvent;


public class BouncingBallGUI extends Application {

    private Board board = new Board();

    private Ball ball = new Ball();
    //    private int width =250;
    private int height = (500 + ball.getSize());

    @Override
    public void start(Stage stage) {

        stage.setTitle("Bouncing Ball");
        Canvas canvas = new Canvas(250, 520);
        GraphicsContext gc = canvas.getGraphicsContext2D();

        canvas.setOnMouseMoved(event -> {
            // if gamestate is new game
            if (board.getState() == Input.NEW_GAME) {
                if (event.getY() <= 520 && event.getY() >= 500)
                    ball.setx(event.getX());
            }

            System.out.println(" moved "
                    + event.getX() + " " + event.getY());
        });
//        canvas.addEventHandler(MouseEvent.MOUSE_PRESSED, event -> {
//            if(board.getState() == Input.NEW_GAME){
//                board.ballPlayed();
//            }
//
//            // make button activated
//
//            System . out . println (" pressed "
//                    + event . getX () + " " + event . getY ());
//        });
        // MAKE A LABEL AND A BUTTON TO PUT ON THE 2ND PANE
        // MAKE A NEW PANE TO PUT AT THE BOTTOM OF THE MAIN PANE
        // WHICH WILL HOLD THE SLIDER AND THE BUTTON/LABEL
        Button reset = new Button("Reset");
        reset.setDisable(true);
        reset.setOnAction(new EventHandler<ActionEvent>() {
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
        play.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
//                board.initGame();
//                ball = new Ball();
//                // deactivate button
//                reset.setDisable(true);
                if (board.getState() == Input.NEW_GAME) {
                    board.ballPlayed();
                    ball.sety(490);
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

                        if (ball.gety() >= 500 || ball.gety() <= 0) {
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

