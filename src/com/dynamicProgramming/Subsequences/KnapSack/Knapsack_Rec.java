package com.dynamicProgramming.Subsequences.KnapSack;

public class Knapsack_Rec {
    public static void main(String[] args) {
        int n = 3;
        int[] weight = {3, 4, 5};
        int[] value = {30, 50, 60};
        int maxWeight = 8;

        int result = solve(weight, value, n, maxWeight);
        System.out.println(result);
    }

    private static int solve(int[] weight, int[] value, int n, int maxWeight) {
        return solve(n - 1, maxWeight, weight, value);

    }

    private static int solve(int index, int W, int[] weight, int[] value) {
        if (index == 0) {
            if (weight[index] <= W) return value[index];
            else return 0;
        }

        int notPick = solve(index - 1, W, weight, value);
        int pick = Integer.MIN_VALUE;
        if (weight[index] <= W)
            pick = value[index] + solve(index - 1, W - weight[index], weight, value);
        return Math.max(notPick, pick);
    }
}
