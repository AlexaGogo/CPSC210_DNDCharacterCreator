package model;

import model.race.Dwarf;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class DwarfTest {
    Dwarf testDwarf;
    String nameBlurb = "A dwarf’s name is granted by a clan elder, in accordance with tradition."
            + "\nEvery proper dwarven name has been used and reused down through the generations. A dwarf’s name"
            + "\nbelongs to the clan, not to the individual. A dwarf who misuses or brings shame to a clan name is"
            + "\nstripped of the name and forbidden by law to use any dwarven name in its place.";
    String ageBlurb = "Dwarves mature at the same rate as humans, but they’re considered young "
            + "\nuntil they reach the age of 50. On average, they live about 350 years.";
    String heightBlurb = "Dwarves stand between 4 and 5 feet tall and average about 150 pounds."
            + "\nYour size is Medium.";

    @BeforeEach
    void runBefore() {
        testDwarf = new Dwarf();
    }

    @Test
    void testToString() {
        assertEquals(testDwarf.toString(), "Dwarf");
    }

    @Test
    void testSpeedGet() {
        assertEquals(testDwarf.getSpeed(), 25);
    }

    @Test
    void testSizeGet() {
        assertEquals(testDwarf.getSize(), "Medium");
    }

    @Test
    void testGetAgeBlurb() {
        assertEquals(testDwarf.getAgeBlurb(), ageBlurb);
    }

    @Test
    void testGetHeightBlurb() {
        assertEquals(testDwarf.getHeightBlurb(), heightBlurb);
    }

    @Test
    void testGetNameBlurb() {
        assertEquals(testDwarf.getNameBlurb(), nameBlurb);
    }

    @Test
    void testBattleCry() { assertEquals(testDwarf.battleCry(), "Duag eirag Olukkod!");}
}
