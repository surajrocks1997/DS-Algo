package com.arrays;

public class MaxProductSubArray {
    public static void main(String[] args) {
        int[] nums = {2, 3, -2, 4};
        int result = solve(nums);
        System.out.println(result);
    }

    private static int solve(int[] nums) {
        int prefix = 1;
        int suffix = 1;
        int maxP = Integer.MIN_VALUE;

        for(int i = 0; i < nums.length; i++){
            if(prefix == 0) prefix = 1;
            if(suffix == 0) suffix = 1;

            prefix = prefix * nums[i];
            suffix = suffix * nums[nums.length-1-i];

            maxP = Math.max(maxP, Math.max(prefix, suffix));
        }
        return maxP;
    }
}
