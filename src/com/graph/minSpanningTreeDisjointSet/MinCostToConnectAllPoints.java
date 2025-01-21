package com.graph.minSpanningTreeDisjointSet;

import java.util.*;

// https://leetcode.com/problems/min-cost-to-connect-all-points/description/
public class MinCostToConnectAllPoints {
    public static void main(String[] args) {
        int[][] points = {
                {0, 0},
                {2, 2},
                {3, 10},
                {5, 2},
                {7, 0}
        };

        int result = solve(points);
        System.out.println(result);
    }

    private static int solve(int[][] points) {
        int n = points.length;
        List<List<Pair_MinCostToConnectAllPoints>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int i = 0; i < n; i++) {
            int x1 = points[i][0];
            int y1 = points[i][1];
            for (int j = i + 1; j < n; j++) {
                int x2 = points[j][0];
                int y2 = points[j][1];
                int dist = Math.abs(x1 - x2) + Math.abs(y1 - y2);
                adj.get(i).add(new Pair_MinCostToConnectAllPoints(j, dist));
                adj.get(j).add(new Pair_MinCostToConnectAllPoints(i, dist));
            }
        }

        int res = 0;
        Set<Integer> visited = new HashSet<>();
        PriorityQueue<Pair_MinCostToConnectAllPoints> pq = new PriorityQueue<>((a, b) -> a.cost - b.cost);
        pq.add(new Pair_MinCostToConnectAllPoints(0, 0));
        while (visited.size() < n) {
            Pair_MinCostToConnectAllPoints poll = pq.poll();
            if (visited.contains(poll.node)) {
                continue;
            } else {
                res += poll.cost;
                visited.add(poll.node);
                for (Pair_MinCostToConnectAllPoints itr : adj.get(poll.node)) {
                    if (!visited.contains(itr.node))
                        pq.add(itr);
                }
            }
        }
        return res;
    }
}

class Pair_MinCostToConnectAllPoints {
    int node;
    int cost;

    public Pair_MinCostToConnectAllPoints(int node, int cost) {
        this.node = node;
        this.cost = cost;
    }
}