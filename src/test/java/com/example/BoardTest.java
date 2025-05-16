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
        // try mocking again later
        // This is bad code, should be refactored to allow for easier testing to
        // indicate a successful state transfer
        // independent of the outcome of the non deterministic method

    }

    @Test
    void testGetBoard() {
        Board.Tile[][] gameboard = board.getBoard();
        assertNotNull(gameboard, "Game board should not be null");
        assertEquals(5, gameboard.length, "Game board should have 5 rows");
        assertEquals(10, gameboard[0].length, "Game board should have 10 columns");
    }

    @Test
    void testChangeCover() {
        Board gameboard = new Board();
        boolean cover = gameboard.getBoard()[0][0].getCover();
        gameboard.getBoard()[0][0].changeCover();
        if (cover) {
            assertFalse(gameboard.getBoard()[0][0].getCover(), "Tile cover should be false");
        } else {
            assertTrue(gameboard.getBoard()[0][0].getCover(), "Tile cover should be true");
        }
    }

    @Test
    void testGetCover() {
        Board gameboard = new Board();
        boolean cover = gameboard.getBoard()[0][0].getCover();
        assertEquals(cover, gameboard.getBoard()[0][0].getCover(), "Tile cover should be true");
    }

}