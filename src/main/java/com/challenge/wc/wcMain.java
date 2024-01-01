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
        System.out.println("Input your command... e.g. [ccwc -c test.txt]");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try {
            String input = br.readLine();
            if (wcValidator.validateInputCommand(input)) {
                wcCommand tokenizedCommand = wcParser.parserInputCommand(input);
                wcExecutor wcExecutor = new wcExecutor(tokenizedCommand);
                wcExecutor.executeCommand();
            } else {
                System.out.println("Wrong command. Please check");
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
