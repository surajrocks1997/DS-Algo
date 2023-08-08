package com.dynamicProgramming.oneD.frogJump;

import java.util.Arrays;

public class FrogJump_Mem {
    public static void main(String[] args) {
        int n = 4;
        int[] heights = {10, 20, 30, 10};

        int result = solve(n, heights);
        System.out.println(result);
    }

    private static int solve(int n, int[] heights) {
        int[] dp = new int[n];
        Arrays.fill(dp, -1);
        return solve(n - 1, dp, heights);
    }

    private static int solve(int n, int[] dp, int[] heights) {
        if (n == 0) return 0;
        if (dp[n] != -1) return dp[n];

        int jumpOne = solve(n - 1, dp, heights) + Math.abs(heights[n] - heights[n - 1]);
        int jumpTwo = Integer.MAX_VALUE;
        if (n > 1)
            jumpTwo = solve(n - 2, dp, heights) + Math.abs(heights[n] - heights[n - 2]);

        return dp[n] = Math.min(jumpOne, jumpTwo);
    }
}
