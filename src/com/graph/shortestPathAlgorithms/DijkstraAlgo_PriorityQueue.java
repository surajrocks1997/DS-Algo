package com.graph.shortestPathAlgorithms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

public class DijkstraAlgo_PriorityQueue {
    public static void main(String[] args) {
        ArrayList<ArrayList<ArrayList<Integer>>> adj = new ArrayList<>();
        ArrayList<ArrayList<Integer>> current = new ArrayList<>();
        ArrayList<Integer> temp = new ArrayList<>(Arrays.asList(1, 9));
        current.add(temp);
        adj.add(current);

        current = new ArrayList<>();
        temp = new ArrayList<>(Arrays.asList(0, 9));
        current.add(temp);

        adj.add(current);
        int V = 2;
        int S = 0;

        int[] result = solve(V, adj, S);
        for (int ele : result)
            System.out.print(ele + " ");

    }

//    TC - E log V
    private static int[] solve(int V, ArrayList<ArrayList<ArrayList<Integer>>> adj, int S) {
        PriorityQueue<Pair_DijkstraAlgo_PQ> pq = new PriorityQueue<Pair_DijkstraAlgo_PQ>((x, y) -> x.distance - y.distance);

        int[] distance = new int[V];
        Arrays.fill(distance, (int) 1e9);

        distance[S] = 0;
        pq.add(new Pair_DijkstraAlgo_PQ(0, S));

        while (!pq.isEmpty()) {
            Pair_DijkstraAlgo_PQ pair = pq.poll();
            int node = pair.node;
            int dist = pair.distance;

            for (ArrayList<Integer> it : adj.get(node)) {
                int edgeWeight = it.get(1);
                int adjNode = it.get(0);

                if (distance[adjNode] > dist + edgeWeight) {
                    distance[adjNode] = dist + edgeWeight;
                    pq.add(new Pair_DijkstraAlgo_PQ(distance[adjNode], adjNode));
                }
            }
        }

        return distance;
    }
}

class Pair_DijkstraAlgo_PQ {
    int distance;
    int node;

    public Pair_DijkstraAlgo_PQ(int distance, int node) {
        this.distance = distance;
        this.node = node;
    }
}