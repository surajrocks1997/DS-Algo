package com.graph.traversal;

import java.util.*;

public class DFS_Graph {
    public static void main(String[] args) {
        int V = 5;
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        ArrayList<Integer> temp = new ArrayList<>(Arrays.asList(1, 2, 3));
        adj.add(temp);
        temp = new ArrayList<>(Collections.emptyList());
        adj.add(temp);
        temp = new ArrayList<>(Collections.singletonList(4));
        adj.add(temp);
        temp = new ArrayList<>(Collections.emptyList());
        adj.add(temp);
        temp = new ArrayList<>(Collections.emptyList());
        adj.add(temp);

        ArrayList<Integer> dfs = solve(V, adj);
        System.out.println(dfs);
    }

    private static ArrayList<Integer> solve(int V, ArrayList<ArrayList<Integer>> adj) {
        ArrayList<Integer> dfs = new ArrayList<>();
        boolean[] vis = new boolean[V];
        vis[0] = true;
        dfs(0, vis, adj, dfs);
        return dfs;
    }

    private static void dfs(int node, boolean[] vis, ArrayList<ArrayList<Integer>> adj, ArrayList<Integer> dfs) {
        vis[node] = true;
        dfs.add(node);
        for (Integer it : adj.get(node)) {
            if (!vis[it])
                dfs(it, vis, adj, dfs);
        }
    }
}
