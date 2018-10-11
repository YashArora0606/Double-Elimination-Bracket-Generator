/* ManagementSystem.java
 * The UI for the tournament software
 * October 8, 2018
 * Raymond Wang
 */


//Imports

import javax.swing.*;
import javax.swing.border.*;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JScrollPane;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;
import javax.swing.text.DefaultCaret;

import java.io.File;
import java.io.IOException;

import java.util.*;
import java.util.ArrayList;

/**
 * ManagementSystem
 * The UI for the user to enter teams
 *
 * @param nothing
 * @return void
 */
public class ManagementSystem {
	
	public static final boolean DOUBLE_SEED = false;

    private GraphicsPanel canvas;
    private BufferedImage background;

    //JPanels
    private JPanel westPanel;
    private JPanel eastPanel;
    private JPanel southPanel;
    private JPanel centerPanel;
    private JPanel leftMainPanel;
    private JPanel rightMainPanel;
    

    //JTextFields
    private JTextField nameField;
    private JTextField roundField;
    private JTextField matchField;

    private JTextArea mainField;
    private JScrollPane myScrollPane;
    private DefaultCaret caret;

    //JLabels
    private JLabel titleLabel;
    private JLabel promptLabel;
    private JLabel nameLabel;
    private JLabel roundLabel;
    private JLabel matchLabel;
    private JLabel errorMessage;

    private JLabel leftBlank1;
    private JLabel leftBlank2;
    private JLabel rightBlank1;
    private JLabel rightBlank2;
    private JLabel rightBlank3;

    //JButtons
    private JButton generateUnseededSinglesButton;
    private JButton generateSeededSinglesButton;
    private JButton generateDoublesButton;
    private JButton updateButton;

    private ArrayList<Team> teamList = new ArrayList<Team>();
    private String[] teams;
    private String[][] teamsInMatch;
    private int seed;
private boolean bracketCreated=false;

    public Bracket bracket;
    public Display bracketDisplay;
    public SingleGenerator singleSeededGen;
    public SingleGenerator singleUnseededGen;
    


    /**
     * ManagementSystem
     * Constructs a new management system
     * @param nothing
     * @return void
     */
    ManagementSystem() {
        JFrame mainWindow = new JFrame("ManGo Tournament Generator");
        mainWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainWindow.setExtendedState(JFrame.MAXIMIZED_BOTH);
        mainWindow.setResizable(true);
        mainWindow.setUndecorated(true);

        canvas = new GraphicsPanel();
        canvas.setLayout(new BorderLayout());

        //Title Label
        titleLabel = new JLabel("ManGo Tournament Generator", SwingConstants.CENTER);
        titleLabel.setPreferredSize(new Dimension(1920, 100));
        titleLabel.setOpaque(false);
        //titleLabel.setFont(new Font("Century Gothic", Font.BOLD, 32));
        titleLabel.setFont(getFont("assets/Comfortaa-Light.ttf", 32));

        

        titleLabel.setForeground(Color.WHITE);
        canvas.add(titleLabel, BorderLayout.NORTH);

        //Border
        westPanel = new JPanel();
        westPanel.setPreferredSize(new Dimension(250, 1080));
        westPanel.setLayout(new GridLayout(2, 2));
        westPanel.setOpaque(false);
        canvas.add(westPanel, BorderLayout.WEST);

        eastPanel = new JPanel();
        eastPanel.setPreferredSize(new Dimension(250, 1080));
        eastPanel.setBorder(new EmptyBorder(175, 0, 175, 25));
        eastPanel.setOpaque(false);
        canvas.add(eastPanel, BorderLayout.EAST);

        southPanel = new JPanel();
        southPanel.setPreferredSize(new Dimension(1920, 100));
        southPanel.setOpaque(false);
        canvas.add(southPanel, BorderLayout.SOUTH);

        //Center Panel
        centerPanel = new JPanel(new GridLayout(1, 2));
        centerPanel.setOpaque(false);
        canvas.add(centerPanel, BorderLayout.CENTER);

        leftMainPanel = new JPanel(new GridBagLayout());
        GridBagConstraints l = new GridBagConstraints();
        leftMainPanel.setOpaque(false);
        centerPanel.add(leftMainPanel);

        rightMainPanel = new JPanel(new GridBagLayout());
        GridBagConstraints r = new GridBagConstraints();
        rightMainPanel.setOpaque(false);
        centerPanel.add(rightMainPanel);

        //LEFT MAIN PANEL
        //Main Prompt
        promptLabel = new JLabel("<html>" + "Enter teams, one per line." +
                "<br>" + "Ordered by seed, best to worst." + "</html>");
        //promptLabel.setFont(new Font("Century Gothic", Font.BOLD, 16));
        
        promptLabel.setFont(getFont("assets/Comfortaa-Light.ttf", 16));

        promptLabel.setForeground(Color.WHITE);
        l.anchor = GridBagConstraints.FIRST_LINE_START;
        l.fill = GridBagConstraints.HORIZONTAL;
        l.gridx = 0;
        l.gridy = 0;
        l.gridwidth = 3;
        leftMainPanel.add(promptLabel, l);

        //Scrolling JText Area
        mainField = new JTextArea(10, 10);
        mainField.setOpaque(false);
        mainField.setBorder(javax.swing.BorderFactory.createEmptyBorder());
        caret = (DefaultCaret) mainField.getCaret();
        caret.setUpdatePolicy(DefaultCaret.ALWAYS_UPDATE);
        mainField.setCaretPosition(mainField.getDocument().getLength());
        mainField.setCaretColor(Color.WHITE);
        mainField.setForeground(Color.WHITE);

        myScrollPane = new JScrollPane(mainField);
        myScrollPane.setBorder(javax.swing.BorderFactory.createEmptyBorder());
        myScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_NEVER);
        myScrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        myScrollPane.getViewport().setOpaque(false);
        myScrollPane.setOpaque(false);
        myScrollPane.setForeground(Color.WHITE);
        l.anchor = GridBagConstraints.CENTER;
        l.fill = GridBagConstraints.HORIZONTAL;
        l.gridx = 0;
        l.gridy = 2;
        l.gridwidth = 3;
        l.ipady = 125;
        leftMainPanel.add(myScrollPane, l);
        l.ipady = 0;

