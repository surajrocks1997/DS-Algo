package com.graph.shortestPathAlgorithms;

import java.util.ArrayList;
import java.util.Arrays;

public class BellmanFordAlgorithm {
    public static void main(String[] args) {
        int V = 3;
        ArrayList<ArrayList<Integer>> edges = new ArrayList<>();
        ArrayList<Integer> temp = new ArrayList<>(Arrays.asList(0, 1, 5));
        edges.add(temp);
        temp = new ArrayList<>(Arrays.asList(1, 0, 3));
        edges.add(temp);
        temp = new ArrayList<>(Arrays.asList(1, 2, -1));
        edges.add(temp);
        temp = new ArrayList<>(Arrays.asList(2, 0, 1));
        edges.add(temp);
        int S = 2;

        int[] result = solve(V, edges, S);
        for (int ele : result)
            System.out.print(ele + " ");

    }

    private static int[] solve(int V, ArrayList<ArrayList<Integer>> edges, int S) {
        int[] distance = new int[V];
        Arrays.fill(distance, (int) 1e8);
        distance[S] = 0;

        for (int i = 0; i < V - 1; i++) {
            for (ArrayList<Integer> it : edges) {
                int u = it.get(0);
                int v = it.get(1);
                int wt = it.get(2);

                if (distance[u] + wt < distance[v])
                    distance[v] = distance[u] + wt;
            }
        }

        for (ArrayList<Integer> it : edges) {
            int u = it.get(0);
            int v = it.get(1);
            int wt = it.get(2);

            if (distance[u] != 1e8 && distance[u] + wt < distance[v])
                return new int[]{-1};
        }

        return distance;
    }
}
