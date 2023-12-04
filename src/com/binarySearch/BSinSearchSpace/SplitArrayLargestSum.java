package com.binarySearch.BSinSearchSpace;

public class SplitArrayLargestSum {
    public static void main(String[] args) {
        int[] nums = {2, 3, 1, 2, 4, 3};
        int k = 5;

        int result = solve(nums, k);
        System.out.println(result);
    }

    private static int solve(int[] nums, int k) {
        if (k > nums.length) return -1;

        int low = -1;
        int high = 0;
        for (int ele : nums) {
            high += ele;
            low = Math.max(low, ele);
        }

        if (k == nums.length) return low;
        if (k == 1) return high;

        int ans = 0;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (isPossible(nums, k, mid)) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return ans;
    }

    private static boolean isPossible(int[] nums, int k, int mid) {
        int currentPartition = 0;
        int count = 0;
        for (int ele : nums) {
            if (count + ele > mid) {
                currentPartition++;
                count = 0;
            }
            count += ele;

            if (currentPartition > k) return false;
        }
        if (count > 0) currentPartition++;

        return currentPartition <= k;
    }
}
