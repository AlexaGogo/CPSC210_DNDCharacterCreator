package ui;

import model.Character;
import model.persistence.Reader;
import model.persistence.Writer;
import model.race.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// Character Creator App
public class CharacterCreator {
    private static final String CHARACTERS_FILE = "./data/characters.txt";
    private Character character;
    private Scanner input;
    private boolean madeCharacter;
    private List<Character> characters;

    String useranswer = "";

    // EFFECTS: runs the creator
    public CharacterCreator() {
        runCreator();
    }

    // EFFECTS: processes menu selections
    private void runCreator() {
        boolean running = true;
        String selection;
        input = new Scanner(System.in);

        loadCharacters();

        while (running) {
            showMenu();
            System.out.println("\nPlease enter selection:");
            selection = input.next();

            running = processSelection(selection.toLowerCase());
        }
    }

    // EFFECTS: processes user input in the menu screen
    private boolean processSelection(String selection) {
        switch (selection) {
            case "q":
                System.out.println("\nGoodbye!");
                return false;
            case "c":
                createCharacter();
                return true;
            case "v":
                viewCharacterSheet();
                return true;
            default:
                return true;
        }
    }

    // MODIFIES: this
    // EFFECTS: loads characters from CHARACTERS_FILE, if that file exists;
    // otherwise initializes accounts with default values
    // Initial code taken from:
    // https://github.students.cs.ubc.ca/CPSC210/TellerApp/commit/97bd57fe32445679030c388e6b68af70f92aaede
    private void loadCharacters() {
        try {
            characters = Reader.readCharacters(new File(CHARACTERS_FILE));
        } catch (IOException e) {
            characters = new ArrayList<>();
        } finally {
            madeCharacter = !characters.isEmpty();
        }
    }

    // EFFECTS: saves state of characters created to CHARACTERS_FILE
    // Initial code taken from:
    // https://github.students.cs.ubc.ca/CPSC210/TellerApp/commit/97bd57fe32445679030c388e6b68af70f92aaede
    private void saveCharacters() {
        try {
            Writer writer = new Writer(new File(CHARACTERS_FILE));
            for (Character c : characters) {
                writer.write(c);
            }
            writer.close();
            System.out.println("Accounts saved to file " + CHARACTERS_FILE);
        } catch (FileNotFoundException e) {
            System.out.println("Unable to save accounts to " + CHARACTERS_FILE);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            // this is due to a programming error
        }
    }

    // EFFECTS: removes character from save file
    private void removeCharacter(int index) {
        characters.remove(characters.get(index));
        saveCharacters();
    }

    // EFFECTS: shows menu
    private void showMenu() {
        System.out.println("\nDND 5E CHARACTER CREATOR");
        System.out.println("c - Create New Character");
        System.out.println("v - View Character Sheet");
        System.out.println("q - Exit");
    }

    // MODIFIES: character
    // EFFECTS: Begins the character creation process by asking for player's name and creating new character
    private void createCharacter() {
        useranswer = "";
        boolean running = true;

        System.out.println("Hey there! Welcome to the Character Creator! What's your name?");
        useranswer = input.next();
        character = new Character(useranswer);

        System.out.println("Nice to meet you " + useranswer + "! Do you already have a character concept in mind?");

        while (running) {
            System.out.println("(please enter yes or no)");
            useranswer = input.next();
            useranswer = useranswer.toLowerCase();

            if (useranswer.equals("yes")) {
                racePicker();
                running = false;
            } else if (useranswer.equals("no")) {
                conceptHelp();
                running = false;
            }
        }
    }

    // EFFECTS: gives players advice if they don't have a character idea
    private void conceptHelp() {
        useranswer = "";

        System.out.println("No worries! I can help you out with that. Let’s try to think of an overall feel"
                + "\nyou want for your character. Are they a big tough hero that swings a huge sword? A sneaky"
                + "\nthief who only cares about themselves? A quiet, introverted hunter who prefers plants to"
                + "\npeople? Try to think up a couple of adjectives that fit the type of person you want to"
                + "\nplay - they could be as generic or weird as you want! We’ll work out the details later."
                + "\nOnce you’ve got an elevator pitch (two to three sentences that roughly describe what your"
                + "\ncharacter), type done below:\n");

        while (!useranswer.equals("done")) {
            useranswer = input.next();
            useranswer = useranswer.toLowerCase();
        }

        racePicker();
    }

