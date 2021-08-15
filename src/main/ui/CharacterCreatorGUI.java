package ui;

import model.Character;
import model.CharacterList;
import model.persistence.Reader;
import model.persistence.Writer;
import ui.handlers.*;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

public class CharacterCreatorGUI extends JFrame {
    public static final int WIDTH = 1500;
    public static final int HEIGHT = 1000;

    public static Character character;
    public static boolean madeCharacter;
    private static CharacterList characters = new CharacterList();

    String useranswer = "";

    JFrame window;
    static Container con;
    static JPanel titlePanel = new JPanel();
    static JPanel startButtonPanel = new JPanel();
    static JPanel viewButtonPanel = new JPanel();
    static JPanel mainTextPanel = new JPanel();
    static JPanel userInputPanel = new JPanel();
    static JPanel viewSheetsTitlePanel = new JPanel();
    static JPanel viewSheetsTextPanel = new JPanel();
    static JPanel viewSheetsDropDownPanel = new JPanel();
    static JPanel viewSheetsBackButtonPanel = new JPanel();
    public static JTextField userInput = new JTextField(18);
    static JButton help = new JButton("Help");
    static JButton startButton;
    static JButton viewButton;
    static JButton backButton = new JButton("Back");
    static JButton deleteButton = new JButton("Delete");
    static JComboBox<String> characterSelect;
    static JLabel title;
    static JLabel viewSheetsTitle;
    static JTextArea mainTextArea;
    static JTextArea viewSheetsTextArea;
    static Font titleFont = new Font("Times New Roman", Font.PLAIN, 65);
    static Font buttonFont = new Font("Times New Roman", Font.PLAIN, 30);
    static Font textFont = new Font("Times New Roman", Font.PLAIN, 35);

    static NavigationButtonHandler navHandler = new NavigationButtonHandler();
    static UserInputHandler inputHandler = new UserInputHandler();
    static HelpPopUpHandler popUpHandler = new HelpPopUpHandler();

    public CharacterCreatorGUI() {
        super("DND 5E CHARACTER CREATOR");
        runGUI();
    }

    // EFFECTS: Sets up window for GUI
    private void runGUI() {
        window = new JFrame();
        window.setSize(WIDTH, HEIGHT);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.getContentPane().setBackground(Color.DARK_GRAY);
        window.setLayout(null);
        con = window.getContentPane();

        createMenuScreen();
        createViewSheetsScreen();
        createCharacterCreatorScreen();
        toggleViewSheetsSceen(false);
        toggleCharacterCreatorScreen(false);
        toggleMenuScreen(true);
        window.setVisible(true);

        loadCharacters();
    }

    // EFFECTS: sets menu screen visibility to visibility
    public static void toggleMenuScreen(boolean visibility) {
        titlePanel.setVisible(visibility);
        startButtonPanel.setVisible(visibility);
        viewButtonPanel.setVisible(visibility);
    }

    // EFFECTS: Generates menu screen
    public static void createMenuScreen() {
        createTitle();
        createButton(startButtonPanel, startButton, 500, "New Character", "start");
        createButton(viewButtonPanel, viewButton, 570, "View Sheets", "view");
    }

    // EFFECTS: Generates menu button with input JPanel, JButton, y-position, and name
    private static void createButton(JPanel panel, JButton button, int ypos, String name, String command) {
        panel.setBounds(650, ypos, 200, 50);
        panel.setBackground(Color.white);

        button = new JButton(name);
        button.setBounds(650, ypos, 200, 50);
        button.setBackground(Color.white);
        button.setForeground(Color.BLACK);
        button.setFont(buttonFont);
        button.addActionListener(navHandler);
        button.setActionCommand(command);

        panel.add(button);
        con.add(panel);
    }

    // EFFECTS: Generates title on menu screen
    private static void createTitle() {
        titlePanel.setBounds(250, 250, 1000, 100);
        titlePanel.setBackground(Color.DARK_GRAY);
        title = new JLabel("DND 5E CHARACTER CREATOR");
        title.setForeground(Color.white);
        title.setFont(titleFont);
        titlePanel.add(title);
        con.add(titlePanel);
    }

    // EFFECTS: Generates screen for character creation and sets up first question
    public static void createCharacterCreatorScreen() {
        mainTextPanel.setBounds(200, 100, 1100, 500);
        mainTextPanel.setBackground(Color.darkGray);

        mainTextArea = new JTextArea();
        mainTextArea.setBounds(200, 100, 1100, 500);
        mainTextArea.setBackground(Color.darkGray);
        mainTextArea.setForeground(Color.white);
        mainTextArea.setFont(textFont);
        mainTextArea.setLineWrap(true);
        mainTextArea.setText("Hey there! \n\nWelcome to the Character Creator! What's your name?");
        mainTextPanel.add(mainTextArea);

        userInputPanel.setBounds(500, 650, 500, 150);
        userInputPanel.setBackground(Color.darkGray);

        help.setBackground(Color.white);
        help.setForeground(Color.black);
        help.setFont(buttonFont);
        help.addActionListener(popUpHandler);

        userInput.setFont(textFont);
        userInput.addActionListener(inputHandler);
        userInput.setActionCommand("username");

        userInputPanel.add(userInput);
        userInputPanel.add(help);
        con.add(mainTextPanel);
        con.add(userInputPanel);
    }

