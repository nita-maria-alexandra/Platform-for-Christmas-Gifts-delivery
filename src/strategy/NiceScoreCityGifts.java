package strategy;

import data.ChildInputData;
import data.GiftInputData;
import input.Input;
import java.util.List;
import java.util.LinkedList;

public class NiceScoreCityGifts implements GiftStrategy {
    private final List<ChildInputData> childInputData;
    private final List<GiftInputData> gifts;
    private final Input input;

    public NiceScoreCityGifts(final Input input) {
        this.childInputData = input.getInitialData().getChildren();
        this.gifts = input.getInitialData().getSantaGiftsList();
        this.input = input;
    }

    /**
     *
     * @param category ...
     * @param budgetSum ...
     * @return ...
     */
    public GiftInputData findgift(final String category, final double budgetSum) {
        GiftInputData giftInputData = null;
        enums.Category category1 = utils.Utils.stringToCategory(category);

        for (GiftInputData gift:gifts) {
            if (category1.equals(gift.getCategory()) && gift.getQuantity() > 0) {
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
     *
     */
    @Override
    public void giftList() {
        LinkedList<String> prefgifts;
        GiftInputData gift;
        double budget;
        commands.ApplyCommands commands = new commands.ApplyCommands();

        for (String key:input.getNiceScoreCity().keySet()) {
            for (ChildInputData child : childInputData) {
                if (child.getAge() <= common.Constants.EIGHTEEN
                && child.getCity().compareTo(key) == 0) {
                    budget = child.getAssignedBudget();
                    prefgifts = child.getGiftsPreferences();
                    if (budget != 0) {
                        if (prefgifts != null) {
                            for (String preference : prefgifts) {
                                gift = findgift(preference, budget);
                                if (gift != null) {
                                    budget -= gift.getPrice();
                                    child.getReceivedGifts().add(gift);
                                    gift.setQuantity(gift.getQuantity() - 1);
                                }
                            }
                            if (child.getReceivedGifts().isEmpty()
                                    && child.getElf().compareTo("yellow") == 0) {
                                commands.apply(new commands.YellowElfCommand(child, gifts));
                            }
                        }
                    }
                }
            }
        }

        for (ChildInputData child:childInputData) {
            if (child.getAge() <= common.Constants.EIGHTEEN) {
                input.getChildren().add(new ChildInputData(child));
            }
        }
    }
}
