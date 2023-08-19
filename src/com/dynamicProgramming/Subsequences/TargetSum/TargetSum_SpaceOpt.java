package com.dynamicProgramming.Subsequences.TargetSum;

import java.util.Arrays;

public class TargetSum_SpaceOpt {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 1};
        int target = 3;

        int result = solve(nums, target);
        System.out.println(result);
    }

    private static int solve(int[] nums, int target) {
        int totalSum = Arrays.stream(nums).sum();

        if ((totalSum - target) % 2 == 1) return 0;
        if (totalSum - target < 0) return 0;

        int sum = (totalSum - target) / 2;

        int n = nums.length;
        int[] prev = new int[sum + 1];

        if (nums[0] == 0) prev[0] = 2;
        else prev[0] = 1;

        if (nums[0] != 0 && sum >= nums[0]) prev[nums[0]] = 1;

        for (int index = 1; index < n; index++) {
            int[] curr = new int[sum + 1];
            for (int tar = 0; tar <= sum; tar++) {

                int notPick = prev[tar];

                int pick = 0;
                if (nums[index] <= tar)
                    pick = prev[tar - nums[index]];

                curr[tar] = pick + notPick;
            }
            prev = curr;
        }

        return prev[sum];
    }
}
