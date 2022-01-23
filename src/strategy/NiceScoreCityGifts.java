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
     * Atribuie fiecarui copil cadourile, in ordinea scorurilor de cumintenie a oraselor
     */
    @Override
    public void giftList() {
        LinkedList<String> prefgifts;
        GiftInputData gift;
        double budget;
        commands.ApplyCommands commands = new commands.ApplyCommands();
        IdGift find = new IdGift(input);

        for (String key:input.getNiceScoreCity().keySet()) {
            for (ChildInputData child : childInputData) {
                if (child.getAge() <= common.Constants.EIGHTEEN
                && child.getCity().compareTo(key) == 0) {
                    budget = child.getAssignedBudget();
                    prefgifts = child.getGiftsPreferences();
                    if (budget != 0) {
                        if (prefgifts != null) {
                            for (String preference : prefgifts) {
                                gift = find.findgift(preference, budget);
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
