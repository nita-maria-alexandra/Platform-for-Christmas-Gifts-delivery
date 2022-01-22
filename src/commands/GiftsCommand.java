package commands;

import input.Input;
import factory.GiftStrategyFactory;

public class GiftsCommand implements commands.Command {
    private final String strategy;
    private final Input input;

    public GiftsCommand(final Input input, final String strategy) {
        this.strategy = strategy;
        this.input = input;
    }

    /**
     *
     * Atribuie copilului cadoul din catgoria @category, care nu depaseste @budgetSum
     */


    /**
     * Atribuie fiecarui copil cadourile
     */
    @Override
    public void execute() {
        GiftStrategyFactory strategy1 = new GiftStrategyFactory();
        strategy.GiftStrategy strategy2 = strategy1.createStrategy(strategy, input);

        strategy2.giftList();
    }
}
