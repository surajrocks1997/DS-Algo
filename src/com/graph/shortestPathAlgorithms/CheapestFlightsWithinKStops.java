package com.graph.shortestPathAlgorithms;

import java.util.*;

public class CheapestFlightsWithinKStops {
    public static void main(String[] args) {
        int n = 4;
        int[][] flights = {
                {0, 1, 100},
                {1, 2, 100},
                {2, 0, 100},
                {1, 3, 600},
                {2, 3, 200}
        };
        int src = 0;
        int dst = 3;
        int k = 1;

        int result = solve(n, flights, src, dst, k);
        System.out.println(result);
    }

    private static int solve(int n, int[][] flights, int src, int dst, int k) {
        List<List<Pair_ShortestPathWeightedUndirectedGraph>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++)
            adj.add(new ArrayList<>());

        int m = flights.length;

        for (int i = 0; i < m; i++)
            adj.get(flights[i][0])
                    .add(new Pair_ShortestPathWeightedUndirectedGraph(flights[i][1], flights[i][2]));

        int[] distance = new int[n];
        Arrays.fill(distance, (int) 1e9);
        distance[src] = 0;

        Queue<Tuple_CheapestFlightsWithinKStops> queue = new LinkedList<>();
        queue.add(new Tuple_CheapestFlightsWithinKStops(0, src, 0));

        while (!queue.isEmpty()) {
            Tuple_CheapestFlightsWithinKStops tuple = queue.poll();
            int stops = tuple.stops;
            int node = tuple.node;
            int cost = tuple.cost;

            if (stops > k) continue;

            for (Pair_ShortestPathWeightedUndirectedGraph it : adj.get(node)) {
                int adjNode = it.first;
                int edgeCost = it.second;

                if (cost + edgeCost < distance[adjNode] && stops <= k) {
                    distance[adjNode] = cost + edgeCost;
                    queue.add(new Tuple_CheapestFlightsWithinKStops(stops + 1, adjNode, cost + edgeCost));
                }
            }
        }

        if (distance[dst] == 1e9) return -1;
        return distance[dst];
    }
}

class Tuple_CheapestFlightsWithinKStops {
    int stops;
    int node;
    int cost;

    public Tuple_CheapestFlightsWithinKStops(int stops, int node, int cost) {
        this.stops = stops;
        this.node = node;
        this.cost = cost;
    }
}
