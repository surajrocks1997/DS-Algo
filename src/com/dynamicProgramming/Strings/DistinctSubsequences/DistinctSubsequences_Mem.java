package com.dynamicProgramming.Strings.DistinctSubsequences;

import java.util.Arrays;

public class DistinctSubsequences_Mem {
    public static void main(String[] args) {
        String s = "rabbbit";
        String t = "rabbit";

        int result = solve(s, t);
        System.out.println(result);
    }

    private static int solve(String s, String t) {
        int m = s.length();
        int n = t.length();
        int[][] dp = new int[m + 1][n + 1];
        for (int[] rows : dp) Arrays.fill(rows, -1);
        return solve(m, n, s, t, dp);
    }

    private static int solve(int i, int j, String s, String t, int[][] dp) {
        if (j == 0) return 1;
        if (i == 0) return 0;

        if (dp[i][j] != -1) return dp[i][j];

        if (s.charAt(i - 1) == t.charAt(j - 1))
            return dp[i][j] = solve(i - 1, j - 1, s, t, dp) + solve(i - 1, j, s, t, dp);

        return dp[i][j] = solve(i - 1, j, s, t, dp);
    }
}
