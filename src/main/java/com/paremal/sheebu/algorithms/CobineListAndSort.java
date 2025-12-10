package com.paremal.sheebu.algorithms;

import java.util.Collection;
import java.util.List;
import java.util.stream.Stream;

public class CobineListAndSort {
    public static void main(String[] args) {
        Integer[][] twodInts = {{11, 214, -5}, {-31, 443, 24}, {42, -96}, {1, 4, 5}, {1, 3, 4}, {2, 6}};
        System.out.println(getCombinedSortedList(twodInts));
    }

    public static List<Integer> getCombinedSortedList(Integer[][] twoDints) {
        /* first convert two-dimensional array to List of List, then combine List fo lIst to single list
        using stream and flatmap, and sort it to a list of Integers
         */
        return Stream.of(twoDints)
                .map(l -> Stream.of(l).
                        toList())//converting each array to list
                .toList()//make it to list of list
                .stream()
                .flatMap(Collection::stream)//convert each list to stream and flatmap it to single stream
                .sorted()
                .toList();
    }

}
