package com.SlidingWindow_2Pointer.hard;

import java.util.HashMap;
import java.util.Map;

public class SubArray_K_Different_Integers {

    public static void main(String[] args) {
        int[] nums = {1, 2, 1, 3, 4};
        int k = 3;

        int result = solve(nums, k);
        System.out.println(result);
    }

    private static int solve(int[] nums, int k) {
        int n = nums.length;
        Map<Integer, Integer> map = new HashMap<>();
        int l_far = 0, l_near = 0;
        int count = 0;

        int r = 0;
        while (r < n) {
            map.put(nums[r], map.getOrDefault(nums[r], 0) + 1);

            while (map.size() > k) {
                map.put(nums[l_near], map.get(nums[l_near]) - 1);
                if (map.get(nums[l_near]) == 0)
                    map.remove(nums[l_near]);
                l_near++;
                l_far = l_near;
            }

            while (map.get(nums[l_near]) > 1) {
                map.put(nums[l_near], map.get(nums[l_near]) - 1);
                l_near++;
            }

            if (map.size() == k)
                count += l_near - l_far + 1;

            r++;
        }

        return count;
    }
}