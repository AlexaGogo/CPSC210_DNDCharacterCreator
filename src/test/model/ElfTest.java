package model;

import model.race.Elf;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ElfTest {
    Elf testElf;
    String nameBlurb = "Elves are considered children until they declare themselves adults, some"
            + "\ntime after the hundredth birthday, and before this period they are called by child names. On declaring"
            + "\nadulthood, an elf selects an adult name, although those w o knew him or her as a youngster might"
            + "\ncontinue to use the child name. Each elf’s adult name is a unique creation, though it might reflect"
            + "\nthe names of respected individuals or other family members. Little distinction exists between male"
            + "\nnames and female names; the groupings here reflect only general tendencies. In addition, every elf"
            + "\nbears a family name, typically a combination of other Elvish words. Some elves traveling among humans"
            + "\ntranslate their family names into Common, but others retain the Elvish version.";
    String ageBlurb = "Although elves reach physical maturity at about the same age as humans,"
            + "\nthe elven understanding of adulthood goes beyond physical growth to encom pass worldly experience. An"
            + "\nelf typically claim s adulthood and an adult name around the age of 100 and can live to be 750 years"
            + "\nold.";
    String heightBlurb = "Elves range from under 5 to over 6 feet tall and have slender builds."
            + "\nYour size is Medium.";

    @BeforeEach
    void runBefore() {
        testElf = new Elf();
    }

    @Test
    void testToString() {
        assertEquals(testElf.toString(), "Elf");
    }

    @Test
    void testSpeedGet() {
        assertEquals(testElf.getSpeed(), 30);
    }

    @Test
    void testSizeGet() {
        assertEquals(testElf.getSize(), "Medium");
    }

    @Test
    void testGetAgeBlurb() {
        assertEquals(testElf.getAgeBlurb(), ageBlurb);
    }

    @Test
    void testGetHeightBlurb() {
        assertEquals(testElf.getHeightBlurb(), heightBlurb);
    }

    @Test
    void testGetNameBlurb() {
        assertEquals(testElf.getNameBlurb(), nameBlurb);
    }

    @Test
    void testBattleCry() { assertEquals(testElf.battleCry(), "Cin're firn aes!");}
}
