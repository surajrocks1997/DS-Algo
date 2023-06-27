package com.recursion.medium;

import java.util.ArrayList;
import java.util.List;

public class Subsequences {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4};
        List<List<Integer>> res = solve(nums);
        System.out.println(res);
    }

    private static List<List<Integer>> solve(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> current = new ArrayList<>();
        generate(result, current, nums, 0);
        return result;
    }

    private static void generate(List<List<Integer>> result, List<Integer> current, int[] nums, int index) {
        if (index >= nums.length) {
            result.add(new ArrayList<>(current));
            return;
        }

        current.add(nums[index]);
        generate(result, current, nums, index + 1);
        current.remove(current.size() - 1);
        generate(result, current, nums, index + 1);

    }
}
