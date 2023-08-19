package com.dynamicProgramming.Subsequences.TargetSum;

import java.util.Arrays;

public class TargetSum_Mem {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 1};
        int target = 3;

        int result = solve(nums, target);
        System.out.println(result);
    }

    private static int solve(int[] nums, int target) {
        int totalSum = Arrays.stream(nums).sum();

        if ((totalSum - target) % 2 == 1) return 0;
        if (totalSum - target < 0) return 0;

        int sum = (totalSum - target) / 2;

        int[][] dp = new int[nums.length][sum + 1];
        for (int[] rows : dp) Arrays.fill(rows, -1);

        return solve(nums.length - 1, sum, nums, dp);
    }

    private static int solve(int index, int target, int[] nums, int[][] dp) {
        if (index == 0) {
            if (target == 0 && nums[index] == 0) return 2;
            if (target == 0 || target == nums[index]) return 1;
            return 0;
        }

        if (dp[index][target] != -1) return dp[index][target];

        int notPick = solve(index - 1, target, nums, dp);
        int pick = 0;
        if (target >= nums[index])
            pick = solve(index - 1, target - nums[index], nums, dp);

        return dp[index][target] = notPick + pick;
    }
}
