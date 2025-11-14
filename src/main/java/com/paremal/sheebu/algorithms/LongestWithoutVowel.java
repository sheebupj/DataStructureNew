package com.paremal.sheebu.algorithms;

import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Stream;

public class LongestWithoutVowel {
    public static void main(String[] args) {
        LongestWithoutVowel longestWithoutVowel= new LongestWithoutVowel();
        String[] words={"ada",
                "xyz",
                "absolute",
                "arithmetic1",
                "bcdfghjklm",
                "aithmatic-expression"};
        System.out.println();
        System.out.println(longestWithoutVowel.findLongestStringWithoutvowels(words));

    }

    public String findLongestStringWithoutvowels(String[] words) {
        String regex="[aeiouAEIOU]";
        Pattern pattern=Pattern.compile(regex);
        Optional<String> result=Stream.of(words).filter(w->{
            Matcher matcher= pattern.matcher(w);
            return !matcher.find()? true:false;
        }).reduce((w1,w2)-> w1.length()>w2.length() ? w1:w2);
        return result.orElse("");
    }
}
