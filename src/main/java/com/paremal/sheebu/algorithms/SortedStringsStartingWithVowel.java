package com.paremal.sheebu.algorithms;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class SortedStringsStartingWithVowel {
    public static void main(String[] args) {
        orderedStringsStartingWithVowel(List.of("india", "one", "upset", "abstract", "elephant", "Arrogant", "out"))
                .entrySet().forEach(s -> System.out.println(s.getKey() + " " + s.getValue()));

    }

    static Map<String, Integer> orderedStringsStartingWithVowel(List<String> strings) {
        return strings.stream().filter(s ->
                        s.matches("(?i)^[aeiou].*"))
                .collect(Collectors.toMap(s -> s.substring(0, 1)
                        .toLowerCase(), s -> 1, Integer::sum))
                .entrySet().stream()
                              .sorted(Map.Entry.comparingByKey())
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
                        (me1, me2) -> me1, LinkedHashMap::new));
    }
}
