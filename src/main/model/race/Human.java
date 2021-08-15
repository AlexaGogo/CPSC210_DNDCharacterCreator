package model.race;

import model.Character;

// All necessary Human race information and relevant functions (currently just getters)
public class Human extends Race {
    private static final String NAMES_BLURB = "Having so much more variety than other cultures, humans as a whole have"
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
    private static final String AGE_BLURB = "Humans reach adulthood in their late teens and live less than a century.";
    private static final String HEIGHT_BLURB = "Humans vary widely in height and build, from barely 5 feet to well over"
            + "\n6 feet tall. Regardless of your position in that range, your size is Medium.";

    private static final String SIZE = "Medium";
    private static final int SPEED = 30;

    public Human() {
        super("Human", NAMES_BLURB, AGE_BLURB, HEIGHT_BLURB, SIZE, SPEED);
    }
}
