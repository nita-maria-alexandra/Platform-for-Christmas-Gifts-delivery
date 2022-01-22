package data;

import java.util.List;
import java.util.ArrayList;

public class InitialData {
    private List<ChildInputData> children;

    private List<GiftInputData> santaGiftsList;

    private List<String> cities = new ArrayList<>();

    public InitialData() {

    }

    /**
     *
     * @return returneaza @children
     */
    public List<ChildInputData> getChildren() {
        return children;
    }

    /**
     *
     * @return returneaza @santaGiftsList
     */
    public List<GiftInputData> getSantaGiftsList() {
        return santaGiftsList;
    }

    /**
     *
     * @return ...
     */
    public List<String> getCities() {
        return cities;
    }

    /**
     *
     * Suprascrie metoda toString()
     */
    @Override
    public String toString() {
        return "InitialData{"
                + "children=" + children
                + ", santaGiftsList=" + santaGiftsList
                + '}';
    }
}
