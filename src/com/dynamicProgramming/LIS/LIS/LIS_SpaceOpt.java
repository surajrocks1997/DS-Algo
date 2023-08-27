package com.dynamicProgramming.LIS.LIS;

public class LIS_SpaceOpt {
    public static void main(String[] args) {
        int[] nums = {10, 9, 2, 5, 3, 7, 101, 18};

        int result = solve(nums);
        System.out.println(result);
    }

    //    shifting index by +1 of prev so could be memoized
    // done by simply adding +1 to prev
    private static int solve(int[] nums) {
        int n = nums.length;
        int[] next = new int[n + 1];
        int[] curr = new int[n + 1];

//        base case not required as value is 0

        for (int index = n - 1; index >= 0; index--) {
            for (int prev = index - 1; prev >= -1; prev--) {
                int notTake = next[prev + 1];

                int take = 0;
                if (prev == -1 || nums[index] > nums[prev])
                    take = 1 + next[index + 1];

                curr[prev + 1] = Math.max(take, notTake);
            }
            next = curr;
        }

        return next[-1 + 1];
    }
}
