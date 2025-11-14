package com.paremal.sheebu.algorithms;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class FindSubStringIndexesInA_String {
    /*
    Find indexs of substring in a String
     */
    static Optional<List<Integer>> findIndexes(String str, String subStr){
        List<Integer> indexList= new ArrayList<>();
        int i=0;
        while(i!=-1){
            i=str.indexOf(subStr,i);
            if(i!=-1)  indexList.add(i);
            else break;
            i++;
        }
        return !indexList.isEmpty() ? Optional.of(indexList):Optional.empty();
    }
}
