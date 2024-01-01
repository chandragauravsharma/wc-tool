package com.challenge.wc.executor;

import com.challenge.wc.model.wcCommand;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class wcExecutor {
    private wcCommand command;

    public wcExecutor(wcCommand command) {
        this.command = command;
    }

    public void executeCommand() {
        if (command.getOptions()[0] == 'c') {
            long totalBytes = getTotalBytesCount(command.getInputFile());
            System.out.println(totalBytes);
        } else if (command.getOptions()[0] == 'l') {
            long totalLines = getTotalLinesCount(command.getInputFile());
            System.out.println(totalLines);
        }
    }

    private long getTotalLinesCount(String inputFile) {
        String filePth = "src/main/resources/com/challenge/wc/" + inputFile;
        try {
            Path path = Paths.get(filePth);
            return Files.lines(path).count();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private long getTotalBytesCount(String inputFile) {
        String filePth = "src/main/resources/com/challenge/wc/" + inputFile;
        try {
            Path path = Paths.get(filePth);
            return Files.size(path);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
