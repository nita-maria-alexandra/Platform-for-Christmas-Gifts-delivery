package strategy;

import data.ChildInputData;
import data.GiftInputData;
import input.Input;
import java.util.List;
import java.util.LinkedList;
import java.util.Comparator;

public class NiceScoreGifts implements GiftStrategy {
    private final List<ChildInputData> childInputData;
    private final List<GiftInputData> gifts;
    private final Input input;

    public NiceScoreGifts(final Input input) {
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
        commands.ApplyCommands commands = new commands.ApplyCommands();
        LinkedList<String> prefgifts;
        GiftInputData gift;
        double budget;

        childInputData.sort((c1, c2) -> {
            if (Double.compare(c1.getAverageScore(), c2.getAverageScore()) == 0) {
                return c1.getId().compareTo(c2.getId());
            }
            return Double.compare(c2.getAverageScore(), c1.getAverageScore());
        });

        for (ChildInputData child:childInputData) {
            if (child.getAge() <= common.Constants.EIGHTEEN) {
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
        childInputData.sort(Comparator.comparing(ChildInputData::getId));
        for (ChildInputData child:childInputData) {
            if (child.getAge() <= common.Constants.EIGHTEEN) {
                input.getChildren().add(new ChildInputData(child));
            }
        }
    }
}
