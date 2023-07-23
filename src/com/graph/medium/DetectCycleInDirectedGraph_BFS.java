package com.graph.medium;

import java.util.*;

public class DetectCycleInDirectedGraph_BFS {
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
        int[] indegree = new int[V];
        for (int i = 0; i < V; i++) {
            for (int it : adj.get(i)) {
                indegree[it]++;
            }
        }

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < V; i++)
            if (indegree[i] == 0)
                queue.add(i);

        int count = 0;
        while (!queue.isEmpty()) {
            int node = queue.poll();
            count++;

            for (int it : adj.get(node)) {
                indegree[it]--;
                if (indegree[it] == 0) queue.add(it);
            }
        }
        return count != V;
    }
}
