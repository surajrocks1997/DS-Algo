package com.graph.minSpanningTreeDisjointSet;

import java.util.PriorityQueue;

public class SwimInRisingWater {
    public static void main(String[] args) {
        int[][] grid = {
                {0, 1, 2, 3, 4},
                {24, 23, 22, 21, 5},
                {12, 13, 14, 15, 16},
                {11, 17, 18, 19, 20},
                {10, 9, 8, 7, 6}
        };

        int result = solve(grid);
        System.out.println(result);
    }

    private static int solve(int[][] grid) {
        int n = grid.length;

        PriorityQueue<Tuple_SwimInRisingWater> pq = new PriorityQueue<>((x, y) -> x.weight - y.weight);
        pq.add(new Tuple_SwimInRisingWater(grid[0][0], 0, 0));

        boolean[][] vis = new boolean[n][n];

        while (!pq.isEmpty()) {
            Tuple_SwimInRisingWater tuple = pq.poll();
            int row = tuple.row;
            int col = tuple.col;
            int weight = tuple.weight;

            if (row == n - 1 && col == n - 1) return weight;

            if (vis[row][col]) continue;
            vis[row][col] = true;

            int[] delrow = {-1, 0, 1, 0};
            int[] delcol = {0, 1, 0, -1};

            for (int i = 0; i < 4; i++) {
                int nrow = row + delrow[i];
                int ncol = col + delcol[i];

                if (nrow >= 0 && nrow < n && ncol >= 0 && ncol < n && !vis[nrow][ncol]) {
                    int max = Math.max(weight, grid[nrow][ncol]);
                    pq.add(new Tuple_SwimInRisingWater(max, nrow, ncol));
                }
            }
        }
        return -1;
    }
}

class Tuple_SwimInRisingWater {
    int weight;
    int row;
    int col;

    public Tuple_SwimInRisingWater(int weight, int row, int col) {
        this.weight = weight;
        this.row = row;
        this.col = col;
    }
}

