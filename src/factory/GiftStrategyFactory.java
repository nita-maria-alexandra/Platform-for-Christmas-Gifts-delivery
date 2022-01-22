package factory;

import strategy.GiftStrategy;
import strategy.niceScoreCityGifts;
import strategy.niceScoreGifts;
import strategy.idGift;
import input.Input;

public class GiftStrategyFactory {
    public GiftStrategy createStrategy(final String strategyType, final Input input) {
        if (strategyType.equals("id")) {
            return new idGift(input);
        }

        if (strategyType.equals("niceScore")) {
            return new niceScoreGifts(input);
        }

        return new niceScoreCityGifts(input);
    }
}
