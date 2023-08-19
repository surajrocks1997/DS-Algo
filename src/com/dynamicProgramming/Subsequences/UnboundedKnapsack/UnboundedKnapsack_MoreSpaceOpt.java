package com.dynamicProgramming.Subsequences.UnboundedKnapsack;

public class UnboundedKnapsack_MoreSpaceOpt {
    public static void main(String[] args) {
        int n = 3;
        int w = 10;
        int[] profit = {5, 11, 13};
        int[] weight = {2, 4, 6};

        int result = solve(n, w, profit, weight);
        System.out.println(result);

    }

    private static int solve(int n, int w, int[] profit, int[] weight) {
        int[] prev = new int[w + 1];

        for (int wt = 0; wt <= w; wt++)
            prev[wt] = profit[0] * ((int) wt / weight[0]);

        for (int index = 1; index < n; index++) {
            int[] curr = new int[w + 1];
            for (int wt = 0; wt <= w; wt++) {
                int notPick = prev[wt];
                int pick = Integer.MIN_VALUE;
                if (wt >= weight[index])
                    pick = profit[index] + prev[wt - weight[index]];

                prev[wt] = Math.max(pick, notPick);
            }
        }

        int result = prev[w];
        return result == (int) -1e9 ? 0 : result;
    }
}
