package com.dynamicProgramming.Subsequences.UnboundedKnapsack;

import java.util.Arrays;

public class UnboundedKnapsack_Mem {
    public static void main(String[] args) {
        int n = 3;
        int w = 10;
        int[] profit = {5, 11, 13};
        int[] weight = {2, 4, 6};

        int result = solve(n, w, profit, weight);
        System.out.println(result);

    }

    private static int solve(int n, int w, int[] profit, int[] weight) {
        int[][] dp = new int[n][w + 1];
        for (int i = 0; i < n; i++)
            for (int j = 0; j <= w; j++) {
                dp[i][j] = -1;
            }

        int result = find(n - 1, w, profit, weight, dp);
        return result == (int) -1e9 ? 0 : result;
    }

    private static int find(int index, int w, int[] profit, int[] weight, int[][] dp) {
        if (index == 0)
            return profit[index] * ((int) w / weight[index]);

        if (dp[index][w] != -1) return dp[index][w];

        int notPick = find(index - 1, w, profit, weight, dp);
        int pick = Integer.MIN_VALUE;
        if (w >= weight[index])
            pick = profit[index] + find(index, w - weight[index], profit, weight, dp);

        return dp[index][w] = Math.max(notPick, pick);
    }
}
