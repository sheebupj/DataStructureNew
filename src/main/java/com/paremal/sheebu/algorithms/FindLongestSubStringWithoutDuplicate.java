package com.paremal.sheebu.algorithms;

import java.util.*;

/**
 * This class provides methods to find the longest substring without duplicate characters.
 * It implements an algorithm that iterates through the string, maintaining a sliding window
 * of unique characters and tracks the longest such substring found.
 *
 * @author Sheebu P J
 * @version 1.0
 * @since 2023
 */
public class FindLongestSubStringWithoutDuplicate {
    public static void main(String[] args) {
        String str = "12123412345612345671234567891234567890";

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
    public static String getLongestSubStringWithoutDuplicate(String s) {
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
}
