package com.paremal.sheebu.algorithms;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class DigitToWord {
    public static void main(String[] args) {


        System.out.println(digitToWordIndian(123456789));
        System.out.println(digitToWordIndian(77777777));
        System.out.println(digitToWordIndian(7777777));
        System.out.println(digitToWordMillionBioinformatic(123456789L));
        System.out.println(digitToWordMillionBioinformatic(123456789012345L));
        System.out.println(digitToWordMillionBioinformatic(543210123456789L));



    }

    static String digitToWordIndian(Integer digit) {
        String digits = digit + "";
        List<String> list = getSplitDigitsIndian(reverse(digits));
        List<String> suffixes = getSuffixesListIndian();
        StringBuilder wordDigits = new StringBuilder();
        for (int i = list.size() - 1; i >= 0; i--) {
            if (i == 0)
                wordDigits.append(" and ").append(twoDigitToWord(list.get(i))).append(" ").append(suffixes.get(i));
            else wordDigits.append(twoDigitToWord(list.get(i))).append(" ").append(suffixes.get(i)).append(", ");
        }
        return wordDigits.toString();

    }
    static String digitToWordMillionBioinformatic(Long digit) {
        String digits = digit + "";
        if (digits.length()>15) return "max digits allowed is 15 ";
        List<String> list = getSplitDigitsMillionBioinformatic(reverse(digits));
        List<String> suffixes = getSuffixesListBioinformatic();
        StringBuilder wordDigits = new StringBuilder();
        for (int i = list.size() - 1; i >= 0; i--) {
            if (i == 0)
                wordDigits.append(" and ").append(twoDigitToWord(list.get(i))).append(" ").append(suffixes.get(i));
            else if (i==1) wordDigits.append(twoDigitToWord(list.get(i))).append(" ").append(suffixes.get(i)).append(", ");
            else {
                if(list.get(i).length()>2)
                wordDigits.append(threeDigitToWord(list.get(i))).append(" ").append(suffixes.get(i)).append(", ");
                else wordDigits.append(twoDigitToWord(list.get(i))).append(" ").append(suffixes.get(i)).append(", ");
            }
        }
        return wordDigits.toString();

    }

    static List<Integer[]> getGetSplittingPositionsIndian() {
        List<Integer[]> list = new ArrayList<>();
        list.add(new Integer[]{0, 2});
        list.add(new Integer[]{2, 3});
        list.add(new Integer[]{3, 5});
        list.add(new Integer[]{5, 7});
        list.add(new Integer[]{7, 9});
        return list;
    }

    static List<Integer[]> getGetSplittingPositionsMillionBioinformatic() {
        List<Integer[]> list = new ArrayList<>();
        list.add(new Integer[]{0, 2});
        list.add(new Integer[]{2, 3});
        list.add(new Integer[]{3, 6});
        list.add(new Integer[]{6, 9});
        list.add(new Integer[]{9, 12});
        list.add(new Integer[]{12, 15});

        return list;
    }

    static List<String> getSplitDigitsIndian(String digits) {
        List<Integer[]> splitPositions = getGetSplittingPositionsIndian();
        int len = digits.length();
        List<String> list = new ArrayList<>();
        for (Integer[] positions : splitPositions) {
            int endIndex = positions[1];
            if (positions[0] < len) {
                if (endIndex >= len) endIndex = len;
                list.add(digits.substring(positions[0], endIndex));
            }
        }
        return list;
    }
    static List<String> getSplitDigitsMillionBioinformatic(String digits) {
        List<Integer[]> splitPositions = getGetSplittingPositionsMillionBioinformatic();
        int len = digits.length();
        List<String> list = new ArrayList<>();
        for (Integer[] positions : splitPositions) {
            int endIndex = positions[1];
            if (positions[0] < len) {
                if (endIndex >= len) endIndex = len;
                list.add(digits.substring(positions[0], endIndex));
            }
        }
        return list;
    }

    /**
     * Reverses the given string.
     *
     * @param s The string to reverse.
     * @return The reversed string.
     */
    static String reverse(String s) {
        int len = s.length() - 1;
        return IntStream.iterate(len, i -> i >= 0, i -> i - 1)
                .boxed()
                .map(s::charAt)
                .map(String::valueOf)
                .collect(Collectors.joining());

    }

    static String twoDigitToWord(String digit) {
        Map<Integer, String> map = getFirstDigitMap();
        String word = "";
        for (int i = 0; i < digit.length(); i++) {
            String temp = digit.charAt(i) + "";
            if (i == 1 && temp.equals("1")) {
                int n = 10 + Integer.parseInt(digit.substring(0, 1));
                word = map.get(n);
            } else if (i == 1) {
                word = map.getOrDefault(Integer.parseInt(temp) * 10, "") + " " + word;
            } else {
                String temp2 = map.get(Integer.valueOf(temp));
                if (!temp2.isEmpty())
                    word = temp2;
            }
        }
        return word;

    }

    static String threeDigitToWord(String digit) {
        Map<Integer, String> map = getFirstDigitMap();
        String twoDigits = digit.substring(0,2);
        String hundredPosition = digit.substring( 2);
        return map.getOrDefault(Integer.parseInt(hundredPosition), "") + " hundred and " + twoDigitToWord(twoDigits);
    }

    static Map<Integer, String> getFirstDigitMap() {
        Map<Integer, String> map = new HashMap<>();
        map.put(0, "");
        map.put(1, "one");
        map.put(2, "two");
        map.put(3, "three");
        map.put(4, "four");
        map.put(5, "five");
        map.put(6, "six");
        map.put(7, "seven");
        map.put(8, "eight");
        map.put(9, "nine");
        map.put(10, "ten");
        map.put(11, "eleven");
        map.put(12, "twelve");
        map.put(13, "thirteen");
        map.put(14, "fourteen");
        map.put(15, "fifteen");
        map.put(16, "sixteen");
        map.put(17, "seventeen");
        map.put(18, "eighteen");
        map.put(19, "nineteen");
        map.put(20, "twenty");
        map.put(30, "thirty");
        map.put(40, "forty");
        map.put(50, "fifty");
        map.put(60, "sixty");
        map.put(70, "seventy");
        map.put(80, "eighty");
        map.put(90, "ninety");

        return map;
    }

    static List<String> getSuffixesListIndian() {
        List<String> list = new ArrayList<>();
        list.add("");
        list.add("hundred");
        list.add("thousand");
        list.add("lakh");
        list.add("crore");
        return list;
    }

    static List<String> getSuffixesListBioinformatic() {
        List<String> list = new ArrayList<>();
        list.add("");
        list.add("hundred");
        list.add("thousand");
        list.add("million");
        list.add("billion");
        list.add("trillion");
        return list;
    }


}