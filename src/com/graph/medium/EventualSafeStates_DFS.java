package com.graph.medium;

import java.util.*;

public class EventualSafeStates_DFS {
    public static void main(String[] args) {
        int[][] graph = {
                {1, 2},
                {2, 3},
                {5},
                {0},
                {5},
                {},
                {}
        };

        List<Integer> result = solve(graph);
        System.out.println(result);
    }

    private static List<Integer> solve(int[][] graph) {
        int V = graph.length;
        int[] vis = new int[V];
        int[] pathVis = new int[V];

        int[] check = new int[V];

        for (int i = 0; i < V; i++) {
            if (vis[i] == 0)
                dfs(i, vis, pathVis, graph, check);
        }

        List<Integer> safeNodes = new ArrayList<>();
        for (int i = 0; i < check.length; i++) {
            if (check[i] == 1)
                safeNodes.add(i);
        }

        return safeNodes;
    }

    private static boolean dfs(int node, int[] vis, int[] pathVis, int[][] graph, int[] check) {
        vis[node] = 1;
        pathVis[node] = 1;
//        check[node] = 0;

        for (int it : graph[node]) {
            if (vis[it] == 0) {
                if (dfs(it, vis, pathVis, graph, check)) {
                    check[node] = 0;
                    return true;
                }
            } else if (pathVis[it] == 1) {
                check[node] = 0;
                return true;
            }
        }

        check[node] = 1;
        pathVis[node] = 0;

        return false;
    }

}
