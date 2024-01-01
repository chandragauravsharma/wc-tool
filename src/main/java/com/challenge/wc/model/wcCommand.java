package com.challenge.wc.model;

public class wcCommand {
    String coreCommand;
    Character[] options;
    String inputFile;

    public wcCommand(String coreCommand, Character[] options, String inputFile) {
        this.coreCommand = coreCommand;
        this.options = options;
        this.inputFile = inputFile;
    }

    public String getCoreCommand() {
        return coreCommand;
    }

    public Character[] getOptions() {
        return options;
    }

    public String getInputFile() {
        return inputFile;
    }
}
