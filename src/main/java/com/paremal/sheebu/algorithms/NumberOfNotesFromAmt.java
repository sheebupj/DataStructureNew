package com.paremal.sheebu.algorithms;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;

public class NumberOfNotesFromAmt {
    public static void main(String[] args) throws InterruptedException {

        Map<Integer,Integer> notesMap=getNumberOfNotesFrAmt(2888);
        notesMap.forEach((key, value) -> System.out.println(key + ": " + value));
        Map<Integer,Integer> notesMap1=getNumberOfNotesFrAmtStream(2888);
        notesMap1.forEach((key, value) -> System.out.println(key + ": " + value));

    }

    static Map<Integer,Integer> getNumberOfNotesFrAmt(Integer amt){
        Map<Integer,Integer> notesMap=getNotesMap();
        Integer value, noteCount;
        Map<Integer,Integer> result= new LinkedHashMap<>();
        for(Map.Entry<Integer,Integer> noteEntry:notesMap.entrySet()) {
            value = noteEntry.getValue();
            if (amt >= value) {
                noteCount = amt / value;
                result.put(value, noteCount);
                amt = amt - (noteCount * value);
            }
        }
        return result;
    }
    static Map<Integer,Integer> getNumberOfNotesFrAmtStream(Integer amt){
        Map<Integer,Integer> notesMap=getNotesMap();
        AtomicInteger atmicAmt= new AtomicInteger(amt);
        Map<Integer,Integer> result= new LinkedHashMap<>();
        int len= notesMap.entrySet().size();
        IntStream.iterate(0,i->i<len,i-> i=i+1)
                .forEach(i->{
                  Integer value=notesMap.get(i);
                    if (atmicAmt.get() >= value) {
                         int noteCount = atmicAmt.get() / value;
                        result.put(value, noteCount);
                        atmicAmt.set( atmicAmt.get() - (noteCount * value));
                    }
                });
        return result;
    }
    private static Map<Integer, Integer> getNotesMap() {
        Map<Integer,Integer> notesMap= new LinkedHashMap<>();
        notesMap.put(0,2000);
        notesMap.put(1,500);
        notesMap.put(2,200);
        notesMap.put(3,100);
        notesMap.put(4,50);
        notesMap.put(5,20);
        notesMap.put(6,10);
        notesMap.put(7,5);
        notesMap.put(8,2);
        notesMap.put(9,1);
        return  notesMap;
    }
}
