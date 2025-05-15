package com.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class BouncingBallGameTest {

    // todo: refactor these test cases to use the classes correctly
    Ball ball = new Ball();

    @Test
    void testRandomYDir() {

        int yDir = ball.randomYDir();
        assertTrue(yDir >= 3 && yDir <= 8, "Y direction should be between 3 and 8");

    }

    @Test
    void testRandomXDir() {
        int xDir = ball.randomXDir();
        assertTrue(xDir >= -8 && xDir <= 8, "Y direction should be between 3 and 8");

    }

    @Test
    void testGetSize() {

        assertTrue(ball.getSize() == 20, "Ball size should be 20");

    }

    @Test
    void testGetx() {
        assertTrue(ball.getx() == 115, "Ball X position should equal to the initial value of 115");
    }

    @Test
    void testGety() {
        assertTrue(ball.gety() == 500, "Ball X position should equal to the initial value of 500");
    }

    @Test
    void testGetxDir() {
        assertTrue(ball.getXDir() >= 0, "Ball X direction should be positive");
    }

    @Test
    void testGetyDir() {
        assertTrue(ball.getYDir() <= 0, "Ball Y direction should be negative");
    }

    @Test
    void testReverseXDirection() {
        int xDir = ball.getXDir();
        ball.reverseXDir();
        assertTrue(ball.getXDir() == -xDir, "Ball X direction should be reversed");
    }

    @Test
    void testReverseYDirection() {
        int yDir = ball.getYDir();
        ball.reverseYDir();
        assertTrue(ball.getYDir() == -yDir, "Ball Y direction should be reversed");
    }

    // chatgpt hallucination!
    // @Test
    // void testBallReversesDirectionOnEdgeCollision() {
    // Ball ball = new Ball(); // Ball starts at (0, 0) moving diagonally
    // Board board = new Board(); // 10x10 game board
    // board.initGame();

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
}