package com.dynamicProgramming.oneD.frogWithKJump;

public class FrogWithKJump_Rec {
    public static void main(String[] args) {
        int n = 4;
        int[] heights = {10, 20, 30, 40};
        int k = n;

        int result = solve(n, heights, k);
        System.out.println(result);
    }

    private static int solve(int n, int[] heights, int k) {
        return solve1(n - 1, heights, k);
    }

    private static int solve1(int n, int[] heights, int k) {
        if (n == 0) return 0;

        int minSteps = Integer.MAX_VALUE;

        for (int j = 1; j <= k; j++) {
            int jump = Integer.MAX_VALUE;
            if (n - j >= 0)
                jump = solve1(n - j, heights, k) + Math.abs(heights[n] - heights[n - j]);
            minSteps = Math.min(minSteps, jump);
        }

        return minSteps;
    }
}
