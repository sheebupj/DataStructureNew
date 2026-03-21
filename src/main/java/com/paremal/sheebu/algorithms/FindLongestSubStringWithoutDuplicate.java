package com.paremal.sheebu.algorithms;

import java.util.*;

/**
 * This class provides methods to find the longest substring without duplicate characters.
 * It implements an algorithm that iterates through the string, maintaining a sliding window
 * of unique characters and tracks the longest such substring found.
 *
 * <p>Features:</p>
 * <ul>
 *     <li>Efficient algorithms to find the longest substring without duplicates.</li>
 *     <li>Multiple implementations to demonstrate different approaches.</li>
 *     <li>Examples and complexity analysis for better understanding.</li>
 * </ul>
 *
 * <p>Usage:</p>
 * <pre>
 * {@code
 *     String input = "abcabcbb";
 *     String result = FindLongestSubStringWithoutDuplicate.getLongestSubStringWithoutDuplicate(input);
 *     System.out.println(result); // Output: "abc"
 * }
 * </pre>
 *
 * @author Sheebu P J
 * @version 1.0
 * @since 2023
 */
public class FindLongestSubStringWithoutDuplicate {

    public static void main(String[] args) {
        String str = "dvdf";

        System.out.println(getLongestSubStringWithoutDuplicate(str));
    }

    /**
     * Finds the longest substring without duplicate characters in the given string.
     * This method uses a sliding window approach with a HashMap to track character frequencies.
     *
     * <p>Time Complexity: O(n), where n is the length of the input string, as each character is processed at most twice.</p>
     * <p>Space Complexity: O(min(n, m)), where m is the size of the character set (e.g., 128 for ASCII).</p>
     *
     * @param s the input string to search for the longest substring without duplicates
     * @return the longest substring without duplicate characters; empty string if input is null or empty
     *
     * @example
     * <pre>
     * Input: s = "abcabcbb"
     * Output: "abc"
     * Explanation: The answer is "abc", with the length of 3.
     * </pre>
     *
     * @example
     * <pre>
     * Input: s = "bbbbb"
     * Output: "b"
     * Explanation: The answer is "b", with the length of 1.
     * </pre>
     *
     * @example
     * <pre>
     * Input: s = "pwwkew"
     * Output: "wke"
     * Explanation: The answer is "wke", with the length of 3.
     * Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.
     * </pre>
     */
    public static String getLongestSubStringWithoutDuplicate2(String s) {
        String[] strs = s.split("");
        List<String> list = new ArrayList<>();
        int i = 0;
        String temp = "";
        Map<String, Integer> map = new HashMap<>();
        for (int j = i; j < strs.length; j++) {
            if (!map.containsKey(strs[j])) {
                temp += strs[j];
                map.put(strs[j], 1);
                i++;
                if(i==strs.length){list.add(temp);}
            }
            else {
                list.add(temp);
                temp = strs[j];
                map= new HashMap<>();
                map.put(strs[j], 1);
                i++;
            }
        }
        return list.stream().reduce((a, b) -> a.length() > b.length() ? a : b).orElse("");
    }

    /**
     * Optimized method to find the longest substring without duplicate characters.
     * This implementation uses a sliding window approach with a LinkedHashSet to maintain the order of characters.
     *
     * <p>Time Complexity: O(n), where n is the length of the input string, as each character is processed at most twice.</p>
     * <p>Space Complexity: O(min(n, m)), where m is the size of the character set (e.g., 128 for ASCII).</p>
     *
     * @param s the input string to search for the longest substring without duplicates
     * @return the longest substring without duplicate characters; empty string if input is null or empty
     *
     * @example
     * <pre>
     * Input: s = "abcabcbb"
     * Output: "abc"
     * Explanation: The answer is "abc", with the length of 3.
     * </pre>
     *
     * @example
     * <pre>
     * Input: s = "bbbbb"
     * Output: "b"
     * Explanation: The answer is "b", with the length of 1.
     * </pre>
     *
     * @example
     * <pre>
     * Input: s = "pwwkew"
     * Output: "wke"
     * Explanation: The answer is "wke", with the length of 3.
     * Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.
     * </pre>
     */
    public static String getLongestSubStringWithoutDuplicate(String s) {
        if (s == null || s.isEmpty()) { return ""; }
        int left = 0;
        int maxStart = 0;
        int maxLength = 0;
        Set<Character> windowElements = new LinkedHashSet<>();
        for (int right = 0; right < s.length(); right++) {
            char currentChar = s.charAt(right);
            while (windowElements.contains(currentChar)) {
                windowElements.remove(s.charAt(left));
                left++;
            }
            windowElements.add(currentChar);
            if(right-left+1>maxLength){
                maxLength = right-left+1;
                maxStart = left;
            }
        }
        return s.substring(maxStart,maxStart+maxLength);
    }
}
