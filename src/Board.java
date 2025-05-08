
/**
 * Craig Parry
 * This class is used to make an instance of the game board for the game
 * BouncingBall. It needs to be run with BouncingBallGame.java,
 * BouncingBallGUI.java, Ball.java, and Input.java
 */

import java.lang.Math;

public class Board {

    private Tile[][] gameBoard;
    private Input gameState;
    private int wallsHit;
    private int score;

    /**
     * Constructor for the board class takes no arguments
     */
    public Board() {
        gameBoard = new Tile[5][10];
        initGame();
        score = 0;
    }

    /**
     * This method returns the score of the game returns an int
     *
     * @param none
     * @return int
     */
    public int getScore() {
        return score;
    }

    /**
     * This method gets the Input state of the game
     *
     * @param none
     * @return Input
     */
    public Input getState() {
        return gameState;
    }

    /**
     * This method changes the gamestate associated with the board
     *
     * @param none
     * @return void
     */
    public void ballPlayed() {
        gameState = Input.BALL_MOVING;
    }

    /**
     * if the ball hits a wall then true hit is passed and increment wallsHit
     * if a block is hit false is passed and wallsHit resets to zero
     * if wallsHit is 3 the gamestate is changed to GAME_OVER
     *
     * @param boolean hit
     * @return void
     */

    public void hitWall(boolean hit) {
        if (hit) {
            wallsHit++;
            if (wallsHit == 3) {
                gameState = Input.GAME_OVER;
            }
        }
        if (!hit) {
            wallsHit = 0;
        }
    }

    /**
     * This method takes a x and y value to find the associated tile on the
     * board that the ball is moving over and changes the tile from covered
     * to uncovered or does nothing if the tile is not covered. Sideeffect
     * increments the score when moving over a covered tile. returns true
     * if moving over a coverd tile and false otherwise.
     *
     * @param x
     * @param y
     * @return boolean
     */
    public boolean boardLocation(double x, double y) {
        int col = (int) x / 50;
        int row = (int) y / 50;

        if (gameBoard[col][row].getCover()) {
            gameBoard[col][row].changeCover();
            score += 10;
            return true;
        }
        return false;
    }

    /**
     * This method initializes a new game: changes input state to New Game
     * initializes the gameboard and assigns random covered tiles
     *
     * @param none
     * @return void
     */
    public void initGame() {
        wallsHit = 0;
        gameState = Input.NEW_GAME;
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 10; j++) {
                gameBoard[i][j] = new Tile();
            }
        }

        /*
         * math random for x and y coordinates for a certain
         * amount of tiles that will be covered then make those tiles
         * on the board covered
         */
        double randx = Math.random();
        double randy = Math.random();
        int x;
        int y;
        int k = 0;
        while (k < 10) {
            randx = Math.random() * 5;
            randy = Math.random() * 10;
            x = (int) randx;
            y = (int) randy;
            if (!gameBoard[x][y].getCover()) {
                gameBoard[x][y].changeCover();
                k++;
            }
        }

    }

    /**
     * This method returns the gameboard associated with this instance
     *
     * @param none
     * @return Tile[][] gameboard
     */
    // make an initialize board for the reset button to work with
    public Tile[][] getBoard() {
        return gameBoard;
    }

    /**
     * This nested class creates the tile objects used on the gameboard
     */
    public class Tile {
        private boolean cover;

        /**
         * This constructor creates instances of the tile class initialized
         * as uncovered
         */
        public Tile() {
            cover = false;
        }

        /**
         * This method changes the covered status of the tile object if covered
         * then uncovers and covers if uncovered
         *
         * @param none
         * @return void
         */
        public void changeCover() {
            if (cover) {
                cover = false;
                return;
            }
            cover = true;
        }

        /**
         * This method returns the covered status of the tile object
         *
         * @param none
         * @return boolen
         */
        public boolean getCover() {
            return cover;
        }
    }
}
