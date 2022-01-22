package input;

import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.SortedMap;

import data.InitialData;
import data.AnnualChanges;
import data.ChildInputData;

public class Input {
    private final Integer numberOfYears;

    private double santaBudget;

    private final InitialData initialData;

    private final List<AnnualChanges> annualChanges;

    private final List<ChildInputData> children;

    private LinkedHashMap<String, Double> niceScoreCity;

    public Input() {
        this.numberOfYears = null;
        this.santaBudget = 0;
        this.initialData = null;
        this.annualChanges = null;
        this.children = new ArrayList<>();
        this.niceScoreCity = new LinkedHashMap<>();
    }

    public Input(final Integer numberOfYears, final double santaBudget,
                 final InitialData initialData,
                 final List<AnnualChanges> annualChanges, final List<ChildInputData> children) {
        this.numberOfYears = numberOfYears;
        this.santaBudget = santaBudget;
        this.initialData = initialData;
        this.annualChanges = annualChanges;
        this.children = children;
        //this.niceScoreCity = null;
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
    public InitialData getInitialData() {
        return initialData;
    }

    /**
     *
     * @return returneaza @annualChanges
     */
    public List<AnnualChanges> getAnnualChanges() {
        return annualChanges;
    }

    /**
     *
     * @return returneaza @children
     */
    public List<data.ChildInputData> getChildren() {
        return children;
    }

    /**
     *
     * @return ...
     */
    public LinkedHashMap<String, Double> getNiceScoreCity() {
        return niceScoreCity;
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
