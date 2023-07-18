package com.graph.medium;

import java.util.*;

public class DetectCycleInUnDirectedGraph_DFS {
    public static void main(String[] args) {
        int V = 8;
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        ArrayList<Integer> temp = new ArrayList<>(Collections.emptyList());
        adj.add(temp);
        temp = new ArrayList<>(Arrays.asList(2, 3));
        adj.add(temp);
        temp = new ArrayList<>(Arrays.asList(1, 5));
        adj.add(temp);
        temp = new ArrayList<>(Arrays.asList(1, 4, 6));
        adj.add(temp);
        temp = new ArrayList<>(Collections.singletonList(3));
        adj.add(temp);
        temp = new ArrayList<>(Arrays.asList(2, 7));
        adj.add(temp);
        temp = new ArrayList<>(Arrays.asList(3, 7));
        adj.add(temp);
        temp = new ArrayList<>(Arrays.asList(5, 6));
        adj.add(temp);

        Boolean result = solve(V, adj);
        System.out.println(result);
    }

    private static Boolean solve(int V, ArrayList<ArrayList<Integer>> adj) {
        boolean[] vis = new boolean[V];
        for (int i = 0; i < V; i++) {
            if (!vis[i])
                if (dfs(i, -1, adj, vis)) return true;
        }

        return false;
    }

    private static boolean dfs(int src, int parent, ArrayList<ArrayList<Integer>> adj, boolean[] vis) {
        vis[src] = true;
        for (Integer adjNode : adj.get(src)) {
            if (!vis[adjNode]) {
                if (dfs(adjNode, src, adj, vis))
                    return true;
            } else if (adjNode != parent)
                return true;
        }
        return false;
    }
}