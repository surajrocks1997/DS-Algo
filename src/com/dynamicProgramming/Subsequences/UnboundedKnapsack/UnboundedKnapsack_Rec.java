package com.dynamicProgramming.Subsequences.UnboundedKnapsack;

public class UnboundedKnapsack_Rec {
    public static void main(String[] args) {
        int n = 2;
        int w = 3;
        int[] profit = {6, 12};
        int[] weight = {4, 17};

        int result = solve(n, w, profit, weight);
        System.out.println(result);

    }

    private static int solve(int n, int w, int[] profit, int[] weight) {
        int result = find(n - 1, w, profit, weight);
        return result == (int) -1e9 ? 0 : result;
    }

    private static int find(int index, int w, int[] profit, int[] weight) {
        if (index == 0)
            return profit[index] * ((int) w / weight[index]);

        int notPick = find(index - 1, w, profit, weight);
        int pick = 0;
        if (w >= weight[index])
            pick = profit[index] + find(index, w - weight[index], profit, weight);

        return Math.max(notPick, pick);
    }
}
