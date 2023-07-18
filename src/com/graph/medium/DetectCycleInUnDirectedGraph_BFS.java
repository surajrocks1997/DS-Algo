package com.graph.medium;

import java.util.*;

public class DetectCycleInUnDirectedGraph_BFS {
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
                if (detectCycle(i, V, adj, vis)) return true;
        }

        return false;
    }

    private static boolean detectCycle(int i, int v, ArrayList<ArrayList<Integer>> adj, boolean[] vis) {
        vis[i] = true;
        Queue<Pair> queue = new LinkedList<>();
//        pair will have currentNode and it's ParentNode
        queue.add(new Pair(i, -1));
        while (!queue.isEmpty()) {
            Pair pair = queue.poll();
            int curr = pair.first;
            int parent = pair.second;
            for (Integer adjNode : adj.get(curr)) {
                if (!vis[adjNode]) {
                    vis[adjNode] = true;
                    queue.add(new Pair(adjNode, curr));
                } else if(parent != adjNode && vis[adjNode])
                    return true;
            }
        }

        return false;
    }
}