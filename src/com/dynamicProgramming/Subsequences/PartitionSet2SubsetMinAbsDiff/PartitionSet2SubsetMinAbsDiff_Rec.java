package com.dynamicProgramming.Subsequences.PartitionSet2SubsetMinAbsDiff;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PartitionSet2SubsetMinAbsDiff_Rec {
    public static void main(String[] args) {
        int[] nums = {3, 9, 7, 3};

        int result = solve(nums);
        System.out.println(result);
    }

//    all test cases not passed
    private static int solve(int[] nums) {
        if (nums.length == 2) return Math.abs(nums[0] - nums[1]);
        int totalSum = Arrays.stream(nums).sum();
        return solve(nums.length - 1, Integer.MAX_VALUE, nums, totalSum, 0);
    }

    private static int solve(int index, int mini, int[] nums, int totalSum, int currSum) {
        if (index < 0)
            return Math.min(mini, Math.abs(currSum - (totalSum - currSum)));

        int pick = solve(index - 1, mini, nums, totalSum, currSum + nums[index]);
        int notPick = solve(index - 1, mini, nums, totalSum, currSum);

        return Math.min(pick, notPick);
    }
}
