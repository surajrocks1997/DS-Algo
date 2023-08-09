package com.dynamicProgramming.oneD.HouseRobber;

public class HouseRobber_Opt {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 1};

        int result = solve(nums);
        System.out.println(result);
    }

    private static int solve(int[] nums) {

        int prev = nums[0];
        int prev2 = 0;

        for (int i = 1; i < nums.length; i++) {
            int pick = nums[i];
            if (i > 1) pick += prev2;

            int notPick = prev;
            int curri = Math.max(pick, notPick);

            prev2 = prev;
            prev = curri;
        }
        return prev;

    }
}
