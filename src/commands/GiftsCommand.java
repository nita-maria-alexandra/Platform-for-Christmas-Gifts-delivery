package commands;

import data.ChildInputData;
import data.GiftInputData;
import input.Input;

import java.util.List;

public class GiftsCommand implements commands.Command {
    private final java.util.List<data.ChildInputData> childInputData;
    private final java.util.List<data.GiftInputData> gifts;
    private final input.Input input;

    public GiftsCommand(final input.Input input) {
        this.childInputData = input.getInitialData().getChildren();
        this.gifts = input.getInitialData().getSantaGiftsList();
        this.input = input;
    }

    /**
     *
     * Atribuie copilului cadoul din catgoria @category, care nu depaseste @budgetSum
     */
    public data.GiftInputData findgift(final String category, final double budgetSum) {
        data.GiftInputData giftInputData = null;
        enums.Category category1 = utils.Utils.stringToCategory(category);

        for (data.GiftInputData gift:gifts) {
            if (category1.equals(gift.getCategory())) {
                if (giftInputData == null) {
                    if (Double.compare(budgetSum, gift.getPrice()) > 0) {
                        giftInputData = gift;
                    }
                } else {
                    if (gift.getPrice() < giftInputData.getPrice()) {
                        if (Double.compare(budgetSum, gift.getPrice()) > 0) {
                            giftInputData = gift;
                        }
                    }
                }
            }
        }

        return giftInputData;
    }

    /**
     * Atribuie fiecarui copil cadourile
     */
    @Override
    public void execute() {
        java.util.LinkedList<String> prefgifts;
        data.GiftInputData gift;
        double budget;

        for (data.ChildInputData child:childInputData) {
            budget = child.getAssignedBudget();
            prefgifts = child.getGiftsPreferences();
            if (budget != 0) {
                if (prefgifts != null) {
                    for (String preference : prefgifts) {
                        gift = findgift(preference, budget);
                        if (gift != null) {
                            budget -= gift.getPrice();
                            child.getReceivedGifts().add(gift);
                        }
                    }
                }
            }
        }

        for (data.ChildInputData child:childInputData) {
            if (child.getAge() <= common.Constants.EIGHTEEN) {
                input.getChildren().add(new data.ChildInputData(child));
            }
        }
    }
}
