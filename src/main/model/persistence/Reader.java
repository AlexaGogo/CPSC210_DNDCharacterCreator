package model.persistence;

import model.Character;
import model.race.*;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// A reader that can read account data from a file
// Initial code taken from:
// https://github.students.cs.ubc.ca/CPSC210/TellerApp/commit/97bd57fe32445679030c388e6b68af70f92aaede

public class Reader {
    public static final String DELIMITER = ",";

    // EFFECTS: returns a list of accounts parsed from file; throws
    // IOException if an exception is raised when opening / reading from file
    public static List<Character> readCharacters(File file) throws IOException {
        List<String> fileContent = readFile(file);
        return parseContent(fileContent);
    }

    // EFFECTS: returns content of file as a list of strings, each string
    // containing the content of one row of the file
    private static List<String> readFile(File file) throws IOException {
        return Files.readAllLines(file.toPath());
    }

    // EFFECTS: returns a list of accounts parsed from list of strings
    // where each string contains data for one account
    private static List<Character> parseContent(List<String> fileContent) {
        List<Character> characters = new ArrayList<>();

        for (String line : fileContent) {
            ArrayList<String> lineComponents = splitString(line);
            characters.add(parseAccount(lineComponents));
        }

        return characters;
    }

    // EFFECTS: returns a list of strings obtained by splitting line on DELIMITER
    private static ArrayList<String> splitString(String line) {
        String[] splits = line.split(DELIMITER);
        return new ArrayList<>(Arrays.asList(splits));
    }

    // REQUIRES: components has size 4 where element 0 represents the
    // id of the next account to be constructed, element 1 represents
    // the id, elements 2 represents the name and element 3 represents
    // the balance of the account to be constructed
    // EFFECTS: returns an account constructed from components
    private static Character parseAccount(List<String> components) {
        String playerName = components.get(1);
        Character character = new Character(playerName);
        Race race = parseRace(components.get(2));
        character.setLevel(Integer.parseInt(components.get(0)));
        character.setRace(race);
        character.setSpeed(race);
        character.setAge(Integer.parseInt(components.get(3)));
        character.setHeight(Integer.parseInt(components.get(4)));
        character.setSize(race);
        character.setCharacterName(components.get(5));
        return character;
    }

    private static Race parseRace(String s) {
        Race race;

        if (s.equals("Dwarf")) {
            race = new Dwarf();
        } else if (s.equals("Elf")) {
            race = new Elf();
        } else {
            race = new Human();
        }

        return race;
    }
}
