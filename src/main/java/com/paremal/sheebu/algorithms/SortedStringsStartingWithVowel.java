package com.paremal.sheebu.algorithms;

import java.util.*;
import java.util.function.Function;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class SortedStringsStartingWithVowel {
    public static void main(String[] args) {
        orderedStringsStartingWithVowel(List.of("india", "one", "upset", "abstract", "elephant", "Arrogant", "out"))
                .entrySet().forEach(s -> System.out.println(s.getKey() + " " + s.getValue()));
        System.out.println(combinedfirstNonrepeatableCharacters(List.of("absolutea", "defdinite", "sadsa")));
    }

    static Map<String, Integer> orderedStringsStartingWithVowel(List<String> strings) {
        return strings.stream().filter(s ->
                        s.matches("(?i)^[aeiou].*")
                ).collect(Collectors.toMap(s -> s.substring(0, 1).toLowerCase(), s -> 1, Integer::sum))
                .entrySet().stream()
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue))
                .entrySet().stream().sorted(Map.Entry.comparingByKey())
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (me1, me2) -> me1, LinkedHashMap::new));


    }


    static Map<String, Integer> getOrderedStringsStartingWithVowel1(List<String> strings) {
        return strings.stream().filter(s -> s.matches("(?i)^[aeiouAEIOU].*"))
                .collect(Collectors.toMap(s -> s.substring(0, 1).toLowerCase(), s -> 1, Integer::sum))
                .entrySet().stream().sorted(Map.Entry.comparingByKey())
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
                        (me1, me2) -> me1, LinkedHashMap::new));
    }

    static String combinedfirstNonrepeatableCharacters(List<String> ststrlistr) {
        return ststrlistr.stream().map(w -> {
            Optional<Map.Entry<String,Integer>> ome= Stream.of(w.split(""))
                    .collect(Collectors.toMap(Function.identity(), v -> 1, Integer::sum, LinkedHashMap::new))
                    .entrySet().stream().filter(me -> me.getValue() == 1)
                    .findFirst();
           return ome.isPresent() ? ome.get().getKey() : "";
        }).collect(Collectors.joining());

    }
}
