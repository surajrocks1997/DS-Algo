package com.dynamicProgramming.oneD.frogJump;

import java.util.Arrays;

public class FrogJump_Tab {
    public static void main(String[] args) {
        int n = 4;
        int[] heights = {10, 20, 30, 10};

        int result = solve(n, heights);
        System.out.println(result);
    }

    private static int solve(int n, int[] heights) {
        int[] dp = new int[n];
        Arrays.fill(dp, -1);

        dp[0] = 0;

        for (int i = 1; i < n; i++) {
            int jumpOne = dp[i - 1] + Math.abs(heights[i] - heights[i - 1]);
            int jumpTwo = Integer.MAX_VALUE;

            if (i > 1)
                jumpTwo = dp[i - 2] + Math.abs(heights[i] - heights[i - 2]);

            dp[i] = Math.min(jumpOne, jumpTwo);
        }
        return dp[n-1];
    }
}
