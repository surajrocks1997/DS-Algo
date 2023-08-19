package com.dynamicProgramming.Subsequences.CoinChangeII;

public class CoinChangeII_Rec {
    public static void main(String[] args) {
        int[] coins = {1, 2, 5};
        int amount = 5;

        int result = solve(coins, amount);
        System.out.println(result);
    }

    private static int solve(int[] coins, int amount) {
        return solve(coins.length - 1, amount, coins);
    }

    private static int solve(int index, int amount, int[] coins) {
        if (index == 0) {
            if (amount % coins[index] == 0) return 1;
            return 0;
        }

        int notPick = solve(index - 1, amount, coins);

        int pick = 0;
        if (amount >= coins[index])
            pick = solve(index, amount - coins[index], coins);

        return pick + notPick;
    }
}
