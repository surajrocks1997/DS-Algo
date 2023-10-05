package com.dynamicProgramming.PartitionDP.MCM;

public class MCM_Tab {
    public static void main(String[] args) {
        int[] p = {10, 15, 20, 25};

        int result = solve(p);
        System.out.println(result);
    }

    private static int solve(int[] p) {
        int n = p.length;
        int[][] dp = new int[n][n];

        for (int i = 1; i < n; i++)
            dp[i][i] = 0;

        for (int i = n - 1; i >= 1; i--) {
            for (int j = i + 1; j < n; j++) {     // j always needs to be right of i, hence i + 1

                int min = (int) 1e9;
                for (int k = i; k < j; k++) {
                    int steps = p[i - 1] * p[k] * p[j] +
                            dp[i][k] + dp[k + 1][j];

                    min = Math.min(min, steps);
                }
                dp[i][j] = min;
            }
        }


        return dp[1][n - 1];
    }
}
