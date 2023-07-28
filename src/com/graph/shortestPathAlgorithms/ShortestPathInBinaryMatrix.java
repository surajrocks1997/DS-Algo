package com.graph.shortestPathAlgorithms;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class ShortestPathInBinaryMatrix {
    public static void main(String[] args) {
        int[][] grid = {
                {0}
        };

        System.out.println(grid[0][0]);
        System.out.println(grid[grid.length - 1][grid[0].length - 1]);

        int result = solve(grid);
        System.out.println(result);
    }

    private static int solve(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) return -1;

        int[] source = {0, 0};
        int[] destination = {grid.length - 1, grid[0].length - 1};

        int m = grid.length;
        int n = grid[0].length;

        if (source[0] == destination[0] && source[1] == destination[1] && grid[0][0] == 0) return 1;
        else if (source[0] == destination[0] && source[1] == destination[1] && grid[0][0] == 1) return -1;

        if (grid[0][0] == 1 || grid[m - 1][n - 1] == 1) return -1;

        Queue<Tuple> queue = new LinkedList<>();

        int[][] dist = new int[m][n];
        for (int[] ele : dist)
            Arrays.fill(ele, (int) 1e9);

        dist[source[0]][source[1]] = 0;
        queue.add(new Tuple(0, source[0], source[1]));

        int[] delrow = {-1, -1, 0, 1, 1, 1, 0, -1};
        int[] delcol = {0, 1, 1, 1, 0, -1, -1, -1};

        while (!queue.isEmpty()) {
            Tuple tuple = queue.poll();
            int distance = tuple.distance;
            int row = tuple.row;
            int col = tuple.col;

            for (int i = 0; i < 8; i++) {
                int nrow = row + delrow[i];
                int ncol = col + delcol[i];

                if (nrow >= 0 && nrow < m && ncol >= 0 && ncol < n &&
                        grid[nrow][ncol] == 0 && distance + 1 < dist[nrow][ncol]) {
                    dist[nrow][ncol] = distance + 1;
                    if (nrow == destination[0] && ncol == destination[1]) return distance + 2;
                    queue.add(new Tuple(distance + 1, nrow, ncol));
                }
            }


        }

        return -1;
    }
}

class Tuple {
    int distance;
    int row;
    int col;

    public Tuple(int distance, int row, int col) {
        this.distance = distance;
        this.row = row;
        this.col = col;
    }
}
