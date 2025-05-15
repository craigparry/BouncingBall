package com.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class BoardTest {
    Board board = new Board();

    @Test
    void testInitGame() {
        board.initGame();
        Input state = board.getState();
        int score = board.getScore();
        Board.Tile[][] gameboard = board.getBoard();
        assertAll("Grouped Assertions",
                () -> assertEquals(0, score, "Initial walls hit should be 0"),
                () -> assertEquals(Input.NEW_GAME, state, "Initial game state should be NEW_GAME"),
                () -> assertNotNull(gameboard, "Game state should not be null after initialization"),
                () -> assertEquals(0, board.getScore(), "Initial score should be 0"));
    }

    @Test
    void testGetScore() {
        assertEquals(0, board.getScore(), "Initial score should be 0");
    }

    @Test
    void testGetState() {
        assertEquals(Input.NEW_GAME, board.getState(), "Initial game state should be NEW_GAME");
    }

    @Test
    void testBallPlayed() {
        board.ballPlayed();
        assertEquals(Input.BALL_MOVING, board.getState(), "Game state should be BALL_MOVING after ball played");
    }

    @Test
    void testHitWall() {
        board.ballPlayed();
        board.hitWall(true);
        board.hitWall(false);
        assertEquals(Input.BALL_MOVING, board.getState(), "Game state should be BALL_MOVING after hitting a tile");

        for (int i = 0; i < 3; i++) {
            board.hitWall(true);
        }
        assertEquals(Input.GAME_OVER, board.getState(), "Game state should be GAME_OVER after 3 hits");
    }

    @Test
    void testBoardLocation() {
        // assertAll("Grouped Assertions",
        // () -> assertTrue(board.boardLocation(0, 0), "Ball should be within board
        // bounds"),
        // () -> assertTrue(board.boardLocation(4, 9), "Ball should be within board
        // bounds"),
        // () -> assertTrue(board.boardLocation(5, 5), "Ball should be out of bounds"),
        // () -> assertTrue(board.boardLocation(4, 10), "Ball should be out of bounds"),
        // () -> assertTrue(board.boardLocation(-1, 5), "Ball should be out of bounds"),
        // () -> assertTrue(board.boardLocation(4, -1), "Ball should be out of
        // bounds"));

    }
}