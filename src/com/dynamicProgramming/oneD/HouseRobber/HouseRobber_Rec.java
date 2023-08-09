package com.dynamicProgramming.oneD.HouseRobber;

public class HouseRobber_Rec {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 1};

        int result = solve(nums);
        System.out.println(result);
    }

    private static int solve(int[] nums) {
        return solve(nums.length - 1, nums);

    }

    private static int solve(int index, int[] nums) {
        if (index == 0) return nums[index];
        if (index < 0) return 0;

        int pick = nums[index] + solve(index - 2, nums);
        int notpick = solve(index - 1, nums);

        return Math.max(pick, notpick);

    }
}
