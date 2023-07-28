package com.graph.shortestPathAlgorithms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class ShortestPathInWeightedUndirectedGraph {
    public static void main(String[] args) {
        int n = 5;
        int m = 6;
        int[][] edges = {
                {1, 2, 2},
                {2, 5, 5},
                {2, 3, 4},
                {1, 4, 1},
                {4, 3, 3},
                {3, 5, 1}
        };

        List<Integer> result = solve(n, m, edges);
        System.out.println(result);
    }

    private static List<Integer> solve(int n, int m, int[][] edges) {
        List<List<Pair_ShortestPathWeightedUndirectedGraph>> adj = new ArrayList<>();
        for (int i = 0; i <= n; i++)
            adj.add(new ArrayList<>());

        for (int i = 0; i < m; i++) {
            adj.get(edges[i][0]).add(new Pair_ShortestPathWeightedUndirectedGraph(edges[i][1], edges[i][2]));
            adj.get(edges[i][1]).add(new Pair_ShortestPathWeightedUndirectedGraph(edges[i][0], edges[i][2]));
        }

        PriorityQueue<Pair_ShortestPathWeightedUndirectedGraph> pq = new PriorityQueue<>((x, y) -> x.first - y.first);

        int[] distance = new int[n + 1];
        int[] parent = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            distance[i] = (int) 1e9;
            parent[i] = i;
        }

        distance[1] = 0;
        pq.add(new Pair_ShortestPathWeightedUndirectedGraph(0, 1));

        while (!pq.isEmpty()) {
            Pair_ShortestPathWeightedUndirectedGraph pair = pq.poll();
            int dist = pair.first;
            int node = pair.second;

            for (Pair_ShortestPathWeightedUndirectedGraph it : adj.get(node)) {
                int adjNode = it.first;
                int weight = it.second;

                if (dist + weight < distance[adjNode]) {
                    distance[adjNode] = dist + weight;
                    pq.add(new Pair_ShortestPathWeightedUndirectedGraph(dist + weight, adjNode));
                    parent[adjNode] = node;
                }
            }
        }

        List<Integer> path = new ArrayList<>();

        if (distance[n] == 1e9) {
            path.add(-1);
            return path;
        }

        int node = n;
        while (parent[node] != node) {
            path.add(node);
            node = parent[node];
        }
        path.add(1);

        Collections.reverse(path);
        return path;
    }
}

class Pair_ShortestPathWeightedUndirectedGraph {
    int first;
    int second;

    public Pair_ShortestPathWeightedUndirectedGraph(int first, int second) {
        this.first = first;
        this.second = second;
    }
}