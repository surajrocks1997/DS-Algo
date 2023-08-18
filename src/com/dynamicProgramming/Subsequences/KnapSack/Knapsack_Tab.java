package com.dynamicProgramming.Subsequences.KnapSack;

public class Knapsack_Tab {
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

        for (int W = weight[0]; W <= maxWeight; W++)
            dp[0][W] = value[0];

        for (int index = 1; index < n; index++) {
            for (int W = 0; W <= maxWeight; W++) {
                int notPick = dp[index - 1][W];

                int pick = Integer.MIN_VALUE;
                if (weight[index] <= W)
                    pick = value[index] + dp[index - 1][W - weight[index]];

                dp[index][W] = Math.max(pick, notPick);
            }
        }
        return dp[n - 1][maxWeight];
    }
}
