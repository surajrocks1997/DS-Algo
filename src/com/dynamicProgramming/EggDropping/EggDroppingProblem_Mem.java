package com.dynamicProgramming.EggDropping;

import java.util.Arrays;

public class EggDroppingProblem_Mem {
    public static void main(String[] args) {
        int n = 2; // eggs
        int k = 10; // floor
        int[][] dp = new int[n + 1][k + 1];
        for (int[] rows : dp) Arrays.fill(rows, -1);
        int result = solve(n, k, dp);
        System.out.println(result);
    }

    private static int solve(int n, int k, int[][] dp) {
        if (k == 1 || k == 0) return k;
        if (n == 1) return k;

        if (dp[n][k] != -1) return dp[n][k];

        int min = Integer.MAX_VALUE;
        int res;
        for (int i = 1; i <= k; i++) {
            int eggBroke = solve(n - 1, i - 1, dp); //1 egg broke, check lower floors
            int eggNotBreak = solve(n, k - i, dp); //egg did not break, check upper floors

            res = Math.max(eggBroke, eggNotBreak);
            if (res < min)
                min = res;
        }
        return dp[n][k] = 1 + min;
    }
}
