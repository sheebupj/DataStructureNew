package com.paremal.sheebu.algorithms;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;
/*
Given five positive integers, find the minimum and maximum values that can be calculated by summing exactly four of the five integers.
Then print the respective minimum and maximum values as a single line of two space-separated long integers.

Example
arr=[1,3,5,7,9]

The minimum sum is 1+3+5+7+9=16  and the maximum sum is 3+5+7+9=24 .
The function prints 16  24
min and max separated by 2 spaces


 */
public class MinMax {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        MinMax.miniMaxSum(arr);

        bufferedReader.close();
    }



    /*
     * Complete the 'miniMaxSum' function below.
     *
     * The function accepts INTEGER_ARRAY arr as parameter.
     */

    public static void miniMaxSum(List<Integer> arr) {
        int size = arr.size();
        List<Long> sumList = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            long tsum = 0;
            for (int j = 0; j < size; j++) {
                if (j == i) continue;
                tsum = tsum + arr.get(j);

            }
            sumList.add(tsum);

        }
        long min = sumList.get(0), max = min;
        for (long tval : sumList) {
            if (tval < min) min = tval;
            if (tval > max) max = tval;
        }
        System.out.println(min + "  " + max);


    }
}




