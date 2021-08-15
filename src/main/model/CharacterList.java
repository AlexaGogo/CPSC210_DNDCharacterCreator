package model;

import model.persistence.Reader;
import model.persistence.Writer;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

// Represents a list of characters
public class CharacterList {
    private static final String CHARACTERS_FILE = "./data/characters.txt";

    private List<Character> characters;

    // EFFECTS: constructs empty list of questions
    public CharacterList() {
        characters = new ArrayList<>();
    }

    // MODIFIES: this
    // EFFECTS: adds character to characters
    public void addCharacter(Character c) {
        characters.add(c);
    }

    public Character getCharacter(int index) {
        return characters.get(index);
    }

    // EFFECTS: returns number of characters in list
    public int length() {
        return characters.size();
    }

    // EFFECTS: returns if characters is empty
    public boolean isEmpty() {
        return characters.isEmpty();
    }

    // EFFECTS: returns if character is in list
    public boolean contains(Character c) {
        return characters.contains(c);
    }

    // EFFECTS: returns character's index number
    public int getCharacterIndex(Character c) {
        return characters.indexOf(c);
    }

    // MODIFIES: this
    // EFFECTS: loads characters from CHARACTERS_FILE, if that file exists;
    // otherwise initializes accounts with default values
    // Initial code taken from:
    // https://github.students.cs.ubc.ca/CPSC210/TellerApp/commit/97bd57fe32445679030c388e6b68af70f92aaede
    public boolean loadCharacters() {
        try {
            characters = Reader.readCharacters(new File(CHARACTERS_FILE));
        } catch (IOException e) {
            characters = new ArrayList<>();
        }

        return !characters.isEmpty();
    }

    // EFFECTS: saves state of characters created to CHARACTERS_FILE
    // Initial code taken from:
    // https://github.students.cs.ubc.ca/CPSC210/TellerApp/commit/97bd57fe32445679030c388e6b68af70f92aaede
    public void saveCharacters() {
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
    public void removeCharacter(int index) {
        characters.remove(characters.get(index));
        saveCharacters();
    }
}
