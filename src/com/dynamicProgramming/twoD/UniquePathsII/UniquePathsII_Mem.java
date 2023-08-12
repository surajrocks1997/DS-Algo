package com.dynamicProgramming.twoD.UniquePathsII;

import java.util.Arrays;

public class UniquePathsII_Mem {
    public static void main(String[] args) {
        int[][] obstacleGrid = {
                {0, 0, 0},
                {0, 1, 0},
                {0, 0, 0}
        };

        int result = solve(obstacleGrid);
        System.out.println(result);
    }

    private static int solve(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[][] dp = new int[m][n];
        for (int[] row : dp) Arrays.fill(row, -1);
        return find(m - 1, n - 1, obstacleGrid, dp);
    }

    private static int find(int m, int n, int[][] obstacleGrid, int[][] dp) {
        if (m >= 0 && n >= 0 && obstacleGrid[m][n] == 1) return 0;
        if (m == 0 && n == 0) return 1;
        if (m < 0 || n < 0) return 0;

        if (dp[m][n] != -1) return dp[m][n];

        int up = find(m - 1, n, obstacleGrid, dp);
        int left = find(m, n - 1, obstacleGrid, dp);

        return dp[m][n] = up + left;
    }
}
