import java.lang.Math;

public class Board {

    private Tile[][] gameBoard;
    private Input gameState;
    private int wallsHit;
    private int score;

    public Board() {
        gameBoard = new Tile[5][10];
        initGame();
        score = 0;
    }

    public int getScore() {
        return score;
    }

    public Input getState() {
        return gameState;
    }

    public void ballPlayed() {
        gameState = Input.BALL_MOVING;
    }

    /**
     * if the ball hits a wall then true hit is passed and increment wallsHit
     * if a block is hit false is passed and wallsHit resets to zero
     * if wallsHit is 3 the gamestate is changed  to GAME_OVER
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

    public void initGame() {
        wallsHit = 0;
        gameState = Input.NEW_GAME;
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 10; j++) {
                gameBoard[i][j] = new Tile();
            }
        }

        /*math random for x and y coordinates for a certain amount of tiles that will
         * be covered then make those tiles on the board covered*/
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

    // make an initialize board for the reset button to work with
    public Tile[][] getBoard() {
        return gameBoard;
    }

    public class Tile {
        private boolean cover;

        public Tile() {
            cover = false;
        }

        public void changeCover() {
            if (cover) {
                cover = false;
                return;
            }
            cover = true;
        }

        public boolean getCover() {
            return cover;
        }
    }
}
