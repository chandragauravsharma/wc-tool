package com.challenge.wc.util;

public class wcValidator {
    public static boolean validateInputCommand(String[] inputCommand) {
        if (inputCommand.length == 0) {
            return false;
        }
        if (!inputCommand[0].equals("ccwc")) {
            return false;
        }
        if (inputCommand.length > 2 && inputCommand[1].charAt(0) != '-') {
            return false;
        }

        return true;
    }
}
