package com.dynamicProgramming.Subsequences.KnapSack;

public class Knapsack_SpaceOpt {
    public static void main(String[] args) {
        int n = 3;
        int[] weight = {3, 4, 5};
        int[] value = {30, 50, 60};
        int maxWeight = 8;

        int result = solve(weight, value, n, maxWeight);
        System.out.println(result);
    }

    private static int solve(int[] weight, int[] value, int n, int maxWeight) {
        int[] prev = new int[maxWeight + 1];

        for (int W = weight[0]; W <= maxWeight; W++)
            prev[W] = value[0];

        for (int index = 1; index < n; index++) {
            int[] curr = new int[maxWeight + 1];
            for (int W = 0; W <= maxWeight; W++) {
                int notPick = prev[W];

                int pick = Integer.MIN_VALUE;
                if (weight[index] <= W)
                    pick = value[index] + prev[W - weight[index]];

                curr[W] = Math.max(pick, notPick);
            }
            prev = curr;

        }
        return prev[maxWeight];
    }
}
