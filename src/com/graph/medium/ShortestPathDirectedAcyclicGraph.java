package com.graph.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class ShortestPathDirectedAcyclicGraph {
    public static void main(String[] args) {
        int N = 6;
        int M = 7;
        int[][] edges = {
                {0, 1, 2},
                {0, 4, 1},
                {4, 5, 4},
                {4, 2, 2},
                {1, 2, 3},
                {2, 3, 6},
                {5, 3, 1}
        };

        int[] result = solve(N, M, edges);
        for (int ele : result)
            System.out.print(ele + " ");
    }

    private static int[] solve(int N, int M, int[][] edges) {
        List<List<Pair_ShortestPathDirectedAcyclicGraph>> adj = new ArrayList<>();
        for (int i = 0; i < N; i++)
            adj.add(new ArrayList<>());

        for (int i = 0; i < M; i++) {
            int u = edges[i][0];
            int v = edges[i][1];
            int weight = edges[i][2];
            adj.get(u).add(new Pair_ShortestPathDirectedAcyclicGraph(v, weight));
        }

        int[] vis = new int[N];

        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < N; i++) {
            if (vis[i] == 0)
                topoSort(i, adj, vis, stack);
        }

        int[] distance = new int[N];
        Arrays.fill(distance, (int) 1e9);

        distance[0] = 0;

        while (!stack.isEmpty()) {
            int node = stack.pop();
            for (Pair_ShortestPathDirectedAcyclicGraph it : adj.get(node)) {
                int v = it.v;
                int weight = it.weight;

                if (distance[node] + weight < distance[v])
                    distance[v] = distance[node] + weight;
            }
        }

        for (int i = 0; i < N; i++) {
            if (distance[i] == 1e9)
                distance[i] = -1;
        }

        return distance;
    }

    private static void topoSort(int node, List<List<Pair_ShortestPathDirectedAcyclicGraph>> adj, int[] vis, Stack<Integer> stack) {
        vis[node] = 1;

        for (Pair_ShortestPathDirectedAcyclicGraph it : adj.get(node)) {
            int v = it.v;
            if (vis[v] == 0)
                topoSort(v, adj, vis, stack);
        }

        stack.push(node);
    }
}

class Pair_ShortestPathDirectedAcyclicGraph {
    int v;
    int weight;

    public Pair_ShortestPathDirectedAcyclicGraph(int v, int weight) {
        this.v = v;
        this.weight = weight;
    }
}