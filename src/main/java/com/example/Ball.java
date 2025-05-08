package main.java.com.example;

/**
 * Craig Parry
 * This class is used to make an instance of the Ball Class for the game
 * BouncingBall. It needs to be run with BouncingBallGame.java,
 * BouncingBallGUI.java, Board.java, and Input.java
 */

public class Ball {

    private double x;
    private double y;
    private int size;
    private int yDir;
    private int xDir;

    /**
     * constructor for the Ball class
     */
    public Ball() {
        size = 20;
        y = 500;
        x = 115;
        yDir = -randomYDir();
        xDir = randomXDir();
    }

    /**
     * This method initializes creates a random Y direction for ball movement
     * 
     * @param none
     * @return int
     */
    // range for ball movement y value -3 through -8 for inital
    // range for x value -3 -8
    public int randomYDir() {
        // define the range
        int max = 8;
        int min = 3;
        int range = max - min + 1;

        // generate random numbers within 1 to 10

        return (int) (Math.random() * range) + min;
    }

    /**
     * This method initializes creates a random X direction for ball movement
     * 
     * @param none
     * @return int
     */
    public int randomXDir() {
        // define the range
        int max = 8;
        int min = -8;
        int range = max - min + 1;

        // generate random numbers within 1 to 10

        return (int) (Math.random() * range) + min;
    }

    /**
     * This method gets the size of the ball object
     * 
     * @param none
     * @return int
     */
    public int getSize() {
        return size;
    }

    /**
     * this method gets the current x value of the balls location
     * 
     * @param none
     * @return double
     */
    public double getx() {
        return x;
    }

    /**
     * this method sets the current x value of the balls location
     * 
     * @param double
     * @return void
     */
    public void setx(double x) {
        this.x = x;
    }

    /**
     * this method gets the current y value of the balls location
     * 
     * @param none
     * @return double
     */
    public double gety() {
        return y;
    }

    /**
     * this method sets the current y value of the balls location
     * 
     * @param double
     * @return void
     */
    public void sety(double y) {
        this.y = y;
    }

    /**
     * This method gets the current x direction of the ball
     * 
     * @param none
     * @return int
     */
    public int getXDir() {
        return xDir;
    }

    /**
     * This method gets the current y direction of the ball
     * 
     * @param none
     * @return int
     */
    public int getYDir() {
        return yDir;
    }

    /**
     * This method reverses the y direction of the ball
     * 
     * @param none
     * @return void
     */
    public void reverseYDir() {
        yDir = -yDir;
    }

    /**
     * This method reverses the x direction of the ball
     * 
     * @param none
     * @return void
     */
    public void reverseXDir() {
        xDir = -xDir;
    }
}
