package com.graph.minSpanningTreeDisjointSet;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class PrimsAlgorithm_MST {
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

        List<Pair> result = solve(V, E, edges);
        for (Pair pair : result) {
            System.out.print(pair.first + "-" + pair.second + " ");
        }


    }

    private static List<Pair> solve(int V, int E, int[][] edges) {
        List<List<Pair>> adj = new ArrayList<>();

        for (int i = 0; i < V; i++)
            adj.add(new ArrayList<>());

        for (int i = 0; i < E; i++) {
            adj.get(edges[i][0]).add(new Pair(edges[i][1], edges[i][2]));
            adj.get(edges[i][1]).add(new Pair(edges[i][0], edges[i][2]));
        }

        PriorityQueue<MST> pq = new PriorityQueue<>((x, y) -> x.weight - y.weight);
        pq.add(new MST(0, 0, -1));

        int[] visited = new int[V];
        List<Pair> mstList = new ArrayList<>();
        int sum = 0;

        while (!pq.isEmpty()) {
            MST mst = pq.poll();
            int weight = mst.weight;
            int node = mst.node;
            int parent = mst.parent;

            if (visited[node] == 1) continue;
            visited[node] = 1;

            if (parent != -1)
                mstList.add(new Pair(node, parent));

            sum += weight;

            for (Pair it : adj.get(node)) {
                int adjNode = it.first;
                int edgeWeight = it.second;

                if (visited[adjNode] == 0)
                    pq.add(new MST(edgeWeight, adjNode, node));
            }
        }

        System.out.println(sum);

        return mstList;
    }
}

class MST {
    int weight;
    int node;
    int parent;

    public MST(int weight, int node, int parent) {
        this.weight = weight;
        this.node = node;
        this.parent = parent;
    }
}

