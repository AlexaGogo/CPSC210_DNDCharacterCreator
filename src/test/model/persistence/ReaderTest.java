package model.persistence;

import model.Character;
import model.race.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

// Initial code taken from:
// https://github.students.cs.ubc.ca/CPSC210/TellerApp/commit/97bd57fe32445679030c388e6b68af70f92aaede

public class ReaderTest {
    private Reader reader = new Reader();
    private static final String TEST_FILE = "./data/testCharacters.txt";
    private Writer testWriter;
    private Character testChar1;
    private Character testChar2;
    private Character testChar3;
    Race elf = new Elf();
    Race dwarf = new Dwarf();
    Race human = new Human();

    @BeforeEach
    void runBefore() throws FileNotFoundException, UnsupportedEncodingException {
        testWriter = new Writer(new File(TEST_FILE));
        testChar1 = new Character("Alexa", 4, elf, 52, 72, "Lucy");
        testChar2 = new Character("Kelvin", 2, dwarf, 27, 54, "Signi");
        testChar3 = new Character("Alisha", 7, human, 32, 90, "Elliot");
    }

    @Test
    void testWriteAccounts() {
        // save chequing and savings accounts to file
        testWriter.write(testChar1);
        testWriter.write(testChar2);
        testWriter.write(testChar3);
        testWriter.close();

        // now read them back in and verify that the accounts have the expected values
        try {
            List<Character> characters = Reader.readCharacters(new File(TEST_FILE));
            Character testChar1 = characters.get(0);
            assertEquals(testChar1.getPlayerName(), "Alexa");
            assertEquals(testChar1.getLevel(), 4);
            assertEquals(testChar1.getAge(), 52);
            assertEquals(testChar1.getHeight(), 72);
            assertEquals(testChar1.getCharacterName(), "Lucy");
            assertEquals(testChar1.getSpeed(), elf.getSpeed());
            assertEquals(testChar1.getSize(), elf.getSize());

            Character testChar2 = characters.get(1);
            assertEquals(testChar2.getPlayerName(), "Kelvin");
            assertEquals(testChar2.getLevel(), 2);
            assertEquals(testChar2.getAge(), 27);
            assertEquals(testChar2.getHeight(), 54);
            assertEquals(testChar2.getCharacterName(), "Signi");
            assertEquals(testChar2.getSpeed(), dwarf.getSpeed());
            assertEquals(testChar2.getSize(), dwarf.getSize());

            Character testChar3 = characters.get(2);
            assertEquals(testChar3.getPlayerName(), "Alisha");
            assertEquals(testChar3.getLevel(), 7);
            assertEquals(testChar3.getAge(), 32);
            assertEquals(testChar3.getHeight(), 90);
            assertEquals(testChar3.getCharacterName(), "Elliot");
            assertEquals(testChar3.getSpeed(), human.getSpeed());
            assertEquals(testChar3.getSize(), human.getSize());
        } catch (IOException e) {
            fail("IOException should not have been thrown");
        }
    }
}
