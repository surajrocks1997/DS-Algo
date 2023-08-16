package com.dynamicProgramming.Subsequences.PartitionEqualSubsetSum;

import java.util.Arrays;

public class PartitionEqualSubsetSum_Tab {
    public static void main(String[] args) {
        int[] nums = {3, 3, 3, 4, 5};

        boolean result = solve(nums);
        System.out.println(result);
    }

    private static boolean solve(int[] nums) {
        int totalSum = Arrays.stream(nums).sum();
        if (totalSum % 2 == 1) return false;

        int n = nums.length;
        int k = totalSum / 2;
        boolean[][] dp = new boolean[n][k + 1];

        for (int i = 0; i < n; i++)
            dp[i][0] = true;

        if (nums[0] <= k) dp[0][nums[0]] = true;

        for (int index = 1; index < n; index++) {
            for (int target = 1; target <= k; target++) {
                boolean taken = false;
                if (target >= nums[index])
                    taken = dp[index - 1][target - nums[index]];

                boolean notTaken = dp[index - 1][target];
                dp[index][target] = notTaken || taken;
            }
        }
        return dp[n - 1][k];
    }
}
