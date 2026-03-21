package com.paremal.sheebu.algorithms;

import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * This class provides methods to rank and filter elements based on their frequency of occurrence
 * in an array. It computes the frequency distribution of elements and returns elements ranked
 * by their frequency in descending order, with the ability to specify a range of ranks to retrieve.
 *
 * <p>Features:</p>
 * <ul>
 *     <li>Efficient frequency counting using Java Streams and Collectors.</li>
 *     <li>Frequency-based ranking and sorting in descending order.</li>
 *     <li>Flexible range selection with custom start rank and result size.</li>
 *     <li>Maintains insertion order in results using LinkedHashMap.</li>
 * </ul>
 *
 * <p>Algorithm Overview:</p>
 * <ol>
 *     <li>Count the frequency of each unique element in the input array.</li>
 *     <li>Sort elements by frequency in descending order.</li>
 *     <li>Skip the first (fromRank - 1) entries and limit results to the specified number.</li>
 *     <li>Return results as a LinkedHashMap to preserve order.</li>
 * </ol>
 *
 * <p>Usage:</p>
 * <pre>
 * {@code
 *     Integer[] input = {1, 2, 2, 3, 3, 3};
 *     FrequencyRanking ranking = new FrequencyRanking();
 *     Map<Integer, Integer> result = ranking.frequencyRankingFromTo(input, 1, 2);
 *     // Result: {3=3, 2=2} (top 2 elements by frequency)
 * }
 * </pre>
 *
 * @author Sheebu P J
 * @version 1.0
 * @since 2023
 */
public class FrequencyRanking {
    public static void main(String[] args) {
        Integer[] ints = {1, 3, 6, 4, 2, 1, 9, 3, 5, 1, 8, 3, 8, 5, 6, 3, 2, 0, 6, 4, 2, 7, 9, 3, 2, 1};
        Integer[] ints1 = {0, 1, 2, 3, 4, 5, 6, 0, 1, 0, 2, 0, 1, 0, 5, 1, 0, 2, 4};
        FrequencyRanking ranking = new FrequencyRanking();
        Map<Integer, Integer> first = ranking.frequencyRankingFromTo(ints, 2, 3);
        Map<Integer, Integer> second = ranking.frequencyRankingFromTo(ints1, 1, 4);
        first.entrySet().forEach(me -> System.out.println(me.getKey() + ":" + me.getValue()));
        System.out.println();
        second.entrySet().forEach(me -> System.out.println(me.getKey() + ":" + me.getValue()));
    }

    /**
     * Computes the frequency of elements in the input array and returns elements ranked
     * by frequency in descending order, with results filtered to a specific range.
     *
     * <p>Time Complexity: O(n + u log u), where n is the array length and u is the number of unique elements.</p>
     * <ul>
     *     <li>Frequency counting: O(n)</li>
     *     <li>Sorting by frequency: O(u log u)</li>
     *     <li>Skip and limit operations: O(k), where k = numbers</li>
     * </ul>
     * <p>Space Complexity: O(u + k), where u is the number of unique elements and k is the result size.</p>
     *
     * @param ints the input array of integers to analyze
     * @param fromRank the starting rank (1-based index) for the result; must be >= 1
     * @param numbers the maximum number of elements to return in the result
     * @return a LinkedHashMap containing the selected elements and their frequencies, ordered by descending frequency.
     *         Returns an empty map if fromRank exceeds the number of unique elements.
     *
     * @throws NullPointerException if ints is null
     *
     * @example
     * <pre>
     * Input: ints = {1, 3, 6, 4, 2, 1, 9, 3, 5, 1, 8, 3, 8, 5, 6, 3, 2, 0, 6, 4, 2, 7, 9, 3, 2, 1}
     *        fromRank = 2, numbers = 3
     * Frequency ranking: 3 appears 5 times, 2 appears 4 times, 6 appears 3 times, ...
     * Output: {1=4, 2=4, 6=3} (ranks 2-4 by frequency)
     * </pre>
     *
     * @example
     * <pre>
     * Input: ints = {0, 1, 2, 3, 4, 5, 6, 0, 1, 0, 2, 0, 1, 0, 5, 1, 0, 2, 4}
     *        fromRank = 1, numbers = 4
     * Frequency ranking: 0 appears 6 times, 1 appears 4 times, 2 appears 3 times, 4 appears 2 times, ...
     * Output: {0=6, 1=4, 2=3, 4=2} (top 4 elements by frequency)
     * </pre>
     */
    public Map<Integer, Integer> frequencyRankingFromTo(Integer[] ints, int fromRank, int numbers) {
        return Stream.of(ints).collect(Collectors.toMap(Function.identity(), v -> 1, Integer::sum))
                .entrySet().stream().sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .skip(fromRank - 1).limit(numbers)
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (m1, m2) -> m1, LinkedHashMap::new));

    }
}
