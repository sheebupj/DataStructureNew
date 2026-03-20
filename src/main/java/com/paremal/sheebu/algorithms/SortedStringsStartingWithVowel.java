package com.paremal.sheebu.algorithms;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * This class provides functionality to process a list of strings, filtering those that start with vowels,
 * counting occurrences by their first letter (case-insensitive), and sorting the results alphabetically.
 * It utilizes Java Streams for efficient data processing.
 *
 * @author Sheebu P J
 * @version 1.0
 * @since 2026
 */
public class SortedStringsStartingWithVowel {
    /**
     * Main method to demonstrate the functionality of sorting and counting strings starting with vowels.
     * It creates a sample list of strings and prints the grouped and sorted results.
     *
     * @param args command-line arguments (not used)
     */
    public static void main(String[] args) {
        orderedStringsStartingWithVowel(List.of("india", "one", "upset", "abstract", "elephant", "Arrogant", "out"))
                .entrySet().forEach(s -> System.out.println(s.getKey() + " " + s.getValue()));

    }

    /**
     * Processes a list of strings to filter those starting with vowels (a, e, i, o, u, case-insensitive),
     * groups them by their first letter (converted to lowercase), counts the occurrences, and sorts the map by key.
     *
     * <p>This method uses streams to filter, collect into a map, sort entries, and collect back into a LinkedHashMap.</p>
     * <p>Time Complexity: O(n * m + k log k), where n is the number of strings, m is the average string length for regex matching, and k is the number of unique vowel-starting letters.</p>
     * <p>Space Complexity: O(k), where k is the number of unique vowel-starting letters, for the resulting map.</p>
     *
     * @param strings the list of strings to process
     * @return a map where keys are lowercase vowel letters and values are their counts, sorted alphabetically by key
     *
     * @example
     * <pre>
     * Input: ["india", "one", "upset", "abstract", "elephant", "Arrogant", "out"]
     * Output: {a=2, e=1, i=1, o=2, u=1}
     * Explanation: "a" from "abstract" and "Arrogant", "e" from "elephant", "i" from "india", "o" from "one" and "out", "u" from "upset".
     * </pre>
     */
    static Map<String, Integer> orderedStringsStartingWithVowel(List<String> strings) {
        return strings.stream().filter(s -> s.matches("(?i)^[aeiou].*"))
                .collect(Collectors.toMap(s -> s.substring(0, 1)
                        .toLowerCase(), s -> 1, Integer::sum))
                .entrySet().stream()
                .sorted(Map.Entry.comparingByKey())
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
                        (me1, me2) -> me1, LinkedHashMap::new));
    }
}
