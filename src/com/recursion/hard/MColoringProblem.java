package com.recursion.hard;

import java.util.ArrayList;
import java.util.List;

public class MColoringProblem {
    public static void main(String[] args) {
        int[][] graph = {
                {0, 1},
                {1, 2},
                {2, 3},
                {3, 0},
                {0, 2}
        };
        int m = 3;
        int n = 4;

        boolean result = solve(graph, m, n);
        System.out.println(result);
    }

    private static boolean solve(int[][] graph, int m, int n) {
        int[] color = new int[n];
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++)
            adj.add(new ArrayList<>());

        for (int[] rows : graph) {
            adj.get(rows[0]).add(rows[1]);
            adj.get(rows[1]).add(rows[0]);
        }

        return solve(adj, color, 0, m, n);
    }

    private static boolean solve(List<List<Integer>> adj, int[] color, int node, int m, int n) {
        if (node == n) return true;

        for (int i = 1; i <= m; i++) {
            if (isSafe(node, adj, color, i)) {
                color[node] = i;
                if (solve(adj, color, node + 1, m, n)) return true;
                color[node] = 0;
            }
        }
        return false;
    }

    private static boolean isSafe(int node, List<List<Integer>> adj, int[] color, int i) {
        for (int it : adj.get(node)) {
            if (color[it] == i) return false;
        }
        return true;
    }
}
