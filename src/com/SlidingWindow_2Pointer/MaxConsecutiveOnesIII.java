package com.SlidingWindow_2Pointer;

public class MaxConsecutiveOnesIII {
    public static void main(String[] args) {
        int[] nums = {0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 1, 1, 0, 0, 0, 1, 1, 1, 1};
        int k = 3;

        int result = solve(nums, k);
        System.out.println(result);
    }

    private static int solve(int[] nums, int k) {
        int windowEnd = 0;
        int windowStart = 0;
        int maxi = 0;

        while (windowEnd < nums.length) {
            if (nums[windowEnd] == 1) {
                windowEnd++;
            } else if (nums[windowEnd] == 0 && k > 0) {
                windowEnd++;
                k--;
            } else if (nums[windowStart] == 1) {
                windowStart++;
            } else if (nums[windowStart] == 0) {
                windowStart++;
                k++;
            }

            maxi = Math.max(maxi, windowEnd - windowStart);
        }
        return maxi;
    }
}
