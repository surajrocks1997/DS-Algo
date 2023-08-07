package com.dynamicProgramming.intro;

import java.util.Arrays;

public class Fibonacci_Mem {
    public static void main(String[] args) {
        int n = 4;

        int result = solve(n);
        System.out.println(result);
    }

    private static int solve(int n) {
        int[] dp = new int[n + 1];
        Arrays.fill(dp, -1);

        return solve(n, dp);
    }

    private static int solve(int n, int[] dp) {
        if (n <= 1) return n;

        if (dp[n] != -1) return dp[n];

        return dp[n] = solve(n - 1) + solve(n - 2);
    }
}
