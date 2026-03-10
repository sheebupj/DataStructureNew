package com.paremal.sheebu.algorithms;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * This class provides functionality to convert numeric digits into their word representations
 * in both Indian numbering system (lakhs and crores) and Western numbering system (millions and billions).
 *
 * @author Sheebu P J
 */
public class DigitsToWords {
    /**
     * Main method to demonstrate the digit to word conversion functions.
     *
     * @param args command line arguments (not used)
     */
    public static void main(String[] args) {
        System.out.println(digitToWordIndian("1234567890"));
        System.out.println(digitToWordIndian("100000000"));
        System.out.println(digitToWordIndian("7777777"));
        System.out.println(digitToWordMillionBillionFormat("123456789"));
        System.out.println(digitToWordMillionBillionFormat("100000000000000000"));
        System.out.println(
                digitToWordMillionBillionFormat("1543210123456789123"));
        System.out.println(digitToWordMillionBillionFormat("11000"));
        System.out.println(digitToWordMillionBillionFormat("1000"));
        System.out.println(digitToWordMillionBillionFormat("1000000"));
        System.out.println(digitToWordMillionBillionFormat("1000000000"));
        System.out.println(digitToWordMillionBillionFormat("1000000000000"));
        System.out.println(digitToWordMillionBillionFormat("1000000000000000"));
        System.out.println(digitToWordMillionBillionFormat("1000000000000000000"));
    }
    /**
     * Converts a string of digits to words using the Indian numbering system (lakhs and crores).
     * Supports up to 9 digits.
     *
     * @param digits the string representation of the number
     * @return the word representation of the number or an error message if input is too long
     */
    public  static String digitToWordIndian(String digits) {
        //String digits = digit + "";
        if (digits.length() > 9) return "maximum allowed digits is 9 and current input is " + digits.length();
        List<String> list = getSplitDigitsIndian(reverse(digits));
        List<String> suffixes = getSuffixesListIndian();
        StringBuilder wordDigits = new StringBuilder();
        for (int i = list.size() - 1; i >= 0; i--) {
            if(Integer.parseInt(list.get(i))>0) {
                if (i == 0)
                    wordDigits.append(" and ").append(twoDigitToWord(list.get(i))).append(" ").append(suffixes.get(i));
                else wordDigits.append(twoDigitToWord(list.get(i))).append(" ").append(suffixes.get(i)).append(" ");
            }
        }
        return wordDigits.toString();

    }

   /**
    * Converts a string of digits to words using the Western numbering system (millions, billions, etc.).
    * Supports up to 21 digits.
    *
    * @param digits the string representation of the number
    * @return the word representation of the number or an error message if input is too long
    */
   public static String digitToWordMillionBillionFormat(String digits) {
        //String digits = digit + "";
        if (digits.length() > 21)
            return "max digits allowed is 21 and  current input contains " + digits.length() + " digits";
        List<String> list = getSplitDigitsMillionBillionFormat(reverse(digits));
        List<String> suffixes = getSuffixesListMillionBillionFormat();
        StringBuilder wordDigits = new StringBuilder();
        for (int i = list.size() - 1; i >= 0; i--) {
            if (Integer.parseInt(list.get(i)) > 0) {
                if (i == 0)
                    wordDigits.append(" and ").append(twoDigitToWord(list.get(i))).append(" ").append(suffixes.get(i));
                else if (i == 1)
                    wordDigits.append(twoDigitToWord(list.get(i))).append(" ").append(suffixes.get(i)).append(" ");
                else {
                    if (list.get(i).length() > 2)
                        wordDigits.append(threeDigitToWord(list.get(i))).append(" ").append(suffixes.get(i)).append(" ");
                    else
                        wordDigits.append(twoDigitToWord(list.get(i))).append(" ").append(suffixes.get(i)).append(" ");
                }
            }
        }
        return wordDigits.toString();
    }


    /**
     * Splits the reversed digits into groups for Indian numbering system.
     *
     * @param digits the reversed string of digits
     * @return list of digit groups
     */
    static List<String> getSplitDigitsIndian(String digits) {
        List<Integer[]> splitPositions = getSplittingPositionsIndian();
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
     * Splits the reversed digits into groups for Western numbering system.
     *
     * @param digits the reversed string of digits
     * @return list of digit groups
     */
    static List<String>  getSplitDigitsMillionBillionFormat(String digits) {
        List<Integer[]> splitPositions = getSplittingPositionsWesternFormat();
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

    /**
     * Converts a two-digit string to its word representation.
     *
     * @param digit the two-digit string
     * @return the word representation
     */
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

    /**
     * Converts a three-digit string to its word representation.
     *
     * @param digit the three-digit string
     * @return the word representation
     */
    static String threeDigitToWord(String digit) {
        Map<Integer, String> map = getFirstDigitMap();
        String twoDigits = digit.substring(0, 2);
        String hundredPosition = digit.substring(2);
        return map.getOrDefault(Integer.parseInt(hundredPosition), "") + " hundred  " + twoDigitToWord(twoDigits);
    }

    /**
     * Returns a map of numbers to their word representations.
     *
     * @return map from integer to string
     */
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

    /**
     * Returns the splitting positions for Indian numbering system.
     *
     * @return list of integer arrays representing start and end positions
     */
    static List<Integer[]> getSplittingPositionsIndian() {
        List<Integer[]> list = new ArrayList<>();
        list.add(new Integer[]{0, 2});
        list.add(new Integer[]{2, 3});
        list.add(new Integer[]{3, 5});
        list.add(new Integer[]{5, 7});
        list.add(new Integer[]{7, 9});
        return list;
    }

    /**
     * Returns the splitting positions for Western numbering system.
     *
     * @return list of integer arrays representing start and end positions
     */
    static List<Integer[]> getSplittingPositionsWesternFormat() {
        List<Integer[]> list = new ArrayList<>();
        list.add(new Integer[]{0, 2});
        list.add(new Integer[]{2, 3});
        list.add(new Integer[]{3, 6});
        list.add(new Integer[]{6, 9});
        list.add(new Integer[]{9, 12});
        list.add(new Integer[]{12, 15});
        list.add(new Integer[]{15, 18});
        list.add(new Integer[]{18, 21});
        return list;
    }


    /**
     * Returns the list of suffixes for Indian numbering system.
     *
     * @return list of suffix strings
     */
    static List<String> getSuffixesListIndian() {
        List<String> list = new ArrayList<>();
        list.add("");
        list.add("hundred");
        list.add("thousand");
        list.add("lakh");
        list.add("crore");
        return list;
    }

    /**
     * Returns the list of suffixes for Western numbering system.
     *
     * @return list of suffix strings
     */
    static List<String> getSuffixesListMillionBillionFormat() {
        List<String> list = new ArrayList<>();
        list.add("");
        list.add("hundred");
        list.add("thousand");
        list.add("million");
        list.add("billion");
        list.add("trillion");
        list.add("quadrillion");
        list.add("quintillion");
        return list;
    }


}