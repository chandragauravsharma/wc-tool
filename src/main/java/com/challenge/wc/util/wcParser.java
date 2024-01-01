package com.challenge.wc.util;

import com.challenge.wc.model.wcCommand;

public class wcParser {
    public static wcCommand parserInputCommand(String inputCommand) {
        String[] strs = inputCommand.split(" ");
        if (strs.length < 2 || strs.length > 3) {
            throw new RuntimeException("Incorrect command found");
        }

        String optionsStr = strs[1];
        String option = "";
        if (optionsStr.charAt(0) == '-') {
            option = "" + optionsStr.charAt(1);
        }

        String file = "";
        if (strs.length > 2) {
            file = strs[2];
        } else {
            file = strs[1];
        }

        return new wcCommand(strs[0], option, file);
    }
}
