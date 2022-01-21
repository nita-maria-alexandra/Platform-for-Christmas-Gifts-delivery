package data;

import java.util.List;

public class ChildUpdate {
    private final Integer id;

    private final Double niceScore;

    private final java.util.List<String> giftsPreferences;

    private final String elf;

    public ChildUpdate() {
        this.id = 0;
        this.niceScore = 0.0;
        this.giftsPreferences = null;
        this.elf = null;
    }

    /**
     *
     * @return returneaza @id
     */
    public Integer getId() {
        return id;
    }

    /**
     *
     * @return returneaza @niceScore
     */
    public Double getNiceScore() {
        return niceScore;
    }

    /**
     *
     * @return returneaza @giftsPreferences
     */
    public java.util.List<String> getGiftsPreferences() {
        return giftsPreferences;
    }

    /**
     *
     * @return ...
     */
    public String getElf() {
        return elf;
    }

    /**
     *
     * Suprascrie metoda toString()
     */
    @Override
    public String toString() {
        return "ChildUpdate{"
                + "id=" + id
                + ", niceScore=" + niceScore
                + ", giftsPreferences=" + giftsPreferences
                + '}';
    }
}
