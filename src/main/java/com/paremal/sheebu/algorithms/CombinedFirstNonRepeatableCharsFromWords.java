package com.paremal.sheebu.algorithms;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * This class provides functionality to find the first non-repeatable character from each word in a list
 * and combine them into a single word.
 */
public class CombinedFirstNonRepeatableCharsFromWords {

    /**
     * Main method to demonstrate the functionality of the class.
     * @param args Command-line arguments (not used).
     */
    public static void main(String[] args) {
        List<String> wordList=List.of("apple","orange","grape","banana");
        CombinedFirstNonRepeatableCharsFromWords cfnc= new CombinedFirstNonRepeatableCharsFromWords();
        System.out.println(cfnc.combinedNonRepeatable(wordList));
    }

    /**
     * Combines the first non-repeatable characters from each word in the given list into a single word.
     * @param wList List of words to process.
     * @return A string formed by combining the first non-repeatable characters of each word.
     */
    public String combinedNonRepeatable1(List<String> wList){
        return wList.stream().map( w->{
            Optional<Map.Entry<String,Integer>> ome= Stream.of(w.split(""))
                    .collect(Collectors.toMap(Function.identity(),v->1,Integer::sum, LinkedHashMap::new))
                    .entrySet().stream()
                    .filter(me-> me.getValue()==1)
                    .findFirst();
           return ome.isPresent() ? ome.get().getKey():"";
        }).collect(Collectors.joining());
    }

    /**
     * Combines the first non-repeatable characters from each word in the given list into a single word.
     * @param wList List of words to process.
     * @return A string formed by combining the first non-repeatable characters of each word.
     */
    public String combinedNonRepeatable(List<String> wList) {
        if (wList == null || wList.isEmpty()) return "";

        return wList.stream()
                .map(word -> getFirstNonRepeatable(word))
                .collect(Collectors.joining());
    }

    /**
     * Finds the first non-repeatable character in the given word.
     * @param word The word to process.
     * @return The first non-repeatable character as a string, or an empty string if none exists.
     */
    private String getFirstNonRepeatable(String word) {
        if (word == null || word.isEmpty()) return "";

        Map<Character, Integer> freqMap = new LinkedHashMap<>();
        for (char c : word.toCharArray()) {
            freqMap.put(c, freqMap.getOrDefault(c, 0) + 1);
        }

        return freqMap.entrySet().stream()
                .filter(e -> e.getValue() == 1)
                .map(e -> String.valueOf(e.getKey()))
                .findFirst()
                .orElse("");
    }

}
