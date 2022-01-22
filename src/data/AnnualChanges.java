package data;

import java.util.List;

public class AnnualChanges {
    private final double newSantaBudget;

    private final List<GiftInputData> newGifts;

    private final List<ChildInputData> newChildren;

    private final List<ChildUpdate> childrenUpdates;

    private final String strategy;

    public AnnualChanges() {
        this.newSantaBudget = 0;
        this.newGifts = null;
        this.newChildren = null;
        this.childrenUpdates = null;
        this.strategy = null;
    }

    /**
     *
     * @return returneaza @newSantaBudget
     */
    public double getNewSantaBudget() {
        return newSantaBudget;
    }

    /**
     *
     * @return returneaza @newGifts
     */
    public java.util.List<GiftInputData> getNewGifts() {
        return newGifts;
    }

    /**
     *
     * @return returneaza @newChildren
     */
    public List<ChildInputData> getNewChildren() {
        return newChildren;
    }

    /**
     *
     * @return returneaza childrenUpdates
     */
    public List<ChildUpdate> getChildrenUpdates() {
        return childrenUpdates;
    }

    /**
     *
     * @return ...
     */
    public String getStrategy() {
        return strategy;
    }

    /**
     *
     * Suprascrie metoda toString()
     */
    @Override
    public String toString() {
        return "AnnualChanges{"
                + "newSantaBudget="
                + newSantaBudget
                + ", newGifts=" + newGifts
                + ", newChildren=" + newChildren
                + ", childrenUpdates=" + childrenUpdates
                + '}';
    }
}
