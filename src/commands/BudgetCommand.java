package commands;

import data.ChildInputData;

import java.util.List;

public class BudgetCommand implements commands.Command {
    private final java.util.List<data.ChildInputData> childInputData;
    private final double santaBudget;

    public BudgetCommand(final java.util.List<data.ChildInputData> childInputData, final double santaBudget) {
        this.childInputData = childInputData;
        this.santaBudget = santaBudget;
    }

    /**
     *
     * Calculeaza budgetUnit
     */
    public Double budgetUnit() {
        double sum = 0.0;

        for (data.ChildInputData child:childInputData) {
            if (child.getAge().compareTo(common.Constants.EIGHTEEN) <= 0) {
                sum += child.getAverageScore();
            }
        }
        sum = santaBudget / sum;

        return sum;

    }

    /**
     * Calculeaza si atribuie fiecarui copil bugetul pe care i-l aloca Mosul
     */
    @Override
    public void execute() {
        double budgetUnit = budgetUnit();

        for (data.ChildInputData child:childInputData) {
            if (child.getAge().compareTo(common.Constants.EIGHTEEN) <= 0) {
                child.setAssignedBudget(child.getAverageScore() * budgetUnit);
            }
        }

    }
}
