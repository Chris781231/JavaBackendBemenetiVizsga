package longestword;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class LongestWord {

    private String longestWord = "";
    private int maxLength = 0;

    private static final String WORD_SEPARATOR = " ";

    public String findLongestWord(String fileName) {
        if (isEmpty(fileName)) throw new IllegalArgumentException("invalid filename");

        Path path = Path.of(fileName);
        try (BufferedReader reader = Files.newBufferedReader(path)) {
            String line;
            while ((line = reader.readLine()) != null) {
                processLine(line);
            }
        } catch (IOException ioe) {
            return "";
        }
        return longestWord;
    }

    private void processLine(String line) {
        String[] parts = line.split(WORD_SEPARATOR);
        for (String item : parts) {
            if (item.length() > maxLength) {
                maxLength = item.length();
                longestWord = item;
            }
        }
    }

    private boolean isEmpty(String fileName) {
        return fileName == null || fileName.isBlank();
    }
}
