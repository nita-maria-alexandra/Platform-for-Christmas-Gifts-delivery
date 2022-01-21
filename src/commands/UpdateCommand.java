package commands;

import data.ChildInputData;
import data.AnnualChanges;
import data.ChildUpdate;
import input.Input;

import java.util.List;

public class UpdateCommand implements commands.Command {
    private final java.util.List<data.ChildInputData> childInputData;
    private final data.AnnualChanges changes;
    private final input.Input input;

    public UpdateCommand(final java.util.List<data.ChildInputData> childInputData, final data.AnnualChanges changes,
                         final input.Input input) {
        this.childInputData = childInputData;
        this.changes = changes;
        this.input = input;
    }

    /**
     * Mareste cu 1 varsta fiecarui copil
     */
    public void updateAge() {
        for (data.ChildInputData child:childInputData) {
            child.setAge(child.getAge() + 1);
            child.getReceivedGifts().clear();
        }
    }

    /**
     * Adauga noii copii in lista
     */
    public void addChildrenList() {
        for (data.ChildInputData child:changes.getNewChildren()) {
            if (child.getAge() <= common.Constants.EIGHTEEN) {
                child.getNiceScoreHistory().add(child.getNiceScore());
                childInputData.add(new data.ChildInputData(child));
            }
        }
    }

    /**
     * Face update fiecarui copil aflat in lista de updates, care are cel mult 18 ani
     */
    public void updateChildren() {
        for (data.ChildUpdate update:changes.getChildrenUpdates()) {
            for (data.ChildInputData child:childInputData) {
                if (child.getAge() <= common.Constants.EIGHTEEN) {
                    if (update.getId().compareTo(child.getId()) == 0) {
                        if (update.getNiceScore() != null) {
                            child.getNiceScoreHistory().add(update.getNiceScore());
                        }

                        if (!update.getGiftsPreferences().isEmpty()) {
                            for (int i = update.getGiftsPreferences().size() - 1; i >= 0; i--) {
                                if (child.getGiftsPreferences().contains(update
                                        .getGiftsPreferences().get(i))) {
                                    child.getGiftsPreferences().remove(update.getGiftsPreferences()
                                            .get(i));
                                }
                                child.getGiftsPreferences().addFirst(update.getGiftsPreferences()
                                        .get(i));
                            }
                        }
                    }
                }
            }
        }
    }

    /**
     * Aplica toate update-uri din anul respectiv
     */
    @Override
    public void execute() {
        updateAge();
        updateChildren();
        addChildrenList();
        input.getInitialData().getSantaGiftsList().addAll(changes.getNewGifts());
        input.setSantaBudget(changes.getNewSantaBudget());
    }
}
