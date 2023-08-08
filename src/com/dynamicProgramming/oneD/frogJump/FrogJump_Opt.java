package com.dynamicProgramming.oneD.frogJump;

public class FrogJump_Opt {
    public static void main(String[] args) {
        int n = 4;
        int[] heights = {10, 20, 30, 10};

        int result = solve(n, heights);
        System.out.println(result);
    }

    private static int solve(int n, int[] heights) {
        int prev2 = 0;
        int prev = 0;

        for (int i = 1; i < n; i++) {
            int jumpOne = prev + Math.abs(heights[i] - heights[i - 1]);
            int jumpTwo = Integer.MAX_VALUE;

            if (i > 1)
                jumpTwo = prev2 + Math.abs(heights[i] - heights[i - 2]);

            int curri = Math.min(jumpOne, jumpTwo);

            prev2 = prev;
            prev = curri;
        }
        return prev;
    }
}
