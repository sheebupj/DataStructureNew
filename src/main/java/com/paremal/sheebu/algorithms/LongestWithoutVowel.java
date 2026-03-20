package com.paremal.sheebu.algorithms;

import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Stream;

/**
 * This class provides methods to find the longest string without vowels from an array of words.
 * It uses Java Streams and regular expressions to filter and compare strings efficiently.
 *
 * @author Sheebu P J
 * @version 1.0
 * @since 2026
 */
public class LongestWithoutVowel {
    /**
     * Main method to demonstrate the functionality of finding the longest string without vowels.
     * It creates an array of sample words and prints the result.
     *
     * @param args command-line arguments (not used)
     */
    public static void main(String[] args) {
        LongestWithoutVowel longestWithoutVowel = new LongestWithoutVowel();
        String[] words = {"ada",
                "xyz",
                "absolute",
                "arithmetic1",
                "bcdfghjklm",
                "aithmatic-expression"};
        System.out.println();
        System.out.println(longestWithoutVowel.findLongestStringWithoutvowels(words));

    }

    /**
     * Finds the longest string from the given array that does not contain any vowels (a, e, i, o, u, case-insensitive).
     * This method uses a stream to filter words that do not start with vowels and then reduces to find the longest one.
     *
     * <p>Note: The regex pattern "(?i)[aeiou].*" checks if the string starts with any vowel (case-insensitive).</p>
     * <p>Time Complexity: O(n * m), where n is the number of words and m is the average length of words due to regex matching.</p>
     * <p>Space Complexity: O(1) additional space beyond input, as streams are lazy and no extra collections are created.</p>
     *
     * @param words an array of strings to search through
     * @return the longest string without vowels; empty string if no such word exists or input is empty
     *
     * @example
     * <pre>
     * Input: ["ada", "xyz", "absolute", "arithmetic1", "bcdfghjklm", "aithmatic-expression"]
     * Output: "bcdfghjklm"
     * Explanation: "bcdfghjklm" has no vowels and is the longest among the filtered words.
     * </pre>
     */
    public String findLongestStringWithoutvowels(String[] words) {
        return Stream.of(words).filter(w -> !w.matches("(?i)[aeiou].*"))
                .reduce((w1, w2) -> w1.length() > w2.length() ? w1 : w2)
                .orElse("");
    }
}
