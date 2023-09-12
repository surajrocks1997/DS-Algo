package com.heap;

import java.util.PriorityQueue;

public class HandOfStraights {
    public static void main(String[] args) {
        int[] hands = {1, 2, 3, 6, 2, 3, 4, 7, 8};
        int groupSize = 3;

        boolean result = solve(hands, groupSize);
        System.out.println(result);
    }

    private static boolean solve(int[] hands, int groupSize) {
        if (hands.length % groupSize != 0) return false;

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int ele : hands) pq.add(ele);

        while (!pq.isEmpty()) {
            int head = pq.poll();

            for (int i = 1; i < groupSize; i++) {
                if (!pq.remove(head + i)) return false;
            }
        }
        return true;
    }
}
