package model.race;

// All necessary Dwarf race information and relevant functions (currently just getters)
public class Dwarf extends Race {
    private static final String NAMES_BLURB = "A dwarf’s name is granted by a clan elder, in accordance with tradition."
            + "\nEvery proper dwarven name has been used and reused down through the generations. A dwarf’s name"
            + "\nbelongs to the clan, not to the individual. A dwarf who misuses or brings shame to a clan name is"
            + "\nstripped of the name and forbidden by law to use any dwarven name in its place.";
    private static final String AGE_BLURB = "Dwarves mature at the same rate as humans, but they’re considered young "
            + "\nuntil they reach the age of 50. On average, they live about 350 years.";
    private static final String HEIGHT_BLURB = "Dwarves stand between 4 and 5 feet tall and average about 150 pounds."
            + "\nYour size is Medium.";

    private static final String SIZE = "Medium";
    private static final int SPEED = 25;

    public Dwarf() {
        super("Dwarf", NAMES_BLURB, AGE_BLURB, HEIGHT_BLURB, SIZE, SPEED);
    }

    @Override
    public String battleCry() {
        return "Duag eirag Olukkod!";
    }
}
