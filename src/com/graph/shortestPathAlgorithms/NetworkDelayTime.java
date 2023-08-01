package com.graph.shortestPathAlgorithms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class NetworkDelayTime {
    public static void main(String[] args) {
        int[][] times = {
                {2, 1, 1},
                {2, 3, 1},
                {3, 4, 1}
        };
        int n = 4;
        int k = 2;

        int result = solve(times, n, k);
        System.out.println(result);
    }

    private static int solve(int[][] times, int n, int k) {
        List<List<Pair_ShortestPathWeightedUndirectedGraph>> adj = new ArrayList<>();
        for (int i = 0; i <= n; i++)
            adj.add(new ArrayList<>());

        for (int[] time : times)
            adj.get(time[0]).add(new Pair_ShortestPathWeightedUndirectedGraph(time[1], time[2]));

        int[] distance = new int[n + 1];
        Arrays.fill(distance, (int) 1e9);
        distance[k] = 0;

        PriorityQueue<Pair_DijkstraAlgo_PQ> pq = new PriorityQueue<>((x, y) -> x.distance - y.distance);
        pq.add(new Pair_DijkstraAlgo_PQ(0, k));

        while (!pq.isEmpty()) {
            Pair_DijkstraAlgo_PQ pair = pq.poll();
            int dist = pair.distance;
            int node = pair.node;

            for (Pair_ShortestPathWeightedUndirectedGraph it : adj.get(node)) {
                int adjNode = it.first;
                int wt = it.second;

                if (dist + wt < distance[adjNode]) {
                    distance[adjNode] = dist + wt;
                    pq.add(new Pair_DijkstraAlgo_PQ(dist + wt, adjNode));
                }
            }
        }

        int max = Integer.MIN_VALUE;

        for (int i = 1; i < distance.length; i++) {
            if (distance[i] == 1e9)
                return -1;

            max = Math.max(max, distance[i]);
        }

        return max;
    }
}
