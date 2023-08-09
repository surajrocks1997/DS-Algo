package com.dynamicProgramming.oneD.HouseRobber;

import java.util.Arrays;

public class HouseRobber_Mem {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 1};

        int result = solve(nums);
        System.out.println(result);
    }

    private static int solve(int[] nums) {
        int[] dp = new int[nums.length];
        Arrays.fill(dp, -1);
        return solve(nums.length - 1, nums, dp);

    }

    private static int solve(int index, int[] nums, int[] dp) {
        if (index == 0) return nums[index];
        if (index < 0) return 0;

        if (dp[index] != -1) return dp[index];

        int pick = nums[index] + solve(index - 2, nums, dp);
        int notpick = solve(index - 1, nums, dp);

        return dp[index] = Math.max(pick, notpick);

    }
}
