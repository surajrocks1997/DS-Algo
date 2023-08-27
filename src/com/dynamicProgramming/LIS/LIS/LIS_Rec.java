package com.dynamicProgramming.LIS.LIS;

public class LIS_Rec {
    public static void main(String[] args) {
        int[] nums = {10, 9, 2, 5, 3, 7, 101, 18};

        int result = solve(nums);
        System.out.println(result);
    }

    private static int solve(int[] nums) {
        int n = nums.length;
        return solve(0, -1, nums);
    }

    private static int solve(int index, int prev, int[] nums) {
        if (index == nums.length)
            return 0;

        int notTake = solve(index + 1, prev, nums);

        int take = 0;
        if (prev == -1 || nums[index] > nums[prev])
            take = 1 + solve(index + 1, index, nums);

        return Math.max(take, notTake);
    }
}
