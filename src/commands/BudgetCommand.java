package commands;

import data.ChildInputData;

import java.util.List;

public class BudgetCommand implements commands.Command {
    private final List<data.ChildInputData> childInputData;
    private final double santaBudget;

    public BudgetCommand(final List<ChildInputData> childInputData, final double santaBudget) {
        this.childInputData = childInputData;
        this.santaBudget = santaBudget;
    }

    /**
     *
     * Calculeaza budgetUnit
     */
    public Double budgetUnit() {
        double sum = 0.0;

        for (ChildInputData child:childInputData) {
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
        double budget;

        for (ChildInputData child:childInputData) {
            if (child.getAge().compareTo(common.Constants.EIGHTEEN) <= 0) {
                budget = child.getAverageScore() * budgetUnit;

                if (child.getElf().compareTo("black") == 0) {
                    budget -= budget * 30 / 100;
                } else {
                    if (child.getElf().compareTo("pink") == 0) {
                        budget += budget * 30 / 100;
                    }
                }
                child.setAssignedBudget(budget);
            }
        }

    }
}
