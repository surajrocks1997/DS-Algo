package com.dynamicProgramming.Subsequences.CountSubsetsWithSumK;

import java.util.Arrays;

public class CountSubsetsWithSumK_Tab {
    public static void main(String[] args) {
        int[] num = {2, 34, 5};
        int tar = 40;

        int result = solve(num, tar);
        System.out.println(result);
    }

    private static int solve(int[] num, int tar) {
        int n = num.length;
        int[][] dp = new int[n][tar + 1];

        for (int i = 0; i < n; i++)
            dp[i][0] = 1;

        if (num[0] <= tar)
            dp[0][num[0]] = 1;

        for (int index = 1; index < n; index++) {
            for (int target = 0; target <= tar; target++) {
                int notPick = dp[index - 1][target];

                int pick = 0;
                if (num[index] <= target)
                    pick = dp[index - 1][target - num[index]];

                dp[index][target] = pick + notPick;
            }
        }
        return dp[n - 1][tar];
    }
}
