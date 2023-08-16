package com.dynamicProgramming.Subsequences.PartitionEqualSubsetSum;

import java.util.Arrays;

public class PartitionEqualSubsetSum_Rec {
    public static void main(String[] args) {
        int[] nums = {3, 3, 3, 4, 5};

        boolean result = solve(nums);
        System.out.println(result);
    }

    private static boolean solve(int[] nums) {
        int totalSum = Arrays.stream(nums).sum();
        if (totalSum % 2 == 1) return false;
        else return solve(totalSum / 2, nums, nums.length - 1);
    }

    private static boolean solve(int k, int[] nums, int index) {
        if (k == 0) return true;
        if (index == 0) return k == nums[index];

        boolean pick = false;
        if (k >= nums[index])
            pick = solve(k - nums[index], nums, index - 1);
        boolean notPick = solve(k, nums, index - 1);

        return pick || notPick;
    }
}
