package com.dynamicProgramming.twoD.UniquePaths;

public class UniquePaths_Tab {
    public static void main(String[] args) {
        int m = 3;
        int n = 7;

        int result = solve(m, n);
        System.out.println(result);
    }

    private static int solve(int m, int n) {
        int[][] dp = new int[m][n];
        dp[0][0] = 1;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 && j == 0) continue;

                int up = 0;
                if (i > 0)
                    up = dp[i - 1][j];

                int left = 0;
                if (j > 0)
                    left = dp[i][j - 1];

                dp[i][j] = up + left;
            }
        }
        return dp[m - 1][n - 1];
    }
}
