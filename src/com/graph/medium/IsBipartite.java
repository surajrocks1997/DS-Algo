package com.graph.medium;

import java.util.Arrays;

public class IsBipartite {
    public static void main(String[] args) {
        int[][] graph = {
                {1, 2, 3},
                {0, 2},
                {0, 1, 3},
                {0, 2}
        };

        boolean result = solve(graph);
        System.out.println(result);
    }

    private static boolean solve(int[][] graph) {
        int V = graph.length;

        int[] color = new int[V];
        Arrays.fill(color, -1);

        for (int i = 0; i < V; i++) {
            if (color[i] == -1) {
                if (!dfs(i, 0, color, graph)) return false;
            }
        }
        return true;
    }

    private static boolean dfs(int node, int col, int[] color, int[][] graph) {
        color[node] = col;

        for (int it : graph[node]) {
            if (color[it] == -1) {
                if (!dfs(it, 1 - col, color, graph)) return false;
            } else if (color[it] == col) return false;
        }

        return true;
    }
}
