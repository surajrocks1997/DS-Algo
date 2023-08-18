package com.dynamicProgramming.Subsequences.MinCoins;

public class MinCoins_SpaceOpt {
    public static void main(String[] args) {
        int[] coins = {1, 2, 5};
        int amount = 11;

        int result = solve(coins, amount);
        System.out.println(result);
    }

    private static int solve(int[] coins, int amount) {
        int n = coins.length;
        int[] prev = new int[amount + 1];
        for (int index = 0; index <= amount; index++) {
            if (index % coins[0] == 0)
                prev[index] = index / coins[0];
            else
                prev[index] = (int) 1e9;
        }

        for (int index = 1; index < n; index++) {
            int[] curr = new int[amount + 1];
            for (int target = 0; target <= amount; target++) {
                int notPick = prev[target];
                int pick = Integer.MAX_VALUE;
                if (target >= coins[index])
                    pick = 1 + curr[target - coins[index]];

                curr[target] = Math.min(pick, notPick);
            }
            prev = curr;
        }

        int result = prev[amount];
        return result >= (int) 1e9 ? -1 : result;
    }
}
