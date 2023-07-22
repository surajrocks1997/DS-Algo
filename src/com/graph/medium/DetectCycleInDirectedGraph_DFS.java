package com.graph.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class DetectCycleInDirectedGraph_DFS {
    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        ArrayList<Integer> temp = new ArrayList<>(Collections.emptyList());
        adj.add(temp);
        temp = new ArrayList<>(Collections.singletonList(2));
        adj.add(temp);
        temp = new ArrayList<>(Collections.singletonList(3));
        adj.add(temp);
        temp = new ArrayList<>(Arrays.asList(4, 7));
        adj.add(temp);
        temp = new ArrayList<>(Collections.singletonList(5));
        adj.add(temp);
        temp = new ArrayList<>(Collections.singletonList(6));
        adj.add(temp);
        temp = new ArrayList<>(Collections.emptyList());
        adj.add(temp);
        temp = new ArrayList<>(Collections.singletonList(5));
        adj.add(temp);
        temp = new ArrayList<>(Arrays.asList(2, 9));
        adj.add(temp);
        temp = new ArrayList<>(Collections.singletonList(10));
        adj.add(temp);
        temp = new ArrayList<>(Collections.singletonList(8));
        adj.add(temp);

        int V = adj.size();

        boolean result = solve(adj, V);
        System.out.println(result);
    }

    private static boolean solve(ArrayList<ArrayList<Integer>> adj, int V) {
        int[] vis = new int[V];
        int[] pathVisited = new int[V];

        for (int i = 0; i < V; i++) {
            if (vis[i] == 0)
                if (dfs(i, vis, pathVisited, adj)) return true;
        }

        return false;
    }

    private static boolean dfs(int node, int[] vis, int[] pathVisited, ArrayList<ArrayList<Integer>> adj) {
        vis[node] = 1;
        pathVisited[node] = 1;

        for (int it : adj.get(node)) {
            if (vis[it] == 0) {
                if (dfs(it, vis, pathVisited, adj)) return true;
            } else if (pathVisited[it] == 1) return true;
        }

        pathVisited[node] = 0;

        return false;
    }
}
