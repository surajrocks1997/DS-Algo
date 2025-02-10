package com.dynamicProgramming.twoD;

import java.util.Arrays;

// https://leetcode.com/problems/regular-expression-matching
public class RegularExpressionMatching {
    public static void main(String[] args) {
        String s = "aa";
        String p = "a*";

        boolean result = solve(s, p);
        System.out.println(result);
    }

    private static boolean solve(String s, String p) {
        int m = s.length();
        int n = p.length();
        int[][] dp = new int[m + 1][n + 1];
        for (int[] row : dp)
            Arrays.fill(row, -1);
        return solve(s, 0, p, 0, dp);
    }

    private static boolean solve(String s, int i, String p, int j, int[][] dp) {
        if (i >= s.length() && j >= p.length()) return true;
        if (j >= p.length()) return false;

        if (dp[i][j] != -1) return dp[i][j] == 1;

        boolean match = i < s.length() && (s.charAt(i) == p.charAt(j) || p.charAt(j) == '.');

        if (j + 1 < p.length() && p.charAt(j + 1) == '*') {
            if (solve(s, i, p, j + 2, dp) || (match && solve(s, i + 1, p, j, dp))) {
                dp[i][j] = 1;
                return true;
            }

        }

        if (match) {
            if (solve(s, i + 1, p, j + 1, dp)) {
                dp[i][j] = 1;
                return true;
            }
        }

        dp[i][j] = 0;
        return false;
    }
}