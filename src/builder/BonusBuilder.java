package builder;

import common.Constants;

public final class BonusBuilder {
    private final Double averageScore;

    public static class Builder {
        private Double averageScore;

        public Builder(final Double averageScore) {
            this.averageScore = averageScore;
        }

        /**
         *
         * @param niceScoreBonus ...
         * @return ...
         */
        public Builder applyBonus(final Double niceScoreBonus) {
            if (averageScore != 0) {
                averageScore += averageScore * niceScoreBonus / Constants.ONE_HUNDRED;
            }

            if (Double.compare(averageScore, Constants.TEN_DOUBLE) >= 0) {
                averageScore = Constants.TEN_DOUBLE;
            }

            return this;
        }

        /**
         *
         * @return ...
         */
        public BonusBuilder build() {
            return new BonusBuilder(this);
        }
    }

    private BonusBuilder(final Builder builder) {
        this.averageScore = builder.averageScore;
    }

    public Double getAverageScore() {
        return averageScore;
    }
}
