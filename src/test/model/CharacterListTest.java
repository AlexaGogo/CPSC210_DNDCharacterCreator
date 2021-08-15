package model;

import model.race.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CharacterListTest {
    CharacterList testList;
    Character char1;
    Character char2;
    Character char3;
    Race dwarf;

    @BeforeEach
    void runBefore() {
        testList = new CharacterList();
        dwarf = new Dwarf();
        char1 = new Character("Alexa", 2, dwarf, 27, 52, "Rogni");
        char2 = new Character("Bob", 3, dwarf, 72, 31, "Holga");
        char3 = new Character("Timmy", 1, dwarf, 102, 47, "Jeff");
    }

    @Test
    void testAddCharacters() {
        assertEquals(testList.length(), 0);
        assertTrue(testList.isEmpty());

        testList.addCharacter(char1);
        testList.addCharacter(char2);
        testList.addCharacter(char3);

        assertEquals(testList.length(), 3);
        assertFalse(testList.isEmpty());
        assertTrue(testList.contains(char1));
        assertTrue(testList.contains(char2));
        assertTrue(testList.contains(char3));
    }

    @Test
    void testGetCharacter() {
        testList.addCharacter(char1);
        testList.addCharacter(char2);
        testList.addCharacter(char3);

        assertEquals(testList.getCharacter(0), char1);
        assertEquals(testList.getCharacter(1), char2);
        assertEquals(testList.getCharacter(2), char3);
    }

    @Test
    void testRemoveCharacter() {
        testList.addCharacter(char1);
        testList.addCharacter(char2);
        testList.addCharacter(char3);

        int index = testList.getCharacterIndex(char2);

        testList.removeCharacter(index);

        assertFalse(testList.contains(char2));
        assertEquals(testList.length(), 2);

        index = testList.getCharacterIndex(char1);

        testList.removeCharacter(index);

        assertFalse(testList.contains(char1));
        assertEquals(testList.length(), 1);
    }

}
