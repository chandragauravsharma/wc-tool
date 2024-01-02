package com.challenge.wc;

import com.challenge.wc.executor.wcExecutor;
import com.challenge.wc.model.wcCommand;
import com.challenge.wc.util.wcParser;
import com.challenge.wc.util.wcValidator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class wcMain {
    public static void main(String[] args) {
        if (wcValidator.validateInputCommand(args)) {
            wcCommand tokenizedCommand = wcParser.parserInputCommand(args);
            wcExecutor wcExecutor = new wcExecutor(tokenizedCommand);
            wcExecutor.executeCommand();
        } else {
            System.out.println("Wrong command. Please check");
        }
    }
}
