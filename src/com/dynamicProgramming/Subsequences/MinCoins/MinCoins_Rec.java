package com.dynamicProgramming.Subsequences.MinCoins;

public class MinCoins_Rec {
    public static void main(String[] args) {
        int[] coins = {2};
        int amount = 3;

        int result = solve(coins, amount);
        System.out.println(result);
    }

    private static int solve(int[] coins, int amount) {
        int result = solve(coins.length - 1, amount, coins);
        return result >= (int) 1e9 ? -1 : result;
    }

    private static int solve(int index, int amount, int[] coins) {
        if (index == 0) {
            if (amount % coins[index] == 0) return amount / coins[index];
            else return (int) 1e9;
        }

        int notPick = solve(index - 1, amount, coins);
        int pick = Integer.MAX_VALUE;
        if (amount >= coins[index])
            pick = 1 + solve(index, amount - coins[index], coins);

        return Math.min(pick, notPick);
    }
}