    // EFFECTS: Sets character creation screen visibility to visibility
    public static void toggleCharacterCreatorScreen(boolean visibility) {
        mainTextPanel.setVisible(visibility);
        userInputPanel.setVisible(visibility);
    }

    // EFFECTS: Generates screen for viewing character sheets
    public static void createViewSheetsScreen() {
        titlePanel.setVisible(false);
        startButtonPanel.setVisible(false);
        viewButtonPanel.setVisible(false);

        createViewSheetsTitle();
        createViewSheetsTextPanel();
        createViewSheetsDropDownPanel();
        createViewSheetsBackButton();
    }

    // EFFECTS: Creates back button on "View Sheets" page
    private static void createViewSheetsBackButton() {
        viewSheetsBackButtonPanel.setBounds(650, 750, 200, 50);
        viewSheetsBackButtonPanel.setBackground(Color.darkGray);
        backButton.setBackground(Color.white);
        backButton.setForeground(Color.black);
        backButton.setFont(buttonFont);
        viewSheetsBackButtonPanel.add(backButton);
        backButton.addActionListener(navHandler);
        backButton.setActionCommand("back");
        con.add(viewSheetsBackButtonPanel);
    }

    // EFFECTS: Creates drop down panel and delete button on "View Sheets" Page
    private static void createViewSheetsDropDownPanel() {
        viewSheetsDropDownPanel.setBounds(500, 650, 500, 50);
        viewSheetsDropDownPanel.setBackground(Color.white);

        characterSelect = new JComboBox<>();
        characterSelect.setFont(textFont);
        characterSelect.setBackground(Color.white);
        characterSelect.setForeground(Color.black);

        deleteButton.setBackground(Color.white);
        deleteButton.setForeground(Color.black);
        deleteButton.setFont(buttonFont);

        viewSheetsDropDownPanel.add(characterSelect);
        viewSheetsDropDownPanel.add(deleteButton);
        con.add(viewSheetsDropDownPanel);
    }

    // EFFECTS: Creates text panel on "View Sheets" page
    private static void createViewSheetsTextPanel() {
        viewSheetsTextPanel.setBounds(200, 250, 1100, 300);
        viewSheetsTextPanel.setBackground(Color.darkGray);

        viewSheetsTextArea = new JTextArea();
        viewSheetsTextArea.setBackground(Color.DARK_GRAY);
        viewSheetsTextArea.setForeground(Color.white);
        viewSheetsTextArea.setFont(textFont);

        if (madeCharacter) {
            viewSheetsTextArea.setText("Select a character to view from the dropdown below.");
        } else {
            viewSheetsTextArea.setText("You haven't made a character yet!");
        }

        viewSheetsTextPanel.add(viewSheetsTextArea);
        con.add(viewSheetsTextPanel);
    }

    // EFFECTS: creates title on "View Sheets" page
    public static void createViewSheetsTitle() {
        viewSheetsTitlePanel.setBounds(250, 100, 1000, 100);
        viewSheetsTitlePanel.setBackground(Color.DARK_GRAY);
        viewSheetsTitle = new JLabel("View Your Character Sheets");
        viewSheetsTitle.setForeground(Color.white);
        viewSheetsTitle.setFont(titleFont);
        viewSheetsTitlePanel.add(viewSheetsTitle);
        con.add(viewSheetsTitlePanel);
    }

    // EFFECTS: Sets view sheets screen visibility to visibility
    public static void toggleViewSheetsSceen(boolean visibility) {
        viewSheetsTitlePanel.setVisible(visibility);
        viewSheetsTextPanel.setVisible(visibility);
        viewSheetsDropDownPanel.setVisible(visibility);
        viewSheetsBackButtonPanel.setVisible(visibility);
    }

    // EFFECTS: sets up character creation screen and asks user for selected race
    // TODO !!!!
    public static void chooseRace() {

    }

    // MODIFIES: this
    // EFFECTS: loads characters from CHARACTERS_FILE, if that file exists;
    // otherwise initializes accounts with default values
    // Initial code taken from:
    // https://github.students.cs.ubc.ca/CPSC210/TellerApp/commit/97bd57fe32445679030c388e6b68af70f92aaede
    private void loadCharacters() {
        madeCharacter = characters.loadCharacters();
    }

    // EFFECTS: saves state of characters created to CHARACTERS_FILE
    // Initial code taken from:
    // https://github.students.cs.ubc.ca/CPSC210/TellerApp/commit/97bd57fe32445679030c388e6b68af70f92aaede
    private void saveCharacters() {
        characters.saveCharacters();
    }

    // EFFECTS: removes character from save file
    private void removeCharacter(int index) {
        characters.removeCharacter(index);
    }

}
