package com.dynamicProgramming.Strings.DecodeWays;

import java.util.Arrays;

public class DecodeWays_Mem {
    public static void main(String[] args) {
        String s = "2611055971756562";
        int result = solve(s);
        System.out.println(result);
    }

    private static int solve(String s) {
        if (s.isEmpty()) return 0;
        int n = s.length();
        int[] dp = new int[n];
        Arrays.fill(dp, -1);

        return solve(0, s, n, dp);
    }

    private static int solve(int index, String s, int n, int[] dp) {
        if (index == n) return 1;

        if (dp[index] != -1) return dp[index];

        if (s.charAt(index) == '0') return 0;

        int left = solve(index + 1, s, n, dp);
        int right = 0;
        if (index + 1 < n && (s.charAt(index) == '1' || s.charAt(index) == '2' && s.charAt(index + 1) <= '6'))
            right = solve(index + 2, s, n, dp);

        return dp[index] = left + right;
    }
}
