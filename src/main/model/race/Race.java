package model.race;

// The groundwork for all implemented Races and their unique information
public abstract class Race {
    private String raceName;
    private String ageBlurb;
    private String namesBlurb;
    private String heightBlurb;
    private String size;
    private int raceSpeed;

    public Race(String raceName, String namesBlurb, String ageBlurb, String heightBlurb, String size, int raceSpeed) {
        this.raceName = raceName;
        this.namesBlurb = namesBlurb; // a description of how the race's naming convention works
        this.ageBlurb = ageBlurb; // a description of the race's life expectancy
        this.heightBlurb = heightBlurb; // a description of the race's typical height range
        this.size = size; // a game mechanic
        this.raceSpeed = raceSpeed; // a game mechanic
    }

    // EFFECTS: returns a battle cry specific to the race
    public String battleCry() {
        return "You're dead meat!";
    }

    public int getSpeed() {
        return raceSpeed;
    }

    public String getSize() {
        return size;
    }

    public String getAgeBlurb() {
        return ageBlurb;
    }

    public String getNameBlurb() {
        return namesBlurb;
    }

    public String getHeightBlurb() {
        return heightBlurb;
    }

    public String toString() {
        return raceName;
    }

}