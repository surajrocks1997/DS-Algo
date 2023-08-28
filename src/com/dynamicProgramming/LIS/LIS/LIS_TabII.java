package com.dynamicProgramming.LIS.LIS;

import java.util.*;

public class LIS_TabII {
    public static void main(String[] args) {
        int[] nums = {10, 9, 2, 5, 3, 7, 101, 18};

        int result = solve(nums);
        System.out.println(result);
    }

    private static int solve(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        int[] hash = new int[n];
        int lastIndex = 0;
        Arrays.fill(dp, 1);

        int maxi = 1;
        for (int index = 0; index < n; index++) {
            hash[index] = index;
            for (int prev = 0; prev < index; prev++) {
                if (nums[prev] < nums[index] && 1 + dp[prev] > dp[index]) {
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
        System.out.println(temp);

        return maxi;
    }
}
