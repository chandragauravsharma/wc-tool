package com.challenge.wc.util;

import com.challenge.wc.model.wcCommand;

public class wcParser {
    public static wcCommand parserInputCommand(String[] inputCommand) {
        if (inputCommand.length < 2 || inputCommand.length > 3) {
            throw new RuntimeException("Incorrect command found");
        }

        String optionsStr = inputCommand[1];
        String option = "";
        if (optionsStr.charAt(0) == '-') {
            option = "" + optionsStr.charAt(1);
        }

        String file = "";
        if (inputCommand.length > 2) {
            file = inputCommand[2];
        } else {
            file = inputCommand[1];
        }

        return new wcCommand(inputCommand[0], option, file);
    }
}
