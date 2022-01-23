package commands;

import java.util.List;

import data.ChildInputData;
import data.GiftInputData;

public class YellowElfCommand implements  Command {
    private final ChildInputData child;
    private final List<GiftInputData> gifts;

    /**
     *
     * @param child lista de copii
     * @param gifts lista de cadouri disponibile ale  mosului
     */
    public YellowElfCommand(final ChildInputData child, final List<GiftInputData> gifts) {
        this.child = child;
        this.gifts = gifts;
    }

    /**
     *
     * Returneaza cel mai ieftin cadou, care are cantitatea mai mare ca zero,
     * din categoria preferata de copil
     */
    public GiftInputData findgift(final String category) {
        GiftInputData giftInputData = null;
        enums.Category category1 = utils.Utils.stringToCategory(category);

        for (GiftInputData gift:gifts) {
            if (category1.equals(gift.getCategory())) {
                if (giftInputData == null) {
                    giftInputData = gift;
                } else {
                    if (gift.getPrice() < giftInputData.getPrice()) {
                        giftInputData = gift;
                    }
                }
            }
        }

        if (giftInputData != null && giftInputData.getQuantity() == 0) {
            return null;
        }

        return giftInputData;
    }

    /**
     * Ofera copilului cel mai ieftin cadou din lista de cadouri favorite a acestuia
     */
    @Override
    public void execute() {
        java.util.LinkedList<String> prefgifts;
        GiftInputData gift;
        prefgifts = child.getGiftsPreferences();

        if (prefgifts != null) {
            for (String preference : prefgifts) {
                gift = findgift(preference);
                if (gift != null) {
                            child.getReceivedGifts().add(gift);
                            gift.setQuantity(gift.getQuantity() - 1);
                            return;
                }
            }
        }
    }
}
