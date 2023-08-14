package com.dynamicProgramming.threeD;

import java.util.Arrays;

public class CherryPickupII_Mem {
    public static void main(String[] args) {
        int r = 3;
        int c = 4;
        int[][] grid = {
                {2, 3, 1, 2},
                {3, 4, 2, 2},
                {5, 6, 3, 5}
        };

        int result = solve(r, c, grid);
        System.out.println(result);
    }

    private static int solve(int r, int c, int[][] grid) {
        int[][][] dp = new int[r][c][c];
        for (int row1[][] : dp) {
            for (int row2[] : row1) {
                Arrays.fill(row2, -1);
            }
        }

        return solve(0, 0, c - 1, grid, r, c, dp);
    }

    private static int solve(int i, int j1, int j2, int[][] grid, int r, int c, int[][][] dp) {
        if (j1 < 0 || j2 < 0 || j1 >= c || j2 >= c)
            return (int) -1e9;

        if (i == r - 1) {
            if (j1 == j2) return grid[i][j1];
            else return grid[i][j1] + grid[i][j2];
        }

        if (dp[i][j1][j2] != -1)
            return dp[i][j1][j2];

        int maxi = Integer.MIN_VALUE;
        for (int dj1 = -1; dj1 <= +1; dj1++) {
            for (int dj2 = -1; dj2 <= +1; dj2++) {
                int value = 0;

                if (j1 == j2) value = grid[i][j1];
                else value = grid[i][j1] + grid[i][j2];

                value += solve(i + 1, j1 + dj1, j2 + dj2, grid, r, c, dp);
                maxi = Math.max(maxi, value);
            }
        }

        return dp[i][j1][j2] = maxi;
    }
}
