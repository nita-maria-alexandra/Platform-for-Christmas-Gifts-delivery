package commands;

import java.util.LinkedList;

public class ApplyCommands {
    private final LinkedList<Command> history = new LinkedList<>();

    /**
     *
     * @param command comanda care este executata
     */
    public void apply(final commands.Command command) {
        history.push(command);
        command.execute();
    }
}
