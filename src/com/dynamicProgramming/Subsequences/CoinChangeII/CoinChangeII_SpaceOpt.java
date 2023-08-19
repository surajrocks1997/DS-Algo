package com.dynamicProgramming.Subsequences.CoinChangeII;

public class CoinChangeII_SpaceOpt {
    public static void main(String[] args) {
        int[] coins = {1, 2, 5};
        int amount = 5;

        int result = solve(coins, amount);
        System.out.println(result);
    }

    private static int solve(int[] coins, int amount) {
        int n = coins.length;
        int[] prev = new int[amount + 1];

        for (int i = 0; i <= amount; i++)
            if (i % coins[0] == 0) prev[i] = 1;

        for (int index = 1; index < n; index++) {
            int[] curr = new int[amount + 1];
            for (int target = 0; target <= amount; target++) {
                int notPick = prev[target];

                int pick = 0;
                if (target >= coins[index])
                    pick = curr[target - coins[index]];

                curr[target] = pick + notPick;
            }
            prev = curr;
        }

        return prev[amount];
    }
}
