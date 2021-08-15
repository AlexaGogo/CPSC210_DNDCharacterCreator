package model;

import model.race.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CharacterTest {
    Character testchar;

    @BeforeEach
    void runBefore() {
        testchar = new Character("Trent");
        testchar.setCharacterName("Kelvin Hung");
        testchar.setAge(83);
        testchar.setHeight(72);
        testchar.setRace(new Dwarf());
        testchar.setSpeed(testchar.getRace());
        testchar.setSize(testchar.getRace());
    }

    @Test
    void testBasicConstructor() {
        assertEquals(testchar.getPlayerName(), "Trent");
        assertEquals(testchar.getLevel(), 1);
    }

    @Test
    void testFullConstructor() {
        Race dwarf = new Dwarf();
        Character char2 = new Character("Bob", 2, dwarf, 37, 56, "Signi");

        assertEquals(char2.getPlayerName(), "Bob");
        assertEquals(char2.getLevel(), 2);
        assertEquals(char2.getRace(), dwarf);
        assertEquals(char2.getAge(), 37);
        assertEquals(char2.getHeight(), 56);
        assertEquals(char2.getCharacterName(), "Signi");
        assertEquals(char2.getSpeed(), dwarf.getSpeed());
        assertEquals(char2.getSize(), dwarf.getSize());
    }

    @Test
    void testSetCharacterName() {
        testchar.setCharacterName("Alice Bob");

        assertEquals(testchar.getCharacterName(), "Alice Bob");

        testchar.setCharacterName("Stuart Hill");

        assertEquals(testchar.getCharacterName(), "Stuart Hill");
    }

    @Test
    void testSetAge() {
        testchar.setAge(27);

        assertEquals(testchar.getAge(), 27);

        testchar.setAge(302);

        assertEquals(testchar.getAge(), 302);
    }

    @Test
    void testSetHeight() {
        testchar.setHeight(57);

        assertEquals(testchar.getHeight(), 57);

        testchar.setHeight(72);

        assertEquals(testchar.getHeight(), 72);
    }

    @Test
    void testSetLevel() {
        testchar.setLevel(2);

        assertEquals(testchar.getLevel(), 2);

        testchar.setLevel(20);

        assertEquals(testchar.getLevel(), 20);
    }

    @Test
    void testSetRace() {
        Race dwarf = new Dwarf();
        Race human = new Human();
        Race elf = new Elf();

        testchar.setRace(dwarf);

        assertEquals(testchar.getRace(), dwarf);
        assertEquals(testchar.getSpeed(), dwarf.getSpeed());
        assertEquals(testchar.getSize(), dwarf.getSize());

        testchar.setRace(human);

        assertEquals(testchar.getRace(), human);
        assertEquals(testchar.getSpeed(), human.getSpeed());
        assertEquals(testchar.getSize(), human.getSize());

        testchar.setRace(elf);

        assertEquals(testchar.getRace(), elf);
        assertEquals(testchar.getSpeed(), elf.getSpeed());
        assertEquals(testchar.getSize(), elf.getSize());
    }

    @Test
    void testSetSpeed() {
        Race dwarf = new Dwarf();
        Race human = new Human();
        Race elf = new Elf();

        testchar.setSpeed(dwarf);

        assertEquals(testchar.getSpeed(), dwarf.getSpeed());

        testchar.setSpeed(human);

        assertEquals(testchar.getSpeed(), human.getSpeed());

        testchar.setSpeed(elf);

        assertEquals(testchar.getSpeed(), elf.getSpeed());
    }

    @Test
    void testSetSize() {
        Race dwarf = new Dwarf();
        Race human = new Human();
        Race elf = new Elf();

        testchar.setSize(dwarf);

        assertEquals(testchar.getSize(), dwarf.getSize());

        testchar.setSize(human);

        assertEquals(testchar.getSize(), human.getSize());

        testchar.setSize(elf);

        assertEquals(testchar.getSize(), elf.getSize());
    }

    @Test
    void testPrintSheet() {
        String testsheet = "Player: " + "Trent" + "\nCharacter: " + "Kelvin Hung"
                + "\nRace: " + "Dwarf" + "\nLevel: " + 1 + "\nAge: " + 83
                + "\nHeight: " + 72 + "\nSpeed: " + 25;

        assertEquals(testchar.printSheet(), testsheet);
    }
}