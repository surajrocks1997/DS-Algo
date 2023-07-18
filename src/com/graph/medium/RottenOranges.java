package com.graph.medium;

import java.util.LinkedList;
import java.util.Queue;

public class RottenOranges {
    public static void main(String[] args) {
        int[][] grid = {
                {0, 1, 2},
                {0, 1, 1},
                {2, 1, 1}
        };
        int result = solve(grid);
        System.out.println(result);
    }

    private static int solve(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        Queue<Pair_RottenOranges> queue = new LinkedList<>();
        int[][] vis = new int[m][n];

        int countFresh = 0;

        for (int row = 0; row < m; row++) {
            for (int col = 0; col < n; col++) {
                if (grid[row][col] == 2) {
                    queue.add(new Pair_RottenOranges(row, col, 0));
                    vis[row][col] = 2;
                } else vis[row][col] = 0;

                if (grid[row][col] == 1) countFresh++;
            }
        }

        int time = 0;
        int[] delrow = {-1, 0, 1, 0};
        int[] delcol = {0, 1, 0, -1};

        int countRotten = 0;

        while (!queue.isEmpty()) {
            Pair_RottenOranges pair = queue.poll();
            int r = pair.row;
            int c = pair.col;
            int t = pair.time;

            time = Math.max(time, t);

            for (int i = 0; i < 4; i++) {
                int nrow = r + delrow[i];
                int ncol = c + delcol[i];
                if (nrow >= 0 && nrow < m && ncol >= 0 && ncol < n &&
                        vis[nrow][ncol] == 0 && grid[nrow][ncol] == 1) {
                    queue.add(new Pair_RottenOranges(nrow, ncol, t + 1));
                    vis[nrow][ncol] = 2;
                    countRotten++;
                }
            }
        }

        return countFresh != countRotten ? -1 : time;
    }
}

class Pair_RottenOranges {
    int row;
    int col;
    int time;

    public Pair_RottenOranges(int row, int col, int time) {
        this.row = row;
        this.col = col;
        this.time = time;
    }
}
