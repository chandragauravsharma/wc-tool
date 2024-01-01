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
        String filePath = getFilePath(command.getInputFile());
        switch (command.getOption()) {
            case "c":
                // total bytes
                long totalBytes = getTotalBytesCount(filePath);
                System.out.println(totalBytes);
                break;
            case "l":
                // total lines
                long totalLines = getTotalLinesCount(filePath);
                System.out.println(totalLines);
                break;
            case "w":
                // total words
                long totalWords = getTotalWordsCount(filePath);
                System.out.println(totalWords);
                break;
            case "m":
                // total characters
                long totalCharacters = getTotalCharactersCount(filePath);
                System.out.println(totalCharacters);
                break;
            case "":
                // default case
                System.out.println(executeDefaultCase(filePath, command.getInputFile()));
                break;
            default:
                throw new RuntimeException("Invalid option");
        }
    }

    private String executeDefaultCase(String filePath, String fileName) {
        StringBuilder sb = new StringBuilder();
        sb.append(getTotalLinesCount(filePath) + " ");
        sb.append(getTotalWordsCount(filePath) + " ");
        sb.append(getTotalBytesCount(filePath) + " ");
        sb.append(fileName);

        return sb.toString();
    }

    private String getFilePath(String fileName) {
        return "src/main/resources/com/challenge/wc/" + fileName;
    }

    private long getTotalCharactersCount(String filePath) {
        try {
            Path path = Paths.get(filePath);
            return Files.readString(path).length();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private long getTotalWordsCount(String filePath) {
        try {
            Path path = Paths.get(filePath);
            return Files.readAllLines(path, java.nio.charset.StandardCharsets.UTF_8)
                    .stream().flatMap(line -> java.util.Arrays.stream(line.split("\\s+")))
                    .filter(word -> !word.isEmpty())
                    .filter(word -> !word.isBlank())
                    .count();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private long getTotalLinesCount(String filePath) {
        try {
            Path path = Paths.get(filePath);
            return Files.lines(path).count();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private long getTotalBytesCount(String filePath) {
        try {
            Path path = Paths.get(filePath);
            return Files.readAllBytes(path).length;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
