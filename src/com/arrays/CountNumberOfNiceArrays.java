package com.arrays;

import java.util.HashMap;
import java.util.Map;

// https://leetcode.com/problems/count-number-of-nice-subarrays/
public class CountNumberOfNiceArrays {
    public static void main(String[] args) {
        int[] nums = {2,2,2,1,2,2,1,2,2,2};
        int k = 2;

        int result = solve(nums, k);
        System.out.println(result);
    }

    private static int solve(int[] nums, int k) {
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            nums[i] = nums[i] % 2 == 0 ? 0 : 1;
        }

        if (n == 1 && nums[0] != k) return 0;

        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        int prefixSum = 0;
        int count = 0;

        int index = 0;
        while (index < n) {
            prefixSum += nums[index];
            int rem = prefixSum - k;

            count += map.getOrDefault(rem, 0);

            map.put(prefixSum, map.getOrDefault(prefixSum, 0) + 1);
            index++;
        }

        return count;
    }
}
