package com.dynamicProgramming.twoD.UniquePaths;

import java.util.Arrays;

public class UniquePaths_Mem {
    public static void main(String[] args) {
        int m = 3;
        int n = 7;

        int result = solve(m, n);
        System.out.println(result);
    }

    private static int solve(int m, int n) {
        int[][] dp = new int[m][n];
        for (int[] row : dp) Arrays.fill(row, -1);
        return find(m - 1, n - 1, dp);
    }

    private static int find(int m, int n, int[][] dp) {
        if (m == 0 && n == 0) return dp[m][n] = 1;
        if (m < 0 || n < 0) return 0;

        if (dp[m][n] != -1) return dp[m][n];

        int up = find(m - 1, n, dp);
        int left = find(m, n - 1, dp);

        return dp[m][n] = up + left;
    }
}
