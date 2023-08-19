package com.dynamicProgramming.Subsequences.CoinChangeII;

import java.util.Arrays;

public class CoinChangeII_Tab {
    public static void main(String[] args) {
        int[] coins = {1, 2, 5};
        int amount = 5;

        int result = solve(coins, amount);
        System.out.println(result);
    }

    private static int solve(int[] coins, int amount) {
        int n = coins.length;
        int[][] dp = new int[n][amount + 1];

        for (int i = 0; i <= amount; i++)
            if (i % coins[0] == 0) dp[0][i] = 1;

        for (int index = 1; index < n; index++) {
            for (int target = 0; target <= amount; target++) {
                int notPick = dp[index - 1][target];

                int pick = 0;
                if (target >= coins[index])
                    pick = dp[index][target - coins[index]];

                dp[index][target] = pick + notPick;
            }
        }

        return dp[n - 1][amount];
    }
}
