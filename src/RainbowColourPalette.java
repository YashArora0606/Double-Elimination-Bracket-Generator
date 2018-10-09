/**
 * [RainbowColourPalette.java]
 * A rainbow colour palette
 * @author Katelyn Wang
 * September 19 2018
 */

//graphics imports
import java.awt.Color;

//util imports
import java.util.ArrayList;

public class RainbowColourPalette extends ColourPalette{
    private int red = 195;
    private int blue = 0;
    private int green = 0;
    private int changeRed;
    private int changeBlue;
    private int changeGreen;
    private static final int CHANGE = 60;
    private static final int UPPER_LIMIT = 255;
    private static final int LOWER_LIMIT = 0;
    private ArrayList<Color> colors = new ArrayList<>();

    /**
     * Constructor
     * @param matches number of matches (number of colours required)
     */
    public RainbowColourPalette(int matches){
        super();
        for (int i = 0; i < matches; i++){
            changeRed = LOWER_LIMIT;
            changeBlue = LOWER_LIMIT;
            changeGreen = LOWER_LIMIT;
            if (red == UPPER_LIMIT) {
                if (blue > LOWER_LIMIT) {
                    changeBlue = -CHANGE;
                } else {
                    changeGreen = CHANGE;
                }
            } else if (green == UPPER_LIMIT) {
                if (red > LOWER_LIMIT){
                    changeRed = -CHANGE;
                } else {
                    changeBlue = CHANGE;
                }
            } else if (blue == UPPER_LIMIT){
                if (green > LOWER_LIMIT){
                    changeGreen = -CHANGE;
                } else {
                    changeRed = CHANGE;
                }
            } else {
                changeRed = CHANGE;
            }

            red += changeRed;
            green += changeGreen;
            blue += changeBlue;
            if (red > UPPER_LIMIT){
                red = UPPER_LIMIT;
                blue = LOWER_LIMIT;
            }
            if (blue > UPPER_LIMIT){
                blue = UPPER_LIMIT;
                green = LOWER_LIMIT;
            }
            if (green > UPPER_LIMIT){
                green = UPPER_LIMIT;
                red = LOWER_LIMIT;
            }
            colors.add(new Color(red, green, blue, 150));
        }
    }

    /**
     * Returns the color palette
     * @return the ArrayList of generated colors
     */
    public ArrayList<Color> getColors() {
        return colors;
    }


}
