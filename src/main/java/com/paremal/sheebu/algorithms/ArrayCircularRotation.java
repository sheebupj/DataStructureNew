package com.paremal.sheebu.algorithms;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.stream.Stream;

public class ArrayCircularRotation {
    public static int[] circularRotation(int[] nos, int k) {
        int n = nos.length;
        k %= n; // Optimize k to avoid unnecessary rotations
        if (k == 0) return nos; // No rotation needed

        int[] result = new int[n];
        System.arraycopy(nos, n - k, result, 0, k); // Copy last k elements to the start
        System.arraycopy(nos, 0, result, k, n - k); // Copy the rest to the end

        return result;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("input numbers for  circular rotation:");
        int[] inputs = Stream.of(br.readLine()
                        .replaceAll("\\s+$", "")
                        .split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();
        System.out.println("input no of movement times:");
        int k=Integer.parseInt(br.readLine().trim());
        int[] result=circularRotation(inputs, k);
        for(int i:result){
            System.out.print(i+" ");
        }
    }


}
