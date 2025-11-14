package com.paremal.sheebu.algorithms;

import java.util.ArrayList;
import java.util.List;

public class FindStringPositionsInSentence {
    public static void main(String[] args) {
        FindStringPositionsInSentence fInstance=new FindStringPositionsInSentence();
        String str="The graphic and.";
        System.out.println(fInstance.findWordPositions(str,"and"));

    }
    List<Integer> findWordPositions(String str, String find){
        List<Integer> result=new ArrayList<>();
        int index=0,start=0;
        while(index>=0){
            index=str.indexOf(find,start);
            if(index<0) break;
            result.add(index);
            start=index+1;
        }
        return result;
    }

}
