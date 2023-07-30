package com.graph.shortestPathAlgorithms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class NumberOfWaysToArriveAtDestination {
    public static void main(String[] args) {
        int n = 7;
        int[][] roads = {
                {0, 6, 7},
                {0, 1, 2},
                {1, 2, 3},
                {1, 3, 3},
                {6, 3, 3},
                {3, 5, 1},
                {6, 5, 1},
                {2, 5, 1},
                {0, 4, 5},
                {4, 6, 2}
        };

        int result = solve(n, roads);
        System.out.println(result);
    }

    private static int solve(int n, int[][] roads) {
        List<List<Pair_ShortestPathDirectedAcyclicGraph>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++)
            adj.add(new ArrayList<>());

        for (int[] road : roads) {
            adj.get(road[0]).add(new Pair_ShortestPathDirectedAcyclicGraph(road[1], road[2]));
            adj.get(road[1]).add(new Pair_ShortestPathDirectedAcyclicGraph(road[0], road[2]));
        }

        PriorityQueue<Pair_DijkstraAlgo_PQ> pq = new PriorityQueue<>((x, y) -> x.distance - y.distance);
        int[] distance = new int[n];
        int[] ways = new int[n];

        Arrays.fill(distance, (int) 1e9);
        distance[0] = 0;
        ways[0] = 1;

        pq.add(new Pair_DijkstraAlgo_PQ(0, 0));

        int mod = (int) (1e9 + 7);

        while (!pq.isEmpty()) {
            Pair_DijkstraAlgo_PQ pair = pq.poll();
            int dist = pair.distance;
            int node = pair.node;

            for (Pair_ShortestPathDirectedAcyclicGraph it : adj.get(node)) {
                int adjNode = it.v;
                int edgeWeight = it.weight;

                if (dist + edgeWeight < distance[adjNode]) {
                    distance[adjNode] = dist + edgeWeight;
                    pq.add(new Pair_DijkstraAlgo_PQ(dist + edgeWeight, adjNode));
                    ways[adjNode] = ways[node];
                } else if (dist + edgeWeight == distance[adjNode]) {
                    ways[adjNode] = (ways[adjNode] + ways[node]) % mod;
                }
            }
        }


        return (ways[n - 1]) % mod;
    }
}
