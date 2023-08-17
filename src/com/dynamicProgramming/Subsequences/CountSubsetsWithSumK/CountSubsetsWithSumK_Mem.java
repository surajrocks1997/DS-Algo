package com.dynamicProgramming.Subsequences.CountSubsetsWithSumK;

import java.util.Arrays;

public class CountSubsetsWithSumK_Mem {
    public static void main(String[] args) {
        int[] num = {2, 34, 5};
        int tar = 40;

        int result = solve(num, tar);
        System.out.println(result);
    }

    private static int solve(int[] num, int tar) {
        int[][] dp = new int[num.length][tar + 1];
        for (int[] rows : dp) Arrays.fill(rows, -1);
        return solve(num.length - 1, tar, num, dp);
    }

    private static int solve(int index, int k, int[] num, int[][] dp) {
        if (k == 0) return 1;
        if (index == 0) return k == num[index] ? 1 : 0;

        if (dp[index][k] != -1) return dp[index][k];

        int notPick = solve(index - 1, k, num, dp);
        int pick = 0;
        if (num[index] <= k)
            pick = solve(index - 1, k - num[index], num, dp);

        return dp[index][k] = pick + notPick;
    }
}
