/**
 * [ColourPalette.java]
 * Abstract class to organize the colour palettes
 * @author Katelyn Wang
 * September 20 2018
 */

//graphics imports
import java.awt.Color;
//util imports
import java.util.ArrayList;

abstract public class ColourPalette {
    ColourPalette(){
    }

    /**
     * Returns the color palette
     * @return the ArrayList of colors
     */
    abstract public ArrayList<Color> getColors();

}
