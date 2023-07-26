package com.graph.shortestPathAlgorithms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class ShortestPathUndirectedGraphUnitDistance {
    public static void main(String[] args) {
        int[][] edges = {
                {0, 1},
                {0, 3},
                {3, 4},
                {4, 5},
                {5, 6},
                {1, 2},
                {2, 6},
                {6, 7},
                {7, 8},
                {6, 8}
        };
        int n = 9;
        int m = 10;
        int src = 0;

        int[] result = solve(edges, n, m, src);
        for (int ele : result)
            System.out.print(ele + " ");
    }

    private static int[] solve(int[][] edges, int n, int m, int src) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            adj.get(edges[i][0]).add(edges[i][1]);
            adj.get(edges[i][1]).add(edges[i][0]);
        }

        int[] distance = new int[n];
        Arrays.fill(distance, (int) 1e9);

        distance[src] = 0;
        Queue<Integer> queue = new LinkedList<>();
        queue.add(src);

        while (!queue.isEmpty()) {
            int node = queue.poll();
            for (int it : adj.get(node)) {
                if (distance[node] + 1 < distance[it]) {
                    distance[it] = 1 + distance[node];
                    queue.add(it);
                }
            }
        }

        for (int i = 0; i < n; i++)
            if (distance[i] == (int) 1e9)
                distance[i] = -1;

        return distance;
    }
}
