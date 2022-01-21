package input;

import java.util.List;

import data.InitialData;
import data.AnnualChanges;
import data.ChildInputData;

public class Input {
    private final Integer numberOfYears;

    private double santaBudget;

    private final data.InitialData initialData;

    private final java.util.List<data.AnnualChanges> annualChanges;

    private final java.util.List<data.ChildInputData> children;

    public Input() {
        this.numberOfYears = null;
        this.santaBudget = 0;
        this.initialData = null;
        this.annualChanges = null;
        this.children = new java.util.ArrayList<>();
    }

    public Input(final Integer numberOfYears, final double santaBudget,
                 final data.InitialData initialData,
                 final java.util.List<data.AnnualChanges> annualChanges, final java.util.List<data.ChildInputData> children) {
        this.numberOfYears = numberOfYears;
        this.santaBudget = santaBudget;
        this.initialData = initialData;
        this.annualChanges = annualChanges;
        this.children = children;
    }

    /**
     *
     * @return returneaza @numberOfYears
     */
    public Integer getNumberOfYears() {
        return numberOfYears;
    }

    /**
     *
     * @return returneaza @santaBudget
     */
    public double getSantaBudget() {
        return santaBudget;
    }

    /**
     *
     * setter
     */
    public void setSantaBudget(final double santaBudget) {
        this.santaBudget = santaBudget;
    }

    /**
     *
     * @return returneaza @initialData
     */
    public data.InitialData getInitialData() {
        return initialData;
    }

    /**
     *
     * @return returneaza @annualChanges
     */
    public java.util.List<data.AnnualChanges> getAnnualChanges() {
        return annualChanges;
    }

    /**
     *
     * @return returneaza @children
     */
    public java.util.List<data.ChildInputData> getChildren() {
        return children;
    }


    /**
     *
     * Suprascrie metoda toString()
     */
    @Override
    public String toString() {
        return "Input{"
                + "numberOfYears=" + numberOfYears
                + ", santaBudget=" + santaBudget
                + ", initialData=" + initialData
                + ", annualChanges=" + annualChanges
                + ", children=" + children
                + '}';
    }
}
