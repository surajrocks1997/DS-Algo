package com.dynamicProgramming.Subsequences.MinCoins;

public class MinCoins_Tab {
    public static void main(String[] args) {
        int[] coins = {1, 2, 5};
        int amount = 11;

        int result = solve(coins, amount);
        System.out.println(result);
    }

    private static int solve(int[] coins, int amount) {
        int n = coins.length;
        int[][] dp = new int[n][amount + 1];
        for (int target = 0; target <= amount; target++) {
            if (target % coins[0] == 0)
                dp[0][target] = target / coins[0];
            else
                dp[0][target] = (int) 1e9;
        }

        for (int index = 1; index < n; index++) {
            for (int target = 0; target <= amount; target++) {
                int notPick = dp[index - 1][target];
                int pick = Integer.MAX_VALUE;
                if (target >= coins[index])
                    pick = 1 + dp[index][target - coins[index]];

                dp[index][target] = Math.min(pick, notPick);
            }
        }

        int result = dp[n - 1][amount];
        return result >= (int) 1e9 ? -1 : result;
    }
}
