package com.dynamicProgramming.twoD.MinPathSum;

import java.util.Arrays;

public class MinPathSum_Tab {
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

        dp[0][0] = grid[0][0];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 && j == 0) continue;

                int up = (int) 1e9;
                if (i > 0)
                    up = grid[i][j] + dp[i - 1][j];

                int left = (int) 1e9;
                if (j > 0)
                    left = grid[i][j] + dp[i][j - 1];

                dp[i][j] = Math.min(up, left);
            }
        }

        return dp[m - 1][n - 1];
    }
}
