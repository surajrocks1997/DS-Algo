package com.graph.minSpanningTreeDisjointSet;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class PrimsAlgorithm {
    public static void main(String[] args) {
        int[][] edges = {
                {0, 1, 2},
                {0, 2, 1},
                {2, 1, 1},
                {2, 4, 2},
                {2, 3, 2},
                {3, 4, 1}
        };
        int V = 5;
        int E = 6;

        int result = solve(V, E, edges);
        System.out.println(result);
    }

    private static int solve(int V, int E, int[][] edges) {
        List<List<Pair>> adj = new ArrayList<>();

        for (int i = 0; i < V; i++)
            adj.add(new ArrayList<>());

        for (int i = 0; i < E; i++) {
            adj.get(edges[i][0]).add(new Pair(edges[i][1], edges[i][2]));
            adj.get(edges[i][1]).add(new Pair(edges[i][0], edges[i][2]));
        }

        PriorityQueue<Pair_PrimsAlgorithm> pq = new PriorityQueue<>((x, y) -> x.distance - y.distance);
        pq.add(new Pair_PrimsAlgorithm(0, 0));

        int[] visited = new int[V];
        int sum = 0;

        while (!pq.isEmpty()) {
            Pair_PrimsAlgorithm pair = pq.poll();
            int weight = pair.distance;
            int node = pair.node;

            if (visited[node] == 1) continue;
            visited[node] = 1;

            sum += weight;

            for (Pair it : adj.get(node)) {
                int adjNode = it.first;
                int edgeWeight = it.second;

                if (visited[adjNode] == 0)
                    pq.add(new Pair_PrimsAlgorithm(edgeWeight, adjNode));
            }
        }
        return sum;
    }
}

class Pair_PrimsAlgorithm {
    int distance;
    int node;

    public Pair_PrimsAlgorithm(int distance, int node) {
        this.distance = distance;
        this.node = node;
    }
}

class Pair {
    int first;
    int second;

    public Pair(int first, int second) {
        this.first = first;
        this.second = second;
    }
}
