package com.dynamicProgramming.Subsequences.CoinChangeII;

import java.util.Arrays;

public class CoinChangeII_Mem {
    public static void main(String[] args) {
        int[] coins = {1, 2, 5};
        int amount = 5;

        int result = solve(coins, amount);
        System.out.println(result);
    }

    private static int solve(int[] coins, int amount) {
        int[][] dp = new int[coins.length][amount + 1];
        for (int[] rows : dp) Arrays.fill(rows, -1);
        return solve(coins.length - 1, amount, coins, dp);
    }

    private static int solve(int index, int amount, int[] coins, int[][] dp) {
        if (index == 0) {
            if (amount % coins[index] == 0) return 1;
            return 0;
        }

        if (dp[index][amount] != -1) return dp[index][amount];

        int notPick = solve(index - 1, amount, coins, dp);

        int pick = 0;
        if (amount >= coins[index])
            pick = solve(index, amount - coins[index], coins, dp);

        return dp[index][amount] = pick + notPick;
    }
}
