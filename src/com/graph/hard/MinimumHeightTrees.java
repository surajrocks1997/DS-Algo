package com.graph.hard;

import java.util.*;

public class MinimumHeightTrees {
    public static void main(String[] args) {
        int n = 6;
        int[][] edges = {
                {3, 0},
                {3, 1},
                {3, 2},
                {3, 4},
                {5, 4}
        };

        List<Integer> result = solve(n, edges);
        System.out.println(result);
    }

    private static List<Integer> solve(int n, int[][] edges) {
        if (n == 1) return new ArrayList<>(Collections.singletonList(0));
        List<List<Integer>> adj = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }

        Queue<Integer> leafQueue = new LinkedList<>();
        Map<Integer, Integer> map = new HashMap<>();    //node, len(node)

        for (int i = 0; i < n; i++) {
            if (adj.get(i).size() == 1)
                leafQueue.add(i);
            map.put(i, adj.get(i).size());
        }

        while (!leafQueue.isEmpty()) {
            if (n <= 2)
                return leafQueue.stream().toList();

            int size = leafQueue.size();
            for (int i = 0; i < size; i++) {
                int node = leafQueue.poll();
                n--;
                for (int it : adj.get(node)) {
                    map.put(it, map.getOrDefault(it, 1) - 1);
                    if (map.get(it) == 1)
                        leafQueue.add(it);
                }
            }

        }

        return new ArrayList<>();
    }
}