    // MODIFIES: character
    // EFFECTS: allows player to pick a race for their character
    private void racePicker() {
        int useranswer = 0;

        while (!((useranswer == 1) || (useranswer == 2) || (useranswer == 3))) {
            System.out.println("Let's choose your race. Please enter the number corresponding to your choice:");
            System.out.println("1 - Dwarf");
            System.out.println("2 - Elf");
            System.out.println("3 - Human");

            useranswer = input.nextInt();
        }

        if (useranswer == 1) {
            System.out.println("You've chosen Dwarf! Let's move onto your physical traits.");
            character.setRace(new Dwarf());
            chooseAge();
        } else if (useranswer == 2) {
            System.out.println("You've chosen Elf! Let's move onto your physical traits.");
            character.setRace(new Elf());
            chooseAge();
        } else {
            System.out.println("You've chosen Human! Let's move onto your physical traits.");
            character.setRace(new Human());
            chooseAge();
        }
    }

    // MODIFIES: character
    // EFFECTS: allows player to pick an age for their character; gives race-specific age information
    private void chooseAge() {
        int usernumber;
        Race charrace = character.getRace();

        System.out.println("How old would you like your character to be? (enter 0 if you would like race information)");
        usernumber = input.nextInt();

        if (usernumber == 0) {
            System.out.println(charrace.getAgeBlurb());
            usernumber = input.nextInt();
        }

        character.setAge(usernumber);

        chooseHeight();
    }

    // MODIFIES: character
    // EFFECTS: allows player to pick a height for their character; gives race-specific height information
    private void chooseHeight() {
        int usernumber;
        Race charrace = character.getRace();

        System.out.println("How tall (in inches) would you like your character to be? (enter 0 if you would like"
                + "\nrace information)");
        usernumber = input.nextInt();

        if (usernumber == 0) {
            System.out.println(charrace.getHeightBlurb());
            usernumber = input.nextInt();
        }

        character.setHeight(usernumber);

        chooseName();
    }

    // MODIFIES: character
    // EFFECTS: allows player to pick a name for their character; gives race-specific name information
    private void chooseName() {
        useranswer = "";
        Race charrace = character.getRace();

        System.out.println("What would you like your character's first name to be? (enter help if you would like"
                + "\nrace information)");
        useranswer = input.next();

        if (useranswer.toLowerCase().equals("help")) {
            System.out.println(charrace.getNameBlurb());
            useranswer = input.next();
        }

        character.setCharacterName(useranswer);

        finishCharacter();
    }

    private void finishCharacter() {
        useranswer = "";
        System.out.println("\nYou've completed your character! Here's your sheet:\n\n" + character.printSheet());
        System.out.println("\nWould you like to save this character? (Please enter yes or no)");

        useranswer = input.next();
        useranswer = useranswer.toLowerCase();

        if (useranswer.equals("yes")) {
            characters.add(character);
            madeCharacter = true;
            saveCharacters();
            System.out.println("Successfully saved character! You can view their sheet from the menu.");
        } else {
            System.out.println("No worries, feel free to create another character!");
        }
    }

    // EFFECTS: allows player to view and edit their character sheet (if one exists)
    private void viewCharacterSheet() {
        String selection = "";

        while (!(selection.equals("b"))) {
            System.out.println("\nYOUR CHARACTER SHEET:\n");

            if (!madeCharacter) {
                System.out.println("You haven't created a character yet!\n\n");
            } else {
                characterViewer();
                break;
            }
            System.out.println("\nb - Back");
            selection = input.next();
            selection = selection.toLowerCase();
        }
    }

    private void characterViewer() {
        int selection;
        int counter = 1;

        while (true) {
            System.out.println("Please enter the number of the character you would like to view:");

            for (Character c : characters) {
                System.out.println(counter + " - " + c.getCharacterName());
                counter++;
            }
            System.out.println("\n0 - Back");

            selection = input.nextInt();

            if (selection == 0) {
                break;
            }

            Character character = characters.get(selection - 1);
            System.out.println("\n" + character.printSheet() + "\n");
            counter = 1;
        }
    }

}