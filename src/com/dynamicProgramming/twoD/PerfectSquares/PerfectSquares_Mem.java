package com.dynamicProgramming.twoD.PerfectSquares;


import java.util.Arrays;

public class PerfectSquares_Mem {

    public static void main(String[] args) {
        int n = 15;
        int result = solve(n);
        System.out.println(result);
    }

    private static int solve(int n) {
        int x = (int) Math.sqrt(n);
        int[][] dp = new int[n + 1][x + 1];
        for (int[] rows : dp) {
            Arrays.fill(rows, -1);
        }
        return solve(n, x, dp);
    }

    private static int solve(int n, int sqrt, int[][] dp) {
        if (n <= 3) return n;

        if (dp[n][sqrt] != -1) return dp[n][sqrt];

        int min = Integer.MAX_VALUE;
        for (int i = sqrt; i >= 2; i--) {
            int x = n - (int) Math.pow(i, 2);
            min = Math.min(min, solve(x, (int) Math.sqrt(x), dp));
        }

        return dp[n][sqrt] = 1 + min;

    }
}