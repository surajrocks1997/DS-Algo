package com.graph.minSpanningTreeDisjointSet;

import java.util.ArrayList;
import java.util.List;

public class KruskalAlgorithm {
    public static void main(String[] args) {
        int V = 6;
        int E = 9;
        int[][] edges = {
                {5, 4, 9},
                {5, 1, 4},
                {1, 4, 1},
                {4, 3, 5},
                {4, 2, 3},
                {1, 2, 2},
                {3, 2, 3},
                {3, 6, 8},
                {2, 6, 7}
        };

        int result = solve(V, E, edges);
        System.out.println(result);
    }

    private static int solve(int V, int E, int[][] edges) {
        List<List<Pair>> adj = new ArrayList<>();

        for (int i = 0; i < V + 1; i++)
            adj.add(new ArrayList<>());

        for (int i = 0; i < E; i++) {
            adj.get(edges[i][0]).add(new Pair(edges[i][1], edges[i][2]));
            adj.get(edges[i][1]).add(new Pair(edges[i][0], edges[i][2]));
        }

        List<Edge> edge = new ArrayList<>();
        for (int i = 0; i < V + 1; i++) {
            for (Pair pair : adj.get(i)) {
                edge.add(new Edge(i, pair.first, pair.second));
            }
        }

        edge.sort((x, y) -> x.weight - y.weight);

        int mstWeight = 0;
        List<Edge> result = new ArrayList<>();

        DisjointSet_Class ds = new DisjointSet_Class(V);
        for (Edge ed : edge) {
            int u = ed.src;
            int v = ed.dst;
            int wt = ed.weight;

            if (ds.findUltimateParent(u) != ds.findUltimateParent(v)) {
                mstWeight += wt;
                ds.unionBySize(u, v);
                result.add(new Edge(u, v, wt));
            }
        }

        System.out.println("MST:");
        for (Edge res : result)
            System.out.println(res.src + " " + res.dst + " " + res.weight);
        return mstWeight;
    }
}

class Edge {
    int src;
    int dst;
    int weight;

    public Edge(int src, int dst, int weight) {
        this.src = src;
        this.dst = dst;
        this.weight = weight;
    }
}
