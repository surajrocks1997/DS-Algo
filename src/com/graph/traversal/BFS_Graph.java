package com.graph.traversal;

import java.util.*;

public class BFS_Graph {
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

        ArrayList<Integer> bfs = solve(V, adj);
        System.out.println(bfs);
    }

    private static ArrayList<Integer> solve(int v, ArrayList<ArrayList<Integer>> adj) {
        ArrayList<Integer> bfs = new ArrayList<>();
        boolean[] vis = new boolean[v];
        Queue<Integer> queue = new LinkedList<>();

        queue.add(0);
        vis[0] = true;

        while (!queue.isEmpty()) {
            Integer node = queue.poll();
            bfs.add(node);

            for (Integer it : adj.get(node)) {
                if (!vis[it]) {
                    vis[it] = true;
                    queue.add(it);
                }

            }
        }

        return bfs;
    }
}
