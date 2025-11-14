package com.paremal.sheebu.algorithms;

import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FilterSort {
     record KeyValue(String str,Long val){}
    public static void main(String[] args) {
        String[] strArray = {"POINT,2342342", "POINTS,2341345", "OF,34534345", "VIEWS,2342342223423", "IS,432234", "QWERTY,234234222"};
        FilterSort filterSort=new FilterSort();
        System.out.println(filterSort.filterBasedOn1partSortBased2part(strArray));
        System.out.println(filterSort.filterBasedOn1partSortBased2part1(strArray));


            long t1=System.currentTimeMillis();
            for(int i=1;i<=10000000;i++)filterSort.filterBasedOn1partSortBased2part1(strArray);
            long t2=System.currentTimeMillis();
            System.out.println((t2-t1));


            long t3=System.currentTimeMillis();
            for(int i=1;i<=10000000;i++)filterSort.filterBasedOn1partSortBased2part(strArray);
            long t4=System.currentTimeMillis();
            System.out.println((t4-t3));







    }

    /*
    Given the array of strings. Each string contains two parts - Word and its count separated by comma(,):

    - Filter by word(1st part) length > 4

    - Sort by word count(2nd part) desc

    - Find 2nd highest word based on above sorted result

    Solve using Java Streams API

    String[] strArray = {"POINT,2342342", "POINTS,2341345", "OF,34534345", "VIEWS,2342342223423", "IS,432234", "QWERTY,234234222"};

    Output: QWERTY
     */
    String filterBasedOn1partSortBased2part(String[] strArray){
        Optional<Map.Entry<String,Long>> optME=Stream.of(strArray)
                .map(str-> str.split(","))
                .filter(sArr-> sArr[0].length()>4 )
                .collect(Collectors
                        .toMap(sArr-> sArr[0], sArr-> Long.valueOf(sArr[1]),
                                (me1,me2)-> me1, LinkedHashMap::new))
                .entrySet().stream().sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .skip(1).findFirst();
        return optME.isPresent() ? optME.get().getKey():"";
    }
    String filterBasedOn1partSortBased2part1(String[] strArray){
        Optional<KeyValue> optKV=Stream.of(strArray)
                .map(strs-> strs.split(","))
                .map(strs-> new KeyValue(strs[0],Long.valueOf(strs[1])))
                .filter(kv-> kv.str.length()>4)
                .sorted(Comparator.comparing(KeyValue::val).reversed())
                .skip(1)
                .findFirst();
        return optKV.isPresent() ? optKV.get().str:"";
    }
}

