package com.dynamicProgramming.LIS.LIS;

import java.util.Arrays;

public class LIS_Mem {
    public static void main(String[] args) {
        int[] nums = {10, 9, 2, 5, 3, 7, 101, 18};

        int result = solve(nums);
        System.out.println(result);
    }

    //    shifting index by +1 of prev so could be memoized
    private static int solve(int[] nums) {
        int n = nums.length;
        int[][] dp = new int[n][n + 1];
        for (int[] rows : dp) Arrays.fill(rows, -1);
        return solve(0, -1, nums, dp);
    }

    private static int solve(int index, int prev, int[] nums, int[][] dp) {
        if (index == nums.length)
            return 0;

        if (dp[index][prev + 1] != -1) return dp[index][prev + 1];

        int notTake = solve(index + 1, prev, nums, dp);

        int take = 0;
        if (prev == -1 || nums[index] > nums[prev])
            take = 1 + solve(index + 1, index, nums, dp);

        return dp[index][prev + 1] = Math.max(take, notTake);
    }
}
