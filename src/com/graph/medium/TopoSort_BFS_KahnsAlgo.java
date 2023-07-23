package com.graph.medium;

import java.util.*;

public class TopoSort_BFS_KahnsAlgo {
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
        int[] indegree = new int[V];

        for (int i = 0; i < V; i++) {
            for (int it : adj.get(i))
                indegree[it]++;
        }

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < V; i++) {
            if (indegree[i] == 0)
                queue.add(i);
        }

        int[] topo = new int[V];
        int i = 0;
        while (!queue.isEmpty()) {
            int node = queue.poll();
            topo[i] = node;
            i++;

            for (int it : adj.get(node)) {
                indegree[it]--;
                if (indegree[it] == 0)
                    queue.add(it);
            }
        }


        return topo;
    }
}
