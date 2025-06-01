package com.paremal.sheebu.algorithms;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class PrintDuplicateCharFromWord {
    public static void printDuplicateFromString(String str) {
        String[] strings = str.split("");
        Map<String, Integer> stringIntegerMap = new HashMap<>();
        for (String s : strings) {
            if (stringIntegerMap.containsKey(s)) {
                Integer t = stringIntegerMap.get(s) + 1;
                stringIntegerMap.put(s, t);

            } else {
                stringIntegerMap.put(s, 1);
            }
        }

        stringIntegerMap.entrySet().stream().filter(entry-> entry.getValue()>1).forEach(System.out::println);
    }
    public static void printDuplicateFromStringJava8(String str) {
        Map<String,Integer>  stringIntegerMap=Arrays.stream(str.split("")).collect(Collectors.toMap(Function.identity(),v->1,Integer::sum));
        stringIntegerMap.entrySet().stream().filter(m-> m.getValue()>1).forEach(set->System.out.println("Duplicate "+set.getKey()+" Frequency:"+set.getValue()));
    }
    public static Boolean printWheatherAnagramOfNot(String word1,String word2){
        if(word1.length()!=word2.length()){
            return false;
        }
        if(word1.equals(word2)){
            return false;
        }
        String w1=Arrays.stream(word1.split("")).sorted().collect(Collectors.joining());
        String w2=Arrays.stream(word2.split("")).sorted().collect(Collectors.joining());
        if(w1.equals(w2)) return true;
        else return false;
    }

    public static void main(String[] args) {
        String str = "abcafcb";
        printDuplicateFromStringJava8(str);

        System.out.println(" 'dog' 'dog'  anagram=" + printWheatherAnagramOfNot("dog", "dog"));
        System.out.println(" 'god' 'dog' anagram=" + printWheatherAnagramOfNot("god", "dog"));
        System.out.println(" 'mary' 'army' anagram=" + printWheatherAnagramOfNot("mary", "army"));
        System.out.println(" 'army' 'army' anagram=" + printWheatherAnagramOfNot("army", "army"));

    }
}
