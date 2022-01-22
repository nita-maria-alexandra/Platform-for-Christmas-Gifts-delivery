package builder;

public class BonusBuilder {
    private final Double averageScore;

    public static class Builder {
        private Double averageScore;

        public Builder(final Double averageScore) {
            this.averageScore = averageScore;
        }

        public Builder applyBonus(final Double niceScoreBonus) {
            if (averageScore != 0) {
                averageScore += averageScore * niceScoreBonus / 100;
            }

            if (Double.compare(averageScore, 10.0) >= 0) {
                averageScore = 10.0;
            }

            return this;
        }

        public BonusBuilder build() {
            return new BonusBuilder(this);
        }
    }

    private BonusBuilder(Builder builder) {
        this.averageScore = builder.averageScore;
    }

    public Double getAverageScore() {
        return averageScore;
    }
}
