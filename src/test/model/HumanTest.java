package model;

import model.race.Human;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class HumanTest {
    Human testHuman;
    String nameBlurb = "Having so much more variety than other cultures, humans as a whole have"
            + "\nno typical names. Some human parents give their children names from other languages, such as Dwarvish"
            + "\nor Elvish (pronounced more or less correctly), but most parents give names that are linked to their"
            + "\nregion’s culture or to the naming traditions of their ancestors. The material culture and physical"
            + "\ncharacteristics of humans can change wildly from region to region. In the Forgotten Realms, for"
            + "\nexample, the clothing, architecture, cuisine, music, and literature are different in the northwestern"
            + "\nlands of the Silver Marches than in distant Turmish or Impiltur to the east—and even more distinctive"
            + "\nin far-off Kara-Tur. Human physical characteristics, though, vary according to the ancient migrations"
            + "\nof the earliest humans, so that the humans of the Silver Marches have every possible variation of"
            + "\ncoloration and features. In the Forgotten Realms, nine human ethnic groups are widely recognized,"
            + "\nthough over a dozen others are found in more localized areas of Faerun. These groups, and the typical"
            + "\nnames of their members, can be used as inspiration no matter which world your human is in.";
    String ageBlurb = "Humans reach adulthood in their late teens and live less than a century.";
    String heightBlurb = "Humans vary widely in height and build, from barely 5 feet to well over"
            + "\n6 feet tall. Regardless of your position in that range, your size is Medium.";

    @BeforeEach
    void runBefore() {
        testHuman = new Human();
    }

    @Test
    void testToString() {
        assertEquals(testHuman.toString(), "Human");
    }

    @Test
    void testSpeedGet() {
        assertEquals(testHuman.getSpeed(), 30);
    }

    @Test
    void testSizeGet() {
        assertEquals(testHuman.getSize(), "Medium");
    }

    @Test
    void testGetAgeBlurb() {
        assertEquals(testHuman.getAgeBlurb(), ageBlurb);
    }

    @Test
    void testGetHeightBlurb() {
        assertEquals(testHuman.getHeightBlurb(), heightBlurb);
    }

    @Test
    void testGetNameBlurb() {
        assertEquals(testHuman.getNameBlurb(), nameBlurb);
    }

    @Test
    void testBattleCry() { assertEquals(testHuman.battleCry(), "You're dead meat!");}
}
