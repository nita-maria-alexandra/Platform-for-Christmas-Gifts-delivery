package factory;

import strategy.GiftStrategy;
import input.Input;

public class GiftStrategyFactory {
    /**
     *
     * Creeaza o noua strategie, de tipul @strategyType, pe care o returneaza
     */
    public GiftStrategy createStrategy(final String strategyType, final Input input) {
        if (strategyType.equals("id")) {
            return new strategy.IdGift(input);
        }

        if (strategyType.equals("niceScore")) {
            return new strategy.NiceScoreGifts(input);
        }

        return new strategy.NiceScoreCityGifts(input);
    }
}
