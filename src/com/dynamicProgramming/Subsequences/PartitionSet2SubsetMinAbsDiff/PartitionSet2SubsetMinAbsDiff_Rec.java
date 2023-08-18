package com.dynamicProgramming.Subsequences.PartitionSet2SubsetMinAbsDiff;

import java.util.Arrays;

public class PartitionSet2SubsetMinAbsDiff_Rec {
    public static void main(String[] args) {
        int[] nums = {2, -1, 0, 4, -2, -9};

        int result = solve(nums);
        System.out.println(result);
    }

    private static int solve(int[] nums) {
        int totalSum = Arrays.stream(nums).sum();
        return solve(nums.length - 1, nums.length / 2, 0, totalSum, nums);
    }

    private static int solve(int index, int count, int curr, int totalSum, int[] nums) {
        if (count == 0) return Math.abs(curr - (totalSum - curr));
        if (index == 0) return Integer.MAX_VALUE;

        int notPick = solve(index - 1, count, curr, totalSum, nums);
        int pick = Integer.MAX_VALUE;
        if (count > 0)
            pick = solve(index - 1, count - 1, curr + nums[index], totalSum, nums);
        return Math.min(pick, notPick);
    }
}


// another working solution but TLE issue

// class Solution {
//     public int minimumDifference(int[] nums) {
//         int totalSum = Arrays.stream(nums).sum();
//         return solve(nums.length - 1, nums.length / 2, 0, Integer.MAX_VALUE, totalSum, nums);
//     }

//     private static int solve(int index, int count, int sum, int mini, int totalSum, int[] nums) {
//         if (count == 0)
//             return Math.min(mini, Math.abs(sum - (totalSum - sum)));
//         if (index == 0 && count != 0)
//             return mini;

//         int pick = solve(index - 1, count - 1, sum + nums[index], mini, totalSum, nums);
//         int notPick = solve(index - 1, count, sum, mini, totalSum, nums);
//         return Math.min(pick, notPick);
//     }
// }