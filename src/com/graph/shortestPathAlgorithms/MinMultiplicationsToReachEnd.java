package com.graph.shortestPathAlgorithms;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class MinMultiplicationsToReachEnd {
    public static void main(String[] args) {
        int[] arr = {2, 5, 7};
        int start = 3;
        int end = 30;

        int result = solve(arr, start, end);
        System.out.println(result);
    }

    private static int solve(int[] arr, int start, int end) {
        if (start == end) return 0;
        Queue<Pair_ShortestPathWeightedUndirectedGraph> queue = new LinkedList<>();
        queue.add(new Pair_ShortestPathWeightedUndirectedGraph(start, 0));

        int[] distance = new int[(int) 1e5];
        Arrays.fill(distance, (int) 1e9);

        distance[start] = 0;
        int mod = (int) 1e5;

        while (!queue.isEmpty()) {
            Pair_ShortestPathWeightedUndirectedGraph pair = queue.poll();
            int node = pair.first;
            int steps = pair.second;
            for (int i = 0; i < arr.length; i++) {
                int num = (node * arr[i]) % mod;

                if (steps + 1 < distance[num]) {
                    distance[num] = steps + 1;

                    if (num == end) return steps + 1;
                    queue.add(new Pair_ShortestPathWeightedUndirectedGraph(num, steps + 1));
                }
            }
        }
        return -1;
    }
}
