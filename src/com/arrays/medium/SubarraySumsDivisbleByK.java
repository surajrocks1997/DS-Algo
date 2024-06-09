package com.arrays.medium;

import java.util.HashMap;
import java.util.Map;

//https://leetcode.com/problems/subarray-sums-divisible-by-k/
public class SubarraySumsDivisbleByK {
    public static void main(String[] args) {
        int[] nums = {-1, 2, 9};
        int k = 2;

        int result = solve(nums, k);
        System.out.println(result);
    }

    private static int solve(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);  // remainder , count

        int count = 0;
        int preSum = 0;
        for (int num : nums) {
            preSum += num;
            int remainder = ((preSum % k) + k) % k;

            count += map.getOrDefault(remainder, 0);

            map.put(remainder, map.getOrDefault(remainder, 0) + 1);
        }
        return count;
    }
}
