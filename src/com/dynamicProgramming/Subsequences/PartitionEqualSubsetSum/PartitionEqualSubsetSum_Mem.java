package com.dynamicProgramming.Subsequences.PartitionEqualSubsetSum;

import java.util.Arrays;

public class PartitionEqualSubsetSum_Mem {
    public static void main(String[] args) {
        int[] nums = {3, 3, 3, 4, 5};

        boolean result = solve(nums);
        System.out.println(result);
    }

    private static boolean solve(int[] nums) {
        int totalSum = Arrays.stream(nums).sum();
        if (totalSum % 2 == 1) return false;

        int[][] dp = new int[nums.length][totalSum / 2 + 1];
        for (int[] rows : dp)
            Arrays.fill(rows, -1);

        return solve(totalSum / 2, nums, nums.length - 1, dp);
    }

    private static boolean solve(int k, int[] nums, int index, int[][] dp) {
        if (k == 0) return true;
        if (index == 0) return k == nums[index];

        if (dp[index][k] != -1) return dp[index][k] != 0;

        boolean pick = false;
        if (k >= nums[index])
            pick = solve(k - nums[index], nums, index - 1, dp);
        boolean notPick = solve(k, nums, index - 1, dp);

        dp[index][k] = pick || notPick ? 1 : 0;

        return pick || notPick;
    }
}
