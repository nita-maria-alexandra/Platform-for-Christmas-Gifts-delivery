package commands;

import data.ChildInputData;

import java.util.List;

public class AverageCommand implements commands.Command {
    private final java.util.List<data.ChildInputData> childInputData;

    public AverageCommand(final java.util.List<data.ChildInputData> childInputData) {
        this.childInputData = childInputData;
    }

    /**
     *
     * Calculeaza averageScore pentru copiii din categoria "Kid"
     */
    public Double averageKid(final data.ChildInputData childInputData1) {
        Double sum = 0.0;
        java.util.List<Double> averagescore = childInputData1.getNiceScoreHistory();

        for (Double score:averagescore) {
            sum += score;
        }

        sum = sum / averagescore.size();

        return sum;
    }

    /**
     *
     * Calculeaza averageScore pentru copiii din categoria "Teen"
     */
    public Double averageTeen(final data.ChildInputData childInputData1) {
        double sum1 = 0.0;
        int sum2 = 0, nr = 0;
        java.util.List<Double> averageScore = childInputData1.getNiceScoreHistory();

        for (Double score:averageScore) {
            nr++;
            sum1 += score * nr;
            sum2 += nr;
        }

        sum1 = sum1 / sum2;

        return sum1;
    }

    /**
     * Calculeaza averageScore pentru fiecare copil cu varsta de cel mult 18 ani
     */
    @Override
    public void execute() {
        for (data.ChildInputData child:childInputData) {
            if (child.getAge() < common.Constants.FIVE) {
                child.setAverageScore(common.Constants.TEN);
            } else {
                if (child.getAge() >= common.Constants.FIVE
                        && child.getAge() < common.Constants.TWELVE) {
                    child.setAverageScore(averageKid(child));
                } else {
                    if (child.getAge() >= common.Constants.TWELVE
                            && child.getAge() <= common.Constants.EIGHTEEN) {
                        child.setAverageScore(averageTeen(child));
                    }
                }
            }
        }
    }
}
