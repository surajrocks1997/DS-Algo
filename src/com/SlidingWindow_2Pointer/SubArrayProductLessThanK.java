package com.SlidingWindow_2Pointer;

// https://leetcode.com/problems/subarray-product-less-than-k/description/
public class SubArrayProductLessThanK {
    public static void main(String[] args) {
        int[] nums = {1, 1, 1};
        int k = 1;

        int result = solve(nums, k);
        System.out.println(result);
    }

    private static int solve(int[] nums, int k) {
        int n = nums.length;
        int count = 0;
        int multi = 1;

        int l = 0;
        int r = 0;

        while (l <= r && r < n) {
            multi *= nums[r];
            while (l <= r && multi >= k) {
                multi = multi / nums[l];
                l++;
            }

            count += r - l + 1;
            r++;

        }

        return count;
    }
}
