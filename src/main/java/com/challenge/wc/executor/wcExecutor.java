package com.challenge.wc.executor;

import com.challenge.wc.util.wcConstants;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

public class wcExecutor {
    private String option;
    private InputStream inputStream;
    private String fileName;

    public wcExecutor(String option, InputStream inputStream, String fileName) {
        this.option = option;
        this.inputStream = inputStream;
        this.fileName = fileName;
    }

    public void executeCommand() {
        switch (option) {
            case "c":
                // total bytes
                long totalBytes = getTotalBytesCount();
                System.out.println(totalBytes);
                break;
            case "l":
                // total lines
                long totalLines = getTotalLinesCount();
                System.out.println(totalLines);
                break;
            case "w":
                // total words
                long totalWords = getTotalWordsCount();
                System.out.println(totalWords);
                break;
            case "m":
                // total characters
                long totalCharacters = getTotalCharactersCount();
                System.out.println(totalCharacters);
                break;
            case wcConstants.DEFAULT_OPTION:
                // default case
                System.out.println(executeDefaultCase());
                break;
            default:
                throw new RuntimeException("Invalid option");
        }
    }

    private String executeDefaultCase() {
        try {
            StringBuilder sb = new StringBuilder();
            long linesCount = 0;
            long wordCount = 0;
            long byteCount = 0;
            BufferedReader br = new BufferedReader(new InputStreamReader(inputStream, StandardCharsets.UTF_8));
            while (true) {
                String line = br.readLine();
                if (line == null) {
                    break;
                }

                linesCount++;
                byteCount += line.getBytes().length;
                wordCount += line.split("\\s+").length;
            }

            sb.append(linesCount + " " + wordCount + " " + byteCount);
            if (fileName != null) {
                sb.append(" " + fileName);
            }

            return sb.toString();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private long getTotalCharactersCount() {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(inputStream, StandardCharsets.UTF_8));
            long count = 0;
            while (br.read() != -1) {
                count++;
            }
            return count;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private long getTotalWordsCount() {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(inputStream, StandardCharsets.UTF_8));
            long count = 0;
            while (true) {
                String line = br.readLine();
                if (line == null) {
                    break;
                }
                String[] words = line.split("\\s+");
                count = count + words.length;
            }

            return count;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private long getTotalLinesCount() {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(inputStream, StandardCharsets.UTF_8));
            long count = 0;
            while (br.readLine() != null) {
                count++;
            }

            return count;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private long getTotalBytesCount() {
        try {
            long count = 0;
            long bytesRead;
            byte[] buffer = new byte[1024];
            while ((bytesRead = inputStream.read(buffer)) != -1) {
                count = count + bytesRead;
            }

            return count;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