        //Blank Lines
        leftBlank1 = new JLabel("________________________________________________________________________");
        leftBlank1.setForeground(Color.WHITE);
        l.gridx = 0;
        l.gridy = 1;
        l.gridwidth = 3;
        leftMainPanel.add(leftBlank1, l);

        leftBlank2 = new JLabel("¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯");
        leftBlank2.setForeground(Color.WHITE);
        l.gridx = 0;
        l.gridy = 3;
        l.gridwidth = 3;
        leftMainPanel.add(leftBlank2, l);

        //Error Message
        errorMessage = new JLabel("");
        errorMessage.setOpaque(false);
        
        //errorMessage.setFont(new Font("Century Gothic", Font.BOLD, 24));
        errorMessage.setFont(getFont("assets/Comfortaa-Light.ttf", 24));

        errorMessage.setForeground(Color.WHITE);
        southPanel.add(errorMessage);

        //Buttons
        //Unseeded Single Generator Button
        generateUnseededSinglesButton = new JButton("<html><center>" + "Generate" + "<br>" + "Unseeded Singles Bracket" + "</center></html>");
        generateUnseededSinglesButton.setOpaque(false);
        generateUnseededSinglesButton.setContentAreaFilled(false);
        generateUnseededSinglesButton.setBorderPainted(false);
        //generateUnseededSinglesButton.setFont(new Font("Century Gothic", Font.BOLD, 14));
        generateUnseededSinglesButton.setFont(getFont("assets/Comfortaa-Light.ttf", 14));

        generateUnseededSinglesButton.setForeground(Color.WHITE);
        generateUnseededSinglesButton.setVerticalTextPosition(SwingConstants.CENTER);
        generateUnseededSinglesButton.setHorizontalTextPosition(SwingConstants.CENTER);
        l.anchor = GridBagConstraints.LINE_START;
        l.gridx = 0;
        l.gridy = 4;
        l.gridwidth = 1;
        l.ipadx = 55;
        leftMainPanel.add(generateUnseededSinglesButton, l);
        l.ipadx = 0;

        generateUnseededSinglesButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                errorMessage.setText(null);
                teams = null;
                teamList.clear();
                teams = mainField.getText().split("\n");

