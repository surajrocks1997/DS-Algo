package com.graph.medium;

import java.util.LinkedList;
import java.util.Queue;

public class NumberOfEnclaves {
    public static void main(String[] args) {
        int[][] grid = {
                {0, 0, 0, 1, 1},
                {0, 0, 1, 1, 0},
                {0, 1, 0, 0, 0},
                {0, 1, 1, 0, 0},
                {0, 0, 0, 1, 1},

        };

        int result = solve(grid);
        System.out.println(result);
    }

    private static int solve(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        Queue<Pair> queue = new LinkedList<>();
        int[][] vis = new int[m][n];

        for (int i = 0; i < n; i++) {
            if (grid[0][i] == 1 && vis[0][i] == 0) {
                queue.add(new Pair(0, i));
                vis[0][i] = 1;
            }

            if (grid[m - 1][i] == 1 && vis[m - 1][i] == 0) {
                queue.add(new Pair(m - 1, i));
                vis[m - 1][i] = 1;
            }
        }

        for (int i = 0; i < m; i++) {
            if (grid[i][0] == 1 && vis[i][0] == 0) {
                queue.add(new Pair(i, 0));
                vis[i][0] = 1;
            }

            if (grid[i][n - 1] == 1 && vis[i][n - 1] == 0) {
                queue.add(new Pair(i, n - 1));
                vis[i][n - 1] = 1;
            }
        }

        while (!queue.isEmpty()) {
            Pair pair = queue.poll();
            int row = pair.first;
            int col = pair.second;

            int[] delrow = {-1, 0, 1, 0};
            int[] delcol = {0, 1, 0, -1};

            for (int i = 0; i < 4; i++) {
                int nrow = row + delrow[i];
                int ncol = col + delcol[i];

                if (nrow >= 0 && nrow < m && ncol >= 0 && ncol < n &&
                        vis[nrow][ncol] == 0 && grid[nrow][ncol] == 1) {
                    queue.add(new Pair(nrow, ncol));
                    vis[nrow][ncol] = 1;
                }
            }
        }

        int count = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (vis[i][j] == 0 && grid[i][j] == 1)
                    count++;
            }
        }


        return count;
    }
}
