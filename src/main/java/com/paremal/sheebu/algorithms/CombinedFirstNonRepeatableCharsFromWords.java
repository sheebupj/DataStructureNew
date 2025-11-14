package com.paremal.sheebu.algorithms;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CombinedFirstNonRepeatableCharsFromWords {
    public static void main(String[] args) {
        List<String> wordList=List.of("apple","orange","grape","banana");
        CombinedFirstNonRepeatableCharsFromWords cfnc= new CombinedFirstNonRepeatableCharsFromWords();
        System.out.println(cfnc.combinedNonRepeatable(wordList));
    }
    /*
    find first non-repeatable character from each word in a list and combine them to a word
     */
    public String combinedNonRepeatable(List<String> wList){
        return wList.stream().map( w->{
            Optional<Map.Entry<String,Integer>> ome= Stream.of(w.split(""))
                    .collect(Collectors.toMap(Function.identity(),v->1,Integer::sum, LinkedHashMap::new))
                    .entrySet().stream()
                    .filter(me-> me.getValue()==1)
                    .findFirst();
           return ome.isPresent() ? ome.get().getKey():"";
        }).collect(Collectors.joining());
    }
}
