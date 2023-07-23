package com.graph.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Stack;

public class TopoSort {
    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        ArrayList<Integer> temp = new ArrayList<>(Collections.emptyList());
        adj.add(temp);
        temp = new ArrayList<>(Collections.emptyList());
        adj.add(temp);
        temp = new ArrayList<>(Collections.singletonList(3));
        adj.add(temp);
        temp = new ArrayList<>(Collections.singletonList(1));
        adj.add(temp);
        temp = new ArrayList<>(Arrays.asList(0, 1));
        adj.add(temp);
        temp = new ArrayList<>(Arrays.asList(2, 0));
        adj.add(temp);

        int V = adj.size();

        int[] result = solve(V, adj);
        for (int ele : result)
            System.out.print(ele + " ");
    }

    private static int[] solve(int V, ArrayList<ArrayList<Integer>> adj) {
        int[] vis = new int[V];
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < V; i++) {
            if (vis[i] == 0)
                dfs(i, adj, vis, stack);
        }

        int[] result = new int[V];
        for (int i = 0; i < V; i++)
            result[i] = stack.pop();

        return result;
    }

    private static void dfs(int node, ArrayList<ArrayList<Integer>> adj, int[] vis, Stack<Integer> stack) {
        vis[node] = 1;

        for (int it : adj.get(node)) {
            if (vis[it] == 0)
                dfs(it, adj, vis, stack);
        }
        stack.push(node);
    }
}
