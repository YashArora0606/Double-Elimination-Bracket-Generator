/**
 * [MatchBox.java]
 * The box object of each match displayed on the screen
 * @author Katelyn Wang
 * September 18 2018
 */

//geometric imports
import java.awt.geom.RoundRectangle2D;

public class MatchBox {
    private RoundRectangle2D rect;
    private int x;
    private int y;
    private int length;
    private int height;
    private int roundIndex;
    private int round;

    /**
     * Constructor - Single Tournament Panel
     * @param x the top left x value
     * @param y the top left y value
     * @param length the length of the box
     * @param height the height of the box
     * @param arch the arch of the box (for the rounded corners)
     */
    public MatchBox(int x, int y, int length, int height, int arch){
        this.rect = new RoundRectangle2D.Float(x,y, length, height, arch, arch);
        this.x = x;
        this.y = y;
        this.length = length;
        this.height = height;
    }

    /**
     * Constructor - Double Tournament Panel
     * @param roundIndex the index within its own round
     * @param round the round the match is within
     * @param x the top left x value
     * @param y the top left y value
     * @param length the length of the box
     * @param height the height of the box
     * @param arch the arch of the box (for the rounded corners)
     */
    public MatchBox(int roundIndex, int round, int x, int y, int length, int height, int arch){
        this.rect = new RoundRectangle2D.Float(x,y, length, height, arch, arch);
        this.x = x;
        this.y = y;
        this.length = length;
        this.height = height;
        this.round = round;
        this.roundIndex = roundIndex;
    }

    /**
     * Returns the middle point on the y axis of the box
     * @return the middle Y value
     */
    public int getMidY(){
        return y + height/2;
    }

    /**
     * @return the top right x value
     */
    public int getRightX(){
        return x+length;
    }

    /**
     * @return the top left y  value
     */
    public int getY(){
        return y;
    }

    /**
     * Returns the middle point on the x axis of the box
     * @return the middle X value
     */
    public int getMidX(){
        return x+length/2;
    }

    /**
     * @return the index of the match within its own round
     */
    public int getRound(){
        return round;
    }

    /**
     * @return the index of the round it is within
     */
    public int getRoundIndex(){
        return roundIndex;
    }

    /**
     * @return the top right x value
     */
    public int getX(){
        return x;
    }

    /**
     * @return the rectangle object which represents the match
     */
    public RoundRectangle2D getRect() {
        return rect;
    }

}
