package com.paremal.sheebu.algorithms;

import java.util.*;
import java.util.stream.Collectors;

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
        System.out.println("=== Method 1: Original (Regex) ===");
        orderedStringsStartingWithVowel(List.of("india", "one", "upset", "abstract", "elephant", "Arrogant", "out"))
                .forEach((k, v) -> System.out.println(k + " " + v));

        System.out.println("\n=== Method 2: Set-based ===");
        orderedStringsStartingWithVowel1(List.of("india", "one", "upset", "abstract", "elephant", "Arrogant", "out"))
                .forEach((k, v) -> System.out.println(k + " " + v));

        System.out.println("\n=== Method 3: Optimised (Set + Single-Pass) ===");
        orderedStringsStartingWithVowelOptimised(List.of("india", "one", "upset", "abstract", "elephant", "Arrogant", "out"))
                .forEach((k, v) -> System.out.println(k + " " + v));
    }

    /**
     * Processes a list of strings to filter those starting with vowels (a, e, i, o, u, case-insensitive),
     * groups them by their first letter (converted to lowercase), counts the occurrences, and sorts the map by key.
     *
     * <p>This method uses streams to filter non-null and non-empty strings, then filters for vowel-starting strings,
     * and collects into a TreeMap for automatic alphabetical sorting by key.</p>
     * <p>Time Complexity: O(n * m + k log k), where n is the number of strings, m is the average string length for regex matching, and k is the number of unique vowel-starting letters.</p>
     * <p>Space Complexity: O(k), where k is the number of unique vowel-starting letters, for the resulting map.</p>
     *
     * @param strings the list of strings to process
     * @return a map where keys are lowercase vowel letters and values are their counts, sorted alphabetically by key
     */
    static Map<String, Integer> orderedStringsStartingWithVowel(List<String> strings) {
        return strings.stream()
                .filter(s->s!=null && !s.isEmpty())
                .filter(s -> s.matches("(?i)^[aeiou].*"))
                // Group by first letter (lowercase) and count occurrences
                // SPACE: Creates String object for each key with substring() - O(n) object creation
                .collect(Collectors.groupingBy( 
                        s-> s.substring(0, 1).toLowerCase(),  // Creates new String object for each string
                        TreeMap::new,  // TreeMap automatically sorts keys alphabetically
                        Collectors.summingInt(s -> 1)));  // Count occurrences
    }
    /**
     * METHOD 2: Set-based vowel checking with double-stream sorting
     * PERFORMANCE: O(n + k log k + k log k) - IMPROVED with Set but still double streaming
     * SORTING: By value descending (but uses two separate streams)
     * BENEFITS: Set.contains() is O(1) lookup, but double streaming adds overhead
     */
    static Map<String, Integer> orderedStringsStartingWithVowel1(List<String> strings) {
        // Create vowel set - EFFICIENT: Set.contains() is O(1), much better than List.contains()
       final Set<Character> vowels = Set.of('a', 'e', 'i', 'o', 'u');
        
        return strings.stream()
                
                .filter(s->s!=null && !s.isEmpty())
                // Filter 2: Check if first character is vowel using Set.contains() - O(n) = O(1) per lookup
                // PERFORMANCE: Set.contains() performs O(1) hash lookup (much better than List.contains())
                .filter(s -> vowels.contains(Character.toLowerCase(s.charAt(0))))
                .collect(Collectors.groupingBy(
                        s-> Character.toLowerCase(s.charAt(0)),  // Keeps as Character type
                        Collectors.summingInt(s -> 1)))
                .entrySet().stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .collect(Collectors.toMap(
                        me-> me.getKey().toString(),  // Convert Character to String
                        Map.Entry::getValue,
                        (me1,m2)->me1,
                        LinkedHashMap::new));
    }
    /**
     * METHOD 3: Optimised approach using Set-based vowel checking with true single-pass processing
     * PERFORMANCE: O(n + k log k) - BEST performance with Set O(1) lookup
     * SORTING: By value descending (optimal sort-collect at end)
     * BENEFITS: Set.contains() is O(1), forEach+merge is efficient, minimal object creation
     */
    static Map<String, Integer> orderedStringsStartingWithVowelOptimised(List<String> strings) {

        final Set<Character> vowels = Set.of('a', 'e', 'i', 'o', 'u');

        Map<String, Integer> result = new LinkedHashMap<>();

       strings.stream()
                .filter(s -> s != null && !s.isEmpty() && vowels.contains(Character.toLowerCase(s.charAt(0))))
                .forEach(s -> result.merge(
                        String.valueOf(Character.toLowerCase(s.charAt(0))), 1, Integer::sum));
        return result.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))// Collect into LinkedHashMap to preserve sorted insertion order
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (e1, e2) -> e1,
                        LinkedHashMap::new));
    }
}
