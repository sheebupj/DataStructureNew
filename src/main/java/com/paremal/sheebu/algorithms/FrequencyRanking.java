package com.paremal.sheebu.algorithms;

import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FrequencyRanking {
    public static void main(String[] args) {
        Integer[] ints={1,3,6,4,2,1,9,3,5,1,8,3,8,5,6,3,2,0,6,4,2,7,9,3,2,1};
        Integer[] ints1={0,1,2,3,4,5,6,0,1,0,2,0,1,0,5,1,0,2,4};
        FrequencyRanking ranking= new FrequencyRanking();
        Map<Integer,Integer> first=ranking.frequencyRankingFromTo(ints,2,3);
        Map<Integer,Integer> second=ranking.frequencyRankingFromTo(ints1,1,4);
        first.entrySet().forEach(me-> System.out.println(me.getKey()+":"+me.getValue()));
        System.out.println();
        second.entrySet().forEach(me-> System.out.println(me.getKey()+":"+me.getValue()));
    }
    public Map<Integer, Integer> frequencyRankingFromTo(Integer[] ints, int fromRank, int numbers) {
        return Stream.of(ints).collect(Collectors.toMap(Function.identity(), v->1,Integer::sum))
                .entrySet().stream().sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .collect(Collectors.toMap(Map.Entry::getKey,Map.Entry::getValue, (me1,me2)-> me1, LinkedHashMap::new))
                .entrySet().stream().skip(fromRank-1).limit(numbers)
                .collect(Collectors.toMap(Map.Entry::getKey,Map.Entry::getValue,(m1,m2)-> m1,LinkedHashMap::new));
    }
}
