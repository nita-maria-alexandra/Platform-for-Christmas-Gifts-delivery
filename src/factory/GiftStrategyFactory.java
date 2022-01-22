package factory;

import strategy.GiftStrategy;
import input.Input;

public class GiftStrategyFactory {
    /**
     *
     * @param strategyType ...
     * @param input ...
     * @return ...
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
