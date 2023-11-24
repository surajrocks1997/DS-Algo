package com.dynamicProgramming.LIS.LargestDivisibleSubset;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LargestDivisibleSubset_Mem {

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        List<Integer> result = solve(nums);
        System.out.println(result);
    }

    static List<Integer> result;
    static int[] dp;

    private static List<Integer> solve(int[] nums) {
        List<Integer> ans = new ArrayList<>();
        Arrays.sort(nums);
        result = new ArrayList<>();
        dp = new int[nums.length + 1];
        Arrays.fill(dp, -1);
        solve(0, -1, ans, nums);
        return result;
    }

    private static void solve(int index, int prev, List<Integer> ans, int[] nums) {
        if (index == nums.length) {
            if (ans.size() >= result.size()) {
                result.clear();
                result.addAll(ans);
            }
            return;
        }

        if (ans.size() > dp[index] && (prev == -1 || nums[index] % nums[prev] == 0)) {
            dp[index] = ans.size();
            ans.add(nums[index]);
            solve(index + 1, index, ans, nums);
            ans.remove(ans.size() - 1);
        }
        solve(index + 1, prev, ans, nums);
    }
}