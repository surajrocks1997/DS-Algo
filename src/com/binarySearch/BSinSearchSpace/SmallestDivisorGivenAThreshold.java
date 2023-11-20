package com.binarySearch.BSinSearchSpace;

// https://leetcode.com/problems/find-the-smallest-divisor-given-a-threshold/description/

public class SmallestDivisorGivenAThreshold {
    public static void main(String[] args) {
        int[] nums = {1, 2, 5, 9};
        int threshold = 6;

        int result = solve(nums, threshold);
        System.out.println(result);

    }

    private static int solve(int[] nums, int threshold) {
//        int max = Arrays.stream(nums).max().getAsInt();
//        if (nums.length == threshold) return max;

//        NOTE: rather than calculating max (O(n) costing), taking high as biggest value possible in test case would be faster

        int low = 1;
        int high = (int) 1e6;       // int high = max;

        while (high >= low) {
            int mid = low + ((high - low) / 2);

            int divideResult = 0;
            for (int ele : nums)
                divideResult += (int) Math.ceil((double) ele / (double) mid);

            if (divideResult <= threshold) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return low;
    }
}
