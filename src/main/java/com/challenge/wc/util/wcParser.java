package com.challenge.wc.util;

import com.challenge.wc.model.wcCommand;

public class wcParser {
    public static wcCommand parserInputCommand(String inputCommand) {
        String[] strs = inputCommand.split(" ");
        if (strs.length != 3) {
            throw new RuntimeException("Incorrect command found");
        }

        String optionsStr = strs[1];
        Character[] options = new Character[optionsStr.length() - 1];
        for (int i = 1; i < optionsStr.length(); i++) {
            options[i - 1] = optionsStr.charAt(i);
        }
        return new wcCommand(strs[0], options, strs[2]);
    }
}
