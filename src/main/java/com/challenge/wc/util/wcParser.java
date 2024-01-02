package com.challenge.wc.util;

import com.challenge.wc.model.wcCommand;

public class wcParser {
    public static wcCommand parseInputCommand(String[] inputCommand) {
        String command;
        String option;
        String file;

        if (inputCommand.length == 0) {
            throw new RuntimeException("No command found");
        }

        command = inputCommand[0];
        if (!command.equals(wcConstants.CCWC)) {
            throw new RuntimeException("Incorrect command (use ccwc)");
        }

        if (inputCommand.length > 1 && inputCommand[1].charAt(0) == '-') {
            option = inputCommand[1].charAt(1) + "";
        } else {
            option = wcConstants.DEFAULT_OPTION;
        }

        if (inputCommand.length == 2 && inputCommand[1].charAt(0) != '-') {
            file = inputCommand[1];
        } else if (inputCommand.length == 3) {
            file = inputCommand[2];
        } else {
            file = null;
        }

        return new wcCommand(command, option, file);
    }
}
