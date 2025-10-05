package com.example.wordcounterapp;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TextMetrics {

    // --- REGEX METRICS ---

    // Count sentences using regex (. ! ?)
    public static int countSentences(String text) {
        if (text == null || text.trim().isEmpty()) return 0;

        Pattern pattern = Pattern.compile("[^.!?]+[.!?]?");
        Matcher matcher = pattern.matcher(text);
        int count = 0;

        while (matcher.find()) {
            String sentence = matcher.group().trim();
            if (!sentence.isEmpty()) {
                count++;
            }
        }
        return count;
    }

    // Count numbers using regex (whole numbers + decimals)
    public static int countNumbers(String text) {
        if (text == null || text.trim().isEmpty()) return 0;

        Pattern pattern = Pattern.compile("\\b\\d+(\\.\\d+)?\\b");
        Matcher matcher = pattern.matcher(text);
        int count = 0;

        while (matcher.find()) {
            count++;
        }
        return count;
    }

    // --- NON-REGEX METRICS ---

    // Count words separated by spaces, commas, or dots
    public static int countWords(String text) {
        if (text == null || text.trim().isEmpty()) return 0;

        String[] parts = text.split("[\\s,\\.]+"); // split on space/comma/dot
        int count = 0;

        for (String word : parts) {
            if (!word.trim().isEmpty()) {
                count++;
            }
        }
        return count;
    }

    // Count characters (including spaces and punctuation)
    public static int countChars(String text) {
        if (text == null) return 0;
        return text.length();
    }
}