                if (teams.length >= 3) {
                    if (!hasDuplicates(teams)) {
                        for (int i = 0; i < teams.length; i++) {
                            Team newTeam = new Team(teams[i]);
                            teamList.add(newTeam);
                        }

                        singleUnseededGen = new SingleGenerator(teamList, false);
                        bracket = singleUnseededGen.getBracket();
                        bracketCreated=true;
                        bracketDisplay = new Display(bracket);

                    } else {
                        errorMessage.setText("Make sure there are no duplicate team names.");
                    }
                } else {
                    errorMessage.setText("Make sure there are at least 3 teams.");
                }
            }
        });

        //Seeded Single Generator Button
        generateSeededSinglesButton = new JButton("<html><center>" + "Generate" + "<br>" + "Seeded Singles Bracket" + "</center></html>");
        //generateSeededSinglesButton.setFont(new Font("Century Gothic", Font.BOLD, 14));
        generateUnseededSinglesButton.setFont(getFont("assets/Comfortaa-Light.ttf", 14));
        generateSeededSinglesButton.setForeground(Color.WHITE);
        generateSeededSinglesButton.setVerticalTextPosition(SwingConstants.CENTER);
        generateSeededSinglesButton.setHorizontalTextPosition(SwingConstants.CENTER);
        generateSeededSinglesButton.setOpaque(false);
        generateSeededSinglesButton.setContentAreaFilled(false);
        generateSeededSinglesButton.setBorderPainted(false);
        l.gridx = 1;
        l.gridy = 4;
        l.ipadx = 55;
        l.anchor = GridBagConstraints.CENTER;
        leftMainPanel.add(generateSeededSinglesButton, l);
        l.ipadx = 0;

        generateSeededSinglesButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                errorMessage.setText(null);
                teams = null;
                teamList.clear();
                teams = mainField.getText().split("\n");
                seed = 1;

                if (teams.length >= 3) {
                    if (!hasDuplicates(teams)) {
                        for (int i = 0; i < teams.length; i++) {
                            Team newTeam = new Team(teams[i], seed);
                            teamList.add(newTeam);
                            seed += 1;
                        }

                        Collections.sort(teamList);
                        singleSeededGen = new SingleGenerator(teamList, true);
                        bracket = singleSeededGen.getBracket();
                        bracketCreated=true;
                        bracketDisplay = new Display(bracket);

                    } else {
                        errorMessage.setText("Make sure there are no duplicate team names.");
                    }
                } else {
                    errorMessage.setText("Make sure there are at least 3 teams.");
                }
            }
        });

        //Double Generator Button
        generateDoublesButton = new JButton("<html><center>" + "Generate" + "<br>" + "Doubles Bracket" + "</center></html>");
        generateDoublesButton.setOpaque(false);
        generateDoublesButton.setContentAreaFilled(false);
        generateDoublesButton.setBorderPainted(false);
        //generateDoublesButton.setFont(new Font("Century Gothic", Font.BOLD, 14));
        generateDoublesButton.setFont(getFont("assets/Comfortaa-Light.ttf", 14));

        generateDoublesButton.setForeground(Color.WHITE);
        generateDoublesButton.setVerticalTextPosition(SwingConstants.CENTER);
        generateDoublesButton.setHorizontalTextPosition(SwingConstants.CENTER);
        l.gridx = 2;
        l.gridy = 4;
        l.anchor = GridBagConstraints.LINE_END;
        l.ipadx = 55;
        leftMainPanel.add(generateDoublesButton, l);
        l.ipadx = 0;

        generateDoublesButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                errorMessage.setText(null);
                teams = null;
                teamList.clear();
                teams = mainField.getText().split("\n");

                if (teams.length >= 3) {
                    if (!hasDuplicates(teams)) {
                        for (int i = 0; i < teams.length; i++) {
                            Team newTeam = new Team(teams[i]);
                            teamList.add(newTeam);
                        }

                        DoubleGenerator doubleGen = new DoubleGenerator(teamList, DOUBLE_SEED);
                        bracket = doubleGen.getBracket();
                        bracketCreated=true;
                        bracketDisplay = new Display(bracket);

                    } else {
                        errorMessage.setText("Make sure there are no duplicate team names.");
                    }
                } else {
                    errorMessage.setText("Make sure there are at least 3 teams.");
                }
            }
        });


        //RIGHT MAIN PANEL
        //Labels
        nameLabel = new JLabel("<html><b>" + "Bracket Updater" + "</b><br>" +
                "<br>" + " Enter Winning Team Name:" + "</html>");
        nameLabel.setOpaque(false);
        //nameLabel.setFont(new Font("Century Gothic", Font.BOLD, 16));
        nameLabel.setFont(getFont("assets/Comfortaa-Light.ttf", 16));

        nameLabel.setForeground(Color.WHITE);
        r.anchor = GridBagConstraints.LAST_LINE_START;
        r.gridx = 0;
        r.gridy = 0;
        rightMainPanel.add(nameLabel, r);

        roundLabel = new JLabel("Enter Team Round Number:");
        roundLabel.setOpaque(false);
        //roundLabel.setFont(new Font("Century Gothic", Font.BOLD, 16));
        roundLabel.setFont(getFont("assets/Comfortaa-Light.ttf", 16));

        roundLabel.setForeground(Color.WHITE);
        r.anchor = GridBagConstraints.LAST_LINE_START;
        r.gridx = 0;
        r.gridy = 3;
        rightMainPanel.add(roundLabel, r);

        matchLabel = new JLabel("Enter Team Match Number:");
        matchLabel.setOpaque(false);
        //matchLabel.setFont(new Font("Century Gothic", Font.BOLD, 16));
        matchLabel.setFont(getFont("assets/Comfortaa-Light.ttf", 16));

        matchLabel.setForeground(Color.WHITE);
        r.anchor = GridBagConstraints.LAST_LINE_START;
        r.gridx = 0;
        r.gridy = 6;
        rightMainPanel.add(matchLabel, r);

        //Fields
        nameField = new JTextField(22);
        nameField.setBorder(javax.swing.BorderFactory.createEmptyBorder());
        nameField.setOpaque(false);
        nameField.setCaretColor(Color.WHITE);
        nameField.setForeground(Color.WHITE);
        r.gridx = 0;
        r.gridy = 1;
        rightMainPanel.add(nameField, r);

        roundField = new JTextField(20);
        roundField.setCaretColor(Color.WHITE);
        roundField.setOpaque(false);
        roundField.setBorder(javax.swing.BorderFactory.createEmptyBorder());
        roundField.setForeground(Color.WHITE);
        roundField.setHorizontalAlignment(JTextField.CENTER);
        roundField.setColumns(8);
        r.gridx = 0;
        r.gridy = 4;
        r.anchor = GridBagConstraints.CENTER;
        rightMainPanel.add(roundField, r);

        matchField = new JTextField(20);
        matchField.setCaretColor(Color.WHITE);
        matchField.setOpaque(false);
        matchField.setBorder(javax.swing.BorderFactory.createEmptyBorder());
        matchField.setForeground(Color.WHITE);
        matchField.setHorizontalAlignment(JTextField.CENTER);
        matchField.setColumns(8);
        r.gridx = 0;
        r.gridy = 7;
        rightMainPanel.add(matchField, r);

        //Blank Lines
        rightBlank1 = new JLabel("¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯");
        rightBlank1.setForeground(Color.WHITE);
        rightBlank1.setOpaque(false);
        r.gridx = 0;
        r.gridy = 2;
        rightMainPanel.add(rightBlank1, r);

        rightBlank2 = new JLabel("¯¯¯¯¯¯¯¯¯¯¯¯");
        rightBlank2.setForeground(Color.WHITE);
        rightBlank2.setOpaque(false);
        r.gridx = 0;
        r.gridy = 5;
        r.anchor = GridBagConstraints.CENTER;
        rightMainPanel.add(rightBlank2, r);

        rightBlank3 = new JLabel("¯¯¯¯¯¯¯¯¯¯¯¯");
        rightBlank3.setForeground(Color.WHITE);
        rightBlank3.setOpaque(false);
        r.gridx = 0;
        r.gridy = 8;
        rightMainPanel.add(rightBlank3, r);

        //Update Button
        updateButton = new JButton("<html><center>" + "Update Bracket" + "</center></html>");
        updateButton.setOpaque(false);
        updateButton.setContentAreaFilled(false);
        updateButton.setBorderPainted(false);
        //updateButton.setFont(new Font("Century Gothic", Font.BOLD, 14));
        updateButton.setFont(getFont("assets/Comfortaa-Light.ttf", 14));

        updateButton.setForeground(Color.WHITE);
        updateButton.setVerticalTextPosition(SwingConstants.CENTER);
        updateButton.setHorizontalTextPosition(SwingConstants.CENTER);
        r.gridx = 0;
        r.gridy = 9;
        rightMainPanel.add(updateButton, r);

        updateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                errorMessage.setText(null);

                if (bracketCreated) {
                    if ((!nameField.getText().equals(null)) || (!matchField.getText().equals(null)) || (!roundField.getText().equals(null))) {
                        if ((canConvertInt(matchField.getText())) && (canConvertInt(roundField.getText()))) {
                            teamsInMatch = bracket.getTeamsInMatch(Integer.parseInt(roundField.getText()), Integer.parseInt(matchField.getText()));

                            if (verifyTeamUpdate(teamsInMatch, nameField.getText(), Integer.parseInt(roundField.getText()), Integer.parseInt(matchField.getText()))) {
                                bracket.setMatchWinner(nameField.getText(), Integer.parseInt(roundField.getText()), Integer.parseInt(matchField.getText()));
                                bracketDisplay.update(bracket);

                                nameField.setText(null);
                                matchField.setText(null);
                                roundField.setText(null);
                            } else {
                                errorMessage.setText("Bracket Updater: Make sure all fields are correct.");
                            }
                        } else {
                            errorMessage.setText("Bracket Updater: Make sure the round and match fields are filled with numbers.");
                        }
                    } else {
                        errorMessage.setText("Bracket Updater: Make sure all fields are filled out.");
                    }
                }else {
                    errorMessage.setText("Bracket Updater: Make sure you generate a bracket first.");
                }
            }
        });

        mainWindow.add(canvas);
        mainWindow.setVisible(true);
    }

    /**
     * hasDuplicates
     * Accepts an array and determines whether the same name occurs more than once in the array
     *
     * @param an array representing the list of teams
     * @return boolean, true if the array has duplicate names and false otherwise
     */
    private boolean hasDuplicates(String[] list) {
        for (int i = 0; i < list.length; i++) {
            for (int j = 1; j < (list.length - i); j++) {
                if (list[i].equals(list[i + j])) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean canConvertInt(String input) {
        try {
            Integer.parseInt(input);
            return true;
        } catch (Exception NumberFormatException) {
            return false;
        }
    }

    private boolean verifyTeamUpdate(String[][] list, String name, int round, int match) {
        if (round<=bracket.getNumberOfRounds()) {
            if (match<=bracket.getNumberOfMatchesInRound(round)) {
                for (int i = 0; i < list.length; i++) {
                    for (int j = 0; j < list[0].length; j++) {
                        if (list[i][j].equals(name)) {
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }

    /**
     * GraphicsPanel
     * Inner class that inherits from JPanel and draws the background image
     *
     * @param nothing
     * @return nothing
     */
    class GraphicsPanel extends JPanel {
        /**
         * GraphicsPanel
         * Constructor for the graphics panel
         *
         * @param nothing
         * @return nothing
         */
        public GraphicsPanel() {
            super();
            setFocusable(true);
            requestFocusInWindow();
        }

        /**
         * paintComponent
         * Method that draws the background image
         *
         * @param Graphics g
         * @return void
         */
        public void paintComponent(Graphics g) {
            super.paintComponent(g);
            try {
                background = ImageIO.read(new File("assets/background.png"));
            } catch (IOException ex) {
            }
            g.drawImage(background, 0, 0, this);
            setDoubleBuffered(true);
        }
    }
    
    
    /**
     * getFont
     * Method that returns custom fonts
     *
     * @param String fileName
     * @param float size
     * @return font
     */
    private static Font getFont(String fileName, float size){
        Font font;
        try {
            font = Font.createFont(Font.TRUETYPE_FONT, new File(fileName)).deriveFont(size);
            GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
            ge.registerFont(Font.createFont(Font.PLAIN,new File(fileName)));
        } catch (IOException | FontFormatException e){
            font = new Font(Font.SANS_SERIF, Font.PLAIN, 15);
        }
        return font;
    }
}

//End of Program