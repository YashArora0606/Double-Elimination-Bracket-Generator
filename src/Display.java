/**
 * [Display.java]
 * The frame on which the bracket is displayed
 * @author Katelyn Wang
 * September 18 2018
 */

//Swing imports
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.ImageIcon;

//Graphics imports
import java.awt.Toolkit;

//Keyboard imports
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;

public class Display extends JFrame{
    private static final int BOX_HEIGHT = 100;
    private static final int BOX_LENGTH = 240;
    private static final int VERTICAL_SPACE = 30;
    private static final int HORIZONTAL_SPACE = 100;
    private static final int BORDER_SPACE = 20;
    private JFrame frame;
    private TournamentPanel tournamentPanel;
    private Bracket tournament;

    /**
     * Constructor
     * @param tournament tournament bracket
     */
    public Display(Bracket tournament){
        super("Kraft Dinner Display ©");
        this.frame = this;
        this.tournament = tournament;

        int maxX; //frame length
        int maxY; //frame height
        int requiredHeight; //the calculated height required
        int requiredLength; //the calculated length required

        //creates tournament panel accordingly
        if (tournament.getClass().getSimpleName().equals("SingleBracket")) { //checks if it is a single or double bracket
            requiredHeight = findNumMostMatches() * (BOX_HEIGHT + VERTICAL_SPACE) + BORDER_SPACE * 2 + 30; //if single, finds the height by using the round with the highest number of matches
            requiredLength = (tournament.getNumberOfRounds() * BOX_LENGTH) + ((tournament.getNumberOfRounds() - 1) * HORIZONTAL_SPACE) + BORDER_SPACE*2 + 200;
            tournamentPanel = new SingleTournamentPanel(tournament, requiredLength, requiredHeight, BOX_HEIGHT, BOX_LENGTH);
        } else {
            requiredHeight = (int) (findMostTypeMatches(1)+findMostTypeMatches(0)) * (BOX_HEIGHT + VERTICAL_SPACE) + BORDER_SPACE * 2 + 100; // if double, finds the height using the highest number of winner matches and highest number of loser matches
            requiredLength = (tournament.getNumberOfRounds() * BOX_LENGTH) + ((tournament.getNumberOfRounds() - 1) * HORIZONTAL_SPACE) + BORDER_SPACE*2 + 250;
            tournamentPanel = new DoubleTournamentPanel(tournament, requiredLength, requiredHeight, BOX_HEIGHT, BOX_LENGTH, findMostTypeMatches(1)/(findMostTypeMatches(0)+findMostTypeMatches(1)));
        }

        //sets the limits for the JFrame
        if (requiredHeight > Toolkit.getDefaultToolkit().getScreenSize().getHeight()) { //checks if the required size is greater than the screen size; if so, will set the height to the screen's height, if not, will set it to whatever the required height is
            maxY = (int) Math.round(Toolkit.getDefaultToolkit().getScreenSize().getHeight());
        } else {
            maxY = requiredHeight + 60;
        }
        if (requiredLength > Toolkit.getDefaultToolkit().getScreenSize().getWidth()){ //same thing as above with length
            maxX = (int) Math.round(Toolkit.getDefaultToolkit().getScreenSize().getWidth());
        } else {
            maxX = requiredLength + 40;
        }

        ImageIcon icon = new ImageIcon("assets/Icon.png");
        this.setIconImage(icon.getImage());
        this.setSize(maxX, maxY);
        this.setLocationRelativeTo(null); //start the frame in the center of the screen
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setUndecorated(false);

        JScrollPane sp = new JScrollPane(tournamentPanel, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED); //initializing scrollpane
        sp.setViewportView(tournamentPanel);
        this.add(sp);

        MyKeyListener keyListener = new MyKeyListener(); //adding key listener
        this.addKeyListener(keyListener);

        this.setVisible(true);
    }

    /**
     * Determines how many matches are in the round with the most matches
     * @return the number of matches in the round with the most matches
     */
    private int findNumMostMatches(){
        int most = 0;
        for (int i = 1; i <= tournament.getNumberOfRounds(); i++){
            if (tournament.getNumberOfMatchesInRound(i) >= most){
                most = tournament.getNumberOfMatchesInRound(i);
            }
        }
        return most;
    }

    /**
     * Finds the number of a certain type of matches within a round (0 for winner bracket matches, 1 for loser bracket matches)
     * @param roundNum the round number
     * @param type the type of matches (0 for winner bracket matches, 1 for loser bracket matches)
     * @return the total number of the given type of matches within the specified round
     */
    private int findNumMatches(int roundNum, int type){
        int sum = 0;
        for (int i = 1; i <= tournament.getNumberOfMatchesInRound(roundNum); i++ ){
            if (tournament.getMatchBracket(roundNum, i) == type){
                sum++;
            }
        }
        return sum;
    }

    /**
     * Finds the most number of a certain type of matches within the entire bracket
     * @param type the type of matches (0 for winner bracket matches, 1 for loser bracket matches)
     * @return the most number of the specified type or matches within the tournament bracket (returns as double to maintain precision to calculate ratio required for winner bracket to loser bracket)
     */
    private double findMostTypeMatches(int type){
        double most = 0;
        for (int i = 1; i <= tournament.getNumberOfRounds(); i++){
            if (findNumMatches(i,type) >= most){
                most = findNumMatches(i, type);
            }
        }
        return most;
    }

    /**
     * Updates the bracket by calling it to be redrawn
     * @param tournament The updated tournament bracket to be drawn
     */
    public void update(Bracket tournament){
        tournamentPanel.setTournament(tournament);
    }

    //---------------------PRIVATE CLASS---------------------//

    private class MyKeyListener implements KeyListener{
        public void keyPressed(KeyEvent e){
            if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {  //If ESC is pressed
                frame.dispose(); //close frame
            }
        }

        public void keyReleased(KeyEvent e){
        }

        public void keyTyped(KeyEvent e){
        }
    }

}
