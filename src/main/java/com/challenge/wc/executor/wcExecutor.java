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
            // total bytes
            long totalBytes = getTotalBytesCount(command.getInputFile());
            System.out.println(totalBytes);
        } else if (command.getOptions()[0] == 'l') {
            // total lines
            long totalLines = getTotalLinesCount(command.getInputFile());
            System.out.println(totalLines);
        } else if (command.getOptions()[0] == 'w') {
            // total words
            long totalWords = getTotalWordsCount(command.getInputFile());
            System.out.println(totalWords);
        } else if (command.getOptions()[0] == 'm') {
            // total characters
            long totalCharacters = getTotalCharactersCount(command.getInputFile());
            System.out.println(totalCharacters);
        }
    }

    private long getTotalCharactersCount(String inputFile) {
        String filePth = "src/main/resources/com/challenge/wc/" + inputFile;
        try {
            Path path = Paths.get(filePth);
            return Files.readString(path).length();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private long getTotalWordsCount(String inputFile) {
        String filePth = "src/main/resources/com/challenge/wc/" + inputFile;
        try {
            Path path = Paths.get(filePth);
            return Files.readAllLines(path, java.nio.charset.StandardCharsets.UTF_8)
                    .stream().flatMap(line -> java.util.Arrays.stream(line.split("\\s+")))
                    .filter(word -> !word.isEmpty())
                    .filter(word -> !word.isBlank())
                    .count();
        } catch (IOException e) {
            throw new RuntimeException(e);
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
            return Files.readAllBytes(path).length;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
