package com.dynamicProgramming.oneD.frogJump;

public class FrogJump_Rec {
    public static void main(String[] args) {
        int n = 4;
        int[] heights = {10, 20, 30, 10};

        int result = solve(n, heights);
        System.out.println(result);
    }

    private static int solve(int n, int[] heights) {
        return solve1(n - 1, heights);
    }

    private static int solve1(int n, int[] heights) {
        if (n == 0) return 0;

        int jumpOne = solve1(n - 1, heights) + Math.abs(heights[n] - heights[n - 1]);
        int jumpTwo = Integer.MAX_VALUE;
        if (n > 1)
            jumpTwo = solve1(n - 2, heights) + Math.abs(heights[n] - heights[n - 2]);

        return Math.min(jumpOne, jumpTwo);
    }
}
