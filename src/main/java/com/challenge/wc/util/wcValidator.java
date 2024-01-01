package com.challenge.wc.util;

public class wcValidator {
    public static boolean validateInputCommand(String inputCommand) {
        String[] strs = inputCommand.split(" ");
        if (strs.length == 0) {
            return false;
        }
        if (!strs[0].equals("ccwc")) {
            return false;
        }
        if (strs[1].charAt(0) != '-') {
            return false;
        }

        return true;
    }
}
