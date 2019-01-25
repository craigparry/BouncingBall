public class Ball {

    private double x;
    private double y;
    private int size;
    private int yDir;
    private int xDir;

    public Ball(){
        size = 20;
        y =480;
        yDir = -randomYDir();
        xDir = randomXDir();
    }
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

    public int randomXDir() {
        // define the range
        int max = 8;
        int min = -8;
        int range = max - min + 1;

        // generate random numbers within 1 to 10

        return (int) (Math.random() * range) + min;
    }


    public int getSize(){
        return size;
    }
    public double getx(){
        return x;
    }
    public void setx(double x){
        this.x = x;
    }
    public double gety(){
        return y;
    }
    public void sety(double y){
        this.y =y;
    }

    public int getXDir(){
        return xDir;
    }
    public int getYDir(){
        return yDir;
    }
    public void reverseYDir(){
        yDir = -yDir;
    }
    public void reverseXDir(){
        xDir = -xDir;
    }
}
