package data;

import java.util.List;

public class InitialData {
    private java.util.List<ChildInputData> children;

    private java.util.List<GiftInputData> santaGiftsList;

    public InitialData() {

    }

    /**
     *
     * @return returneaza @children
     */
    public java.util.List<ChildInputData> getChildren() {
        return children;
    }

    /**
     *
     * @return returneaza @santaGiftsList
     */
    public java.util.List<GiftInputData> getSantaGiftsList() {
        return santaGiftsList;
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
