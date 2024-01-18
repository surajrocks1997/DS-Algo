package com.recursion.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubsetI {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3};
        List<List<Integer>> result = solve(arr);
        System.out.println(result);
    }

    private static List<List<Integer>> solve(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> current = new ArrayList<>();
        solve(0, nums, current, result);
        return result;
    }

    private static void solve(int index, int[] nums, List<Integer> current, List<List<Integer>> result) {
        if (index == nums.length) {
            result.add(new ArrayList<>(current));
            return;
        }

        current.add(nums[index]);
        solve(index + 1, nums, current, result);

        current.remove(current.size() - 1);
        solve(index + 1, nums, current, result);
    }
}
