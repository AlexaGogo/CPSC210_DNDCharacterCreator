package model;

import model.persistence.Reader;
import model.persistence.Saveable;
import model.race.*;

import java.io.PrintWriter;

// The user's specific character they are building
public class Character implements Saveable {
    private String playerName;
    private int level;

    private Race race;
    private int speed; // a game mechanic - determines how far your character can move in a turn
    private int age;
    private int height;
    private String size; // a game mechanic - used to determine what equipment your character can use
    private String characterName;

    // REQUIRES: playerName has a non-zero length
    // EFFECTS: creates a new level 1 character with player name playerName and null variables
    public Character(String playerName) {
        this.playerName = playerName;
        level = 1;
    }

    // REQUIRES: playername has a non-zero length
    // EFFECTS: creates a new character with inputted playerName, level, race features, age, height, and characterName
    public Character(String playerName, int level, Race race, int age, int height, String characterName) {
        this.playerName = playerName;
        this.level = level;
        this.race = race;
        this.age = age;
        this.height = height;
        this.characterName = characterName;
        this.setSpeed(race);
        this.setSize(race);
    }

    // MODIFIES: this
    // EFFECTS: sets character's name to name
    public void setCharacterName(String name) {
        characterName = name;
    }

    // MODIFIES: this
    // EFFECTS: sets character's age to age
    public void setAge(int age) {
        this.age = age;
    }

    // MODIFIES: this
    // EFFECTS: sets character's height to height (inches)
    public void setHeight(int height) {
        this.height = height;
    }

    // REQUIRES: 1 <= level <= 20
    // MODIFIES: this
    // EFFECTS: sets character's level to level
    public void setLevel(int level) {
        this.level = level;
    }

    // MODIFIES: this
    // EFFECTS: sets character's race to race and modifies all race dependent variables
    public void setRace(Race race) {
        this.race = race;
        this.setSpeed(race);
        this.setSize(race);
    }

    // MODIFIES: this
    // EFFECTS: sets character's speed to race speed (in feet)
    public void setSpeed(Race race) {
        this.speed = race.getSpeed();
    }

    // MODIFIES: this
    // EFFECTS: sets character's size to race size
    public void setSize(Race race) {
        this.size = race.getSize();
    }

    public int getLevel() {
        return level;
    }

    public String getPlayerName() {
        return playerName;
    }

    public Race getRace() {
        return race;
    }

    public int getSpeed() {
        return speed;
    }

    public int getAge() {
        return age;
    }

    public int getHeight() {
        return height;
    }

    public String getCharacterName() {
        return characterName;
    }

    public String getSize() {
        return size;
    }

    // REQUIRES: all variables initiated
    // EFFECTS: prints out simple character sheet
    public String printSheet() {
        Race race = this.getRace();

        return "Player: " + this.getPlayerName() + "\nCharacter: " + this.getCharacterName()
                + "\nRace: " + race.toString() + "\nLevel: " + this.getLevel() + "\nAge: " + this.getAge()
                + "\nHeight: " + this.getHeight() + "\nSpeed: " + this.getSpeed();
    }

    @Override
    public void save(PrintWriter printWriter) {
        printWriter.print(level);
        printWriter.print(Reader.DELIMITER);
        printWriter.print(playerName);
        printWriter.print(Reader.DELIMITER);
        printWriter.print(race.toString());
        printWriter.print(Reader.DELIMITER);
        printWriter.print(age);
        printWriter.print(Reader.DELIMITER);
        printWriter.print(height);
        printWriter.print(Reader.DELIMITER);
        printWriter.println(characterName);
    }

}
