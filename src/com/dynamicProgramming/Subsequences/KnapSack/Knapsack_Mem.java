package com.dynamicProgramming.Subsequences.KnapSack;

import java.util.Arrays;

public class Knapsack_Mem {
    public static void main(String[] args) {
        int n = 3;
        int[] weight = {3, 4, 5};
        int[] value = {30, 50, 60};
        int maxWeight = 8;

        int result = solve(weight, value, n, maxWeight);
        System.out.println(result);
    }

    private static int solve(int[] weight, int[] value, int n, int maxWeight) {
        int[][] dp = new int[n][maxWeight + 1];
        for (int[] rows : dp) Arrays.fill(rows, -1);
        return solve(n - 1, maxWeight, weight, value, dp);

    }

    private static int solve(int index, int W, int[] weight, int[] value, int[][] dp) {
        if (index == 0) {
            if (weight[index] <= W) return value[index];
            else return 0;
        }

        if (dp[index][W] != -1) return dp[index][W];

        int notPick = solve(index - 1, W, weight, value, dp);
        int pick = Integer.MIN_VALUE;
        if (weight[index] <= W)
            pick = value[index] + solve(index - 1, W - weight[index], weight, value, dp);
        return dp[index][W] = Math.max(notPick, pick);
    }
}
