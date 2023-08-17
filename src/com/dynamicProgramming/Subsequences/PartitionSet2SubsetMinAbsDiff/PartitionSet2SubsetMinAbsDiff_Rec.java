package com.dynamicProgramming.Subsequences.PartitionSet2SubsetMinAbsDiff;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PartitionSet2SubsetMinAbsDiff_Rec {
    public static void main(String[] args) {
        int[] nums = {2, -1, 0, 4, -2, -9};

        int result = solve(nums);
        System.out.println(result);
    }

    private static int solve(int[] nums) {
        int totalSum = Arrays.stream(nums).sum();
        return solve(nums.length - 1, nums.length / 2, 0, Integer.MAX_VALUE, totalSum, nums);
    }

    private static int solve(int index, int count, int sum, int mini, int totalSum, int[] nums) {
        if (count == 0)
            return Math.min(mini, Math.abs(sum - (totalSum - sum)));
        if (index == 0 && count != 0)
            return mini;

        int pick = solve(index - 1, count - 1, sum + nums[index], mini, totalSum, nums);
        int notPick = solve(index - 1, count, sum, mini, totalSum, nums);
        return Math.min(pick, notPick);
    }
}
