package com.paremal.sheebu.algorithms;

import java.util.*;

public class MaxSubTree {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Deque<Integer> deque = new ArrayDeque<>();
        int n = in.nextInt();
        int m = in.nextInt();
        List<Integer> nlist= new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int num = in.nextInt();
            nlist.add(num);
        }
        maxUnique(nlist, n, m);

    }
    static void maxUnique(List<Integer> numList, int n, int m) {
        HashMap<Integer, Integer> map = new HashMap<>();
        long maxUnique = 0;
        for (int i = 0; i < m; i++) {
            int num = numList.get(i);
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        maxUnique = map.size();
        for (int i = m; i < numList.size(); i++) {
            int oldNum = numList.get(i - m);
            if (map.get(oldNum) == 1) {
                map.remove(oldNum); // Remove completely if count is 0
            } else {
                map.put(oldNum, map.get(oldNum) - 1); // Decrement count
            }
            int newNum = numList.get(i);
            map.put(newNum, map.getOrDefault(newNum, 0) + 1);
            maxUnique = Math.max(maxUnique, map.size());
        }
        System.out.println(maxUnique);
    }
}

