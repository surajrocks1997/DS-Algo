package com.graph.shortestPathAlgorithms;

import java.util.Arrays;
import java.util.PriorityQueue;

public class PathWithMinEffort {
    public static void main(String[] args) {
        int[][] heights = {
                {1, 2, 2},
                {3, 8, 2},
                {5, 3, 5}
        };

        int result = solve(heights);
        System.out.println(result);
    }

    private static int solve(int[][] heights) {
        PriorityQueue<Tuple> pq = new PriorityQueue<>((x, y) -> x.distance - y.distance);

        int m = heights.length;
        int n = heights[0].length;
        int[][] distance = new int[m][n];
        for (int[] row : distance)
            Arrays.fill(row, (int) 1e9);

        distance[0][0] = 0;
        int[] delrow = {-1, 0, 1, 0};
        int[] delcol = {0, 1, 0, -1};
        pq.add(new Tuple(0, 0, 0));

        while (!pq.isEmpty()) {
            Tuple tuple = pq.poll();
            int diff = tuple.distance;
            int row = tuple.row;
            int col = tuple.col;

            if (row == m - 1 && col == n - 1) return diff;

            for (int i = 0; i < 4; i++) {
                int nrow = row + delrow[i];
                int ncol = col + delcol[i];

                if (nrow >= 0 && nrow < m && ncol >= 0 && ncol < n) {
                    int newEffort = Math.max(Math.abs(heights[row][col] - heights[nrow][ncol]), diff);

                    if (newEffort < distance[nrow][ncol]) {
                        distance[nrow][ncol] = newEffort;
                        pq.add(new Tuple(newEffort, nrow, ncol));
                    }
                }
            }
        }

        return 0;
    }
}
