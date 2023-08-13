package com.dynamicProgramming.twoD.MinPathSum;

import java.util.Arrays;

public class MinPathSum_Mem {
    public static void main(String[] args) {
        int[][] grid = {
                {1, 3, 1},
                {1, 5, 1},
                {4, 2, 1}
        };

        int result = solve(grid);
        System.out.println(result);
    }

    private static int solve(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] dp = new int[m][n];
        for (int[] rows : dp) Arrays.fill(rows, -1);
        return solve(m - 1, n - 1, grid, dp);
    }

    private static int solve(int m, int n, int[][] grid, int[][] dp) {
        if (m == 0 && n == 0)
            return grid[m][n];
        if (m < 0 || n < 0) return (int) 1e9;

        if (dp[m][n] != -1) return dp[m][n];

        int up = grid[m][n] + solve(m - 1, n, grid, dp);
        int left = grid[m][n] + solve(m, n - 1, grid, dp);

        return dp[m][n] = Math.min(up, left);
    }
}
