package com.dynamicProgramming.Subsequences.MinCoins;

import java.util.Arrays;

public class MinCoins_Mem {
    public static void main(String[] args) {
        int[] coins = {1, 2, 5};
        int amount = 11;

        int result = solve(coins, amount);
        System.out.println(result);
    }

    private static int solve(int[] coins, int amount) {
        int n = coins.length;
        int[][] dp = new int[n][amount + 1];
        for (int[] rows : dp) Arrays.fill(rows, -1);
        int result = solve(n - 1, amount, coins, dp);
        return result >= (int) 1e9 ? -1 : result;
    }

    private static int solve(int index, int amount, int[] coins, int[][] dp) {
        if (index == 0) {
            if (amount % coins[index] == 0) return amount / coins[index];
            else return (int) 1e9;
        }

        if (dp[index][amount] != -1) return dp[index][amount];

        int notPick = solve(index - 1, amount, coins, dp);
        int pick = Integer.MAX_VALUE;
        if (amount >= coins[index])
            pick = 1 + solve(index, amount - coins[index], coins, dp);

        return dp[index][amount] = Math.min(pick, notPick);
    }
}
