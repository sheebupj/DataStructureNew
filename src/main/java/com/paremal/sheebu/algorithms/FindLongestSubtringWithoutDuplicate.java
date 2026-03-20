package com.paremal.sheebu.algorithms;

import java.util.*;

public class FindLongestSubtringWithoutDuplicate {
    public static void main(String[] args) {
        String str = "12123412345612345671234567891234567890";

        System.out.println(getLongestSbstrWithoutDuplicate(str));

    }

    /**
     *
     * @param name
     * @return string
     * Given a string s, find the length of the longest substring without duplicate characters
     *
     * Input: s = "abcabcbb"
     * Output: 3
     * Explanation: The answer is "abc", with the length of 3. Note that "bca" and "cab" are also correct answers.
     *
     * Example 2:
     *
     * Input: s = "bbbbb"
     * Output: 1
     * Explanation: The answer is "b", with the length of 1.
     *
     * Example 3:
     *
     * Input: s = "pwwkew"
     * Output: 3
     * Explanation: The answer is "wke", with the length of 3.
     * Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.
     *
     *
     *
     *
     * Input: s = "abcabcbb"
     * Output: 3
     * Explanation: The answer is "abc", with the length of 3. Note that "bca" and "cab" are also correct answers.
     *
     * Example 2:
     *
     * Input: s = "bbbbb"
     * Output: 1
     * Explanation: The answer is "b", with the length of 1.
     *
     * Example 3:
     *
     * Input: s = "pwwkew"
     * Output: 3
     * Explanation: The answer is "wke", with the length of 3.
     * Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.
     */
    public static String getLongestSbstrWithoutDuplicate(String name) {
        String[] strs = name.split("");
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
        Optional<String> opt = list.stream().reduce((a, b) -> a.length() > b.length() ? a : b);
        return opt.orElse("");
    }
}
