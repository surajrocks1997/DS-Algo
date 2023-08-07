package com.dynamicProgramming.intro;

public class Fibonacci_Tab {
    public static void main(String[] args) {
        int n = 4;

        int result = solve(n);
        System.out.println(result);
    }

    private static int solve(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;
        for (int i = 2; i < n + 1; i++)
            dp[i] = dp[i - 1] + dp[i - 2];

        return dp[n];
    }
}
