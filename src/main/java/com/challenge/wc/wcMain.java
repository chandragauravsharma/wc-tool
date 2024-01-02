package com.challenge.wc;

import com.challenge.wc.executor.wcExecutor;
import com.challenge.wc.model.wcCommand;
import com.challenge.wc.util.wcConstants;
import com.challenge.wc.util.wcParser;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;

public class wcMain {
    public static void main(String[] args) {
        wcCommand tokenizedCommand = wcParser.parseInputCommand(args);
        InputStream inputStream;
        if (tokenizedCommand.getInputFile() == null) {
            // piped input, no file provided in command
            inputStream = System.in;
        } else {
            try {
                inputStream = Files.newInputStream(Path.of(wcConstants.FILE_RESOURCE_PATH + tokenizedCommand.getInputFile()));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        wcExecutor wcExecutor = new wcExecutor(tokenizedCommand.getOption(), inputStream, tokenizedCommand.getInputFile());
        wcExecutor.executeCommand();
    }
}
