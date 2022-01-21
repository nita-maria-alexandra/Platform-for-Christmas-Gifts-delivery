package main;

import checker.Checker;
import writeo.Children;

import input.Input;
import commands.ApplyCommands;
import commands.AverageCommand;
import commands.BudgetCommand;
import commands.UpdateCommand;
import commands.GiftsCommand;

import java.io.IOException;
import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.Files;

/**
 * Class used to run the code
 */
public final class Main {

    private Main() {
        ///constructor for checkstyle
    }
    /**
     * This method is used to call the checker which calculates the score
     * @param args
     *          the arguments used to call the main method
     */
    public static void main(final String[] args) {
        int i;
        Path path = java.nio.file.Paths.get(common.Constants.REF_PATH);
        if (!java.nio.file.Files.exists(path)) {
            try {
                java.nio.file.Files.createDirectories(path);
            } catch (java.io.IOException e) {
                e.printStackTrace();
            }
        }

        for (i = 1; i <= common.Constants.TESTS_NUMBER; i++) {
            try {
                action(i);
            } catch (java.io.IOException e) {
                e.printStackTrace();
            }
        }

        Checker.calculateScore();
    }

    public static void action(final int i) throws IOException {
        writeo.AnnualChildren out = new writeo.AnnualChildren();

        com.fasterxml.jackson.databind.ObjectMapper objectMapper1 = new com.fasterxml
                .jackson.databind.ObjectMapper();
        Input input = objectMapper1.readValue(new java.io.File(common.Constants.INPUT_PATH
                + "test" + i + ".json"), Input.class);
        for (data.ChildInputData child:input.getInitialData().getChildren()) {
            child.getNiceScoreHistory().add(child.getNiceScore());
        }

        ApplyCommands commands = new ApplyCommands();
        commands.apply(new AverageCommand(input.getInitialData().getChildren()));
        commands.apply(new BudgetCommand(input.getInitialData().getChildren(),
                input.getSantaBudget()));
        commands.apply(new GiftsCommand(input));

        out.getAnnualChildren().add(new Children(input.getInitialData().getChildren()));

        for (int j = 0; j < input.getNumberOfYears(); j++) {
            commands.apply(new UpdateCommand(input.getInitialData().getChildren(),
                    input.getAnnualChanges().get(j), input));
            commands.apply(new AverageCommand(input.getInitialData().getChildren()));
            commands.apply(new BudgetCommand(input.getInitialData().getChildren(),
                    input.getSantaBudget()));
            commands.apply(new GiftsCommand(input));

            out.getAnnualChildren().add(new Children(input.getInitialData().getChildren()));
        }

        com.fasterxml.jackson.databind.ObjectMapper objectMapper = new com.fasterxml.jackson
                .databind.ObjectMapper();
        objectMapper.writeValue(new File(common.Constants.OUTPUT_PATH + i + ".json"), out);
    }
}
