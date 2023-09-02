package com.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FourSum {
    public static void main(String[] args) {
        int[] nums = {1, 0, -1, 0, -2, 2};
        int target = 0;

        List<List<Integer>> result = solve(nums, target);
        System.out.println(result);
    }

    //    generalized kSum solution
    private static List<List<Integer>> solve(int[] nums, int target) {
        Arrays.sort(nums);
        int k = 4; // as it is 4 sum problem
        return kSums(nums, 0, k, target);
    }

    private static List<List<Integer>> kSums(int[] nums, int start, int k, int target) {
        int n = nums.length;
        List<List<Integer>> res = new ArrayList<>();

        if (k == 2) {
            int left = start;
            int right = n - 1;
            while (left < right) {
                if (nums[left] + nums[right] == target) {
                    List<Integer> curr = new ArrayList<>();
                    curr.add(nums[left]);
                    curr.add(nums[right]);
                    res.add(curr);

                    while (left < right && nums[left] == nums[left + 1]) left++;
                    left++;

                    while (left < right && nums[right] == nums[right - 1]) right--;
                    right--;
                } else if (nums[left] + nums[right] > target) {
                    right--;
                } else {
                    left++;
                }
            }
        } else {
            for (int i = start; i < n - (k - 1); i++) {
                if (i > start && nums[i] == nums[i - 1]) continue;

                List<List<Integer>> curr = kSums(nums, i + 1, k - 1, target - nums[i]);
                for (List<Integer> temp : curr)
                    temp.add(0, nums[i]);

                res.addAll(curr);
            }
        }
        return res;
    }
}
