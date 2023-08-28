package com.SlidingWindow_2Pointer;

public class MaxConsecutiveOnesIII {
    public static void main(String[] args) {
        int[] nums = {0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 1, 1, 0, 0, 0, 1, 1, 1, 1};
        int k = 3;

        int result = solve(nums, k);
        System.out.println(result);
    }

    private static int solve(int[] nums, int k) {
        int i = 0;
        int j = 0;

        int maxi = 0;

        while (i < nums.length) {
            if (nums[i] == 1) {
                i++;
            } else if (nums[i] == 0 && k > 0) {
                i++;
                k--;
            } else if (nums[j] == 1) {
                j++;
            } else if (nums[j] == 0) {
                j++;
                k++;
            }

            maxi = Math.max(maxi, i - j);
        }
        return maxi;
    }
}
