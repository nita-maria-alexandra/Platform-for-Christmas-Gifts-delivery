package commands;

import java.util.LinkedList;

public class ApplyCommands {
    private final java.util.LinkedList<Command> history = new java.util.LinkedList<>();

    /**
     *
     * @param command comanda care este executata
     */
    public void apply(final commands.Command command) {
        history.push(command);
        command.execute();
    }
}
