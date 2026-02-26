package com.paremal.sheebu.data_structure.Dqueue;

import java.util.*;

public class MaxUniqueNumbersSubArray {

        public static void main(String[] args) {
            Scanner in = new Scanner(System.in);
            Deque deque = new ArrayDeque<>();
            int n = in.nextInt();
            int m = in.nextInt();
            List<Integer> nlist= new LinkedList<>();
            for (int i = 0; i < n; i++) {
                int num = in.nextInt();
                nlist.add(num);
            }
            maxUnique(nlist,n,m);
        }
        static void maxUnique(List<Integer> numList, int n, int m) {
        // Map to store frequency of numbers in the current window
        HashMap<Integer, Integer> map = new HashMap<>();
        long maxUnique = 0;

        // 1. Initialize the first window (first m elements)
        for (int i = 0; i < m; i++) {
            int num = numList.get(i);
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        // Initial max
        maxUnique = map.size();

        // 2. Slide the window from m to n
        for (int i = m; i < numList.size(); i++) {

            // ELEMENT LEAVING THE WINDOW (at index i - m)
            int oldNum = numList.get(i - m);
            if (map.get(oldNum) == 1) {
                map.remove(oldNum); // Remove completely if count is 0
            } else {
                map.put(oldNum, map.get(oldNum) - 1); // Decrement count
            }

            // ELEMENT ENTERING THE WINDOW (at index i)
            int newNum = numList.get(i);
            map.put(newNum, map.getOrDefault(newNum, 0) + 1);

            // Update max unique count
            maxUnique = Math.max(maxUnique, map.size());
        }

        System.out.println(maxUnique);
    }

}
