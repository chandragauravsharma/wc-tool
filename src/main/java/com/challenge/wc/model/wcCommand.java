package com.challenge.wc.model;

public class wcCommand {
    String coreCommand;
    String option;
    String inputFile;

    public wcCommand(String coreCommand, String option, String inputFile) {
        this.coreCommand = coreCommand;
        this.option = option;
        this.inputFile = inputFile;
    }

    public String getCoreCommand() {
        return coreCommand;
    }

    public String getOption() {
        return option;
    }

    public String getInputFile() {
        return inputFile;
    }
}
