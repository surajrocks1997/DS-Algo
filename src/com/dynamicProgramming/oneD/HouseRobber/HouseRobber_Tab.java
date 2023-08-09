package com.dynamicProgramming.oneD.HouseRobber;

import java.util.Arrays;

public class HouseRobber_Tab {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 1};

        int result = solve(nums);
        System.out.println(result);
    }

    private static int solve(int[] nums) {
        int[] dp = new int[nums.length];
        dp[0] = nums[0];

        for (int i = 1; i < nums.length; i++) {
            int pick = nums[i];
            if (i > 1) pick += dp[i - 2];

            int notPick = dp[i - 1];
            dp[i] = Math.max(pick, notPick);
        }
        return dp[nums.length - 1];

    }
}
