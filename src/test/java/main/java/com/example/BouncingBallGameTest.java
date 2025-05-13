// package main.java.com.example;

// import org.junit.jupiter.api.Test;
// import static org.junit.jupiter.api.Assertions.*;

// class BouncingBallGameTest {

// @Test
// void testBallReversesDirectionOnEdgeCollision() {
// Ball ball = new Ball(0, 0, 1, 1); // Ball starts at (0, 0) moving diagonally
// GameBoard board = new GameBoard(10, 10); // 10x10 game board

// ball.move();
// assertEquals(1, ball.getX());
// assertEquals(1, ball.getY());

// ball.setPosition(9, 9); // Place ball at the bottom-right corner
// ball.move();
// assertTrue(ball.getXDirection() < 0); // Ball should reverse X direction
// assertTrue(ball.getYDirection() < 0); // Ball should reverse Y direction
// }

// @Test
// void testScoreIncrementsOnTileHit() {
// GameBoard board = new GameBoard(10, 10);
// Ball ball = new Ball(5, 5, 1, 1); // Ball starts at (5, 5)

// board.coverTile(6, 6); // Cover a tile at (6, 6)
// ball.setPosition(6, 6); // Move ball to the covered tile
// board.checkCollision(ball);

// assertEquals(10, board.getScore()); // Score should increment by 10
// }

// @Test
// void testGameOverAfterThreeWallHits() {
// GameBoard board = new GameBoard(10, 10);
// Ball ball = new Ball(0, 0, -1, -1); // Ball starts at (0, 0) moving out of
// bounds

// for (int i = 0; i < 3; i++) {
// ball.move();
// board.checkCollision(ball); // Simulate wall collisions
// }

// assertTrue(board.isGameOver()); // Game should be over after 3 wall hits
// }
// }