package com.dynamicProgramming.MCM;

import java.util.Arrays;

public class MCM_Mem {
    public static void main(String[] args) {
        int[] p = {10, 15, 20, 25};

        int result = solve(p);
        System.out.println(result);
    }

    private static int solve(int[] p) {
        int[][] dp = new int[p.length][p.length];
        for (int[] rows : dp) Arrays.fill(rows, -1);
        return solve(1, p.length - 1, p, dp);
    }

    private static int solve(int i, int j, int[] arr, int[][] dp) {
        if (i == j) return 0;

        if (dp[i][j] != -1) return dp[i][j];

        int min = (int) 1e9;
        for (int k = i; k < j; k++) {
            int steps = arr[i - 1] * arr[k] * arr[j] +
                    solve(i, k, arr, dp) + solve(k + 1, j, arr, dp);

            min = Math.min(min, steps);
        }
        return dp[i][j] = min;
    }
}
