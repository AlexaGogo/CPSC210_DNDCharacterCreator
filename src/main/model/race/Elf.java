package model.race;

import model.Character;

// All necessary Elf race information and relevant functions (currently just getters)
public class Elf extends Race {
    private static final String NAMES_BLURB = "Elves are considered children until they declare themselves adults, some"
            + "\ntime after the hundredth birthday, and before this period they are called by child names. On declaring"
            + "\nadulthood, an elf selects an adult name, although those w o knew him or her as a youngster might"
            + "\ncontinue to use the child name. Each elf’s adult name is a unique creation, though it might reflect"
            + "\nthe names of respected individuals or other family members. Little distinction exists between male"
            + "\nnames and female names; the groupings here reflect only general tendencies. In addition, every elf"
            + "\nbears a family name, typically a combination of other Elvish words. Some elves traveling among humans"
            + "\ntranslate their family names into Common, but others retain the Elvish version.";
    private static final String AGE_BLURB = "Although elves reach physical maturity at about the same age as humans,"
            + "\nthe elven understanding of adulthood goes beyond physical growth to encom pass worldly experience. An"
            + "\nelf typically claim s adulthood and an adult name around the age of 100 and can live to be 750 years"
            + "\nold.";
    private static final String HEIGHT_BLURB = "Elves range from under 5 to over 6 feet tall and have slender builds."
            + "\nYour size is Medium.";

    private static final String SIZE = "Medium";
    private static final int SPEED = 30;

    public Elf() {
        super("Elf", NAMES_BLURB, AGE_BLURB, HEIGHT_BLURB, SIZE, SPEED);
    }

    @Override
    public String battleCry() {
        return "Cin're firn aes!";
    }
}
