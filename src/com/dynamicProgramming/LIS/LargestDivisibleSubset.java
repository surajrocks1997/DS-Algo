package com.dynamicProgramming.LIS;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class LargestDivisibleSubset {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3};

        List<Integer> result = solve(nums);
        System.out.println(result);
    }

    private static List<Integer> solve(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        int[] hash = new int[n];
        int lastIndex = 0;
        Arrays.fill(dp, 1);

        Arrays.sort(nums);

        int maxi = 1;
        for (int index = 0; index < n; index++) {
            hash[index] = index;
            for (int prev = 0; prev < index; prev++) {
                if (nums[index] % nums[prev] == 0 && 1 + dp[prev] > dp[index]) {
                    dp[index] = 1 + dp[prev];
                    hash[index] = prev;
                }
            }
            if (dp[index] > maxi) {
                maxi = dp[index];
                lastIndex = index;
            }
        }

        List<Integer> temp = new ArrayList<>();
        temp.add(nums[lastIndex]);

        while (hash[lastIndex] != lastIndex) {
            lastIndex = hash[lastIndex];
            temp.add(nums[lastIndex]);
        }

//        LIS print in reverse hash array
        Collections.reverse(temp);

        return temp;
    }
}
