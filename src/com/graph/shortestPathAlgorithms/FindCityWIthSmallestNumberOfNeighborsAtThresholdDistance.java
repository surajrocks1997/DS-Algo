package com.graph.shortestPathAlgorithms;

import java.util.Arrays;

public class FindCityWIthSmallestNumberOfNeighborsAtThresholdDistance {
    public static void main(String[] args) {
        int n = 5;
        int[][] edges = {
                {0, 1, 2},
                {0, 4, 8},
                {1, 2, 3},
                {1, 4, 2},
                {2, 3, 1},
                {3, 4, 1}
        };
        int distanceThreshold = 2;

        int result = solve(n, edges, distanceThreshold);
        System.out.println(result);
    }

    private static int solve(int n, int[][] edges, int distanceThreshold) {
        int[][] distance = new int[n][n];
        for (int[] row : distance)
            Arrays.fill(row, Integer.MAX_VALUE);

        for (int i = 0; i < edges.length; i++) {
            int u = edges[i][0];
            int v = edges[i][1];
            int wt = edges[i][2];
            distance[u][v] = wt;
            distance[v][u] = wt;
        }

        for (int i = 0; i < n; i++) distance[i][i] = 0;

        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (distance[i][k] == Integer.MAX_VALUE || distance[k][j] == Integer.MAX_VALUE) continue;

                    distance[i][j] = Math.min(distance[i][j], distance[i][k] + distance[k][j]);
                }
            }
        }

        int countCity = n;
        int cityNumber = -1;

        for (int city = 0; city < n; city++) {
            int count = 0;
            for (int adjCity = 0; adjCity < n; adjCity++) {
                if (distance[city][adjCity] <= distanceThreshold)
                    count++;
            }

            if (count <= countCity) {
                countCity = count;
                cityNumber = city;
            }
        }


        return cityNumber;
    }
}
