package com.SlidingWindow_2Pointer;

// https://leetcode.com/problems/minimum-swaps-to-group-all-1s-together-ii/description/
public class MinSwapsToGroupAll1sTogetherII {

    public static void main(String[] args) {
        int[] nums = {0, 1, 1, 1, 0, 0, 1, 1, 0};
        int result = solve(nums);
        System.out.println(result);
    }

    private static int solve(int[] nums) {
        int n = nums.length;
        int windowSize = 0;
        for (int ele : nums)
            windowSize += ele == 1 ? 1 : 0;

        int max = 0;
        int count = 0;
        int left = 0;
        int right = 0;

        while (right < 2 * n) {
            while (right - left + 1 <= windowSize) {
                count += nums[right % n] == 1 ? 1 : 0;
                max = Math.max(max, count);
                right++;
            }
            count -= nums[left % n] == 1 ? 1 : 0;
            left++;

        }


        return windowSize - max;
    }
}
