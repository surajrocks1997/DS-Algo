package com.dynamicProgramming.Strings.WildcardMatching;

import java.util.Arrays;

public class WildcardMatching_Mem {
    public static void main(String[] args) {
        String p = "*cb*b";
        String s = "cbasdawadwabb";

        boolean result = solve(s, p);
        System.out.println(result);
    }

    private static boolean solve(String s, String p) {
        int m = s.length();
        int n = p.length();
        int[][] dp = new int[m+1][n+1];
        for (int[] rows : dp) Arrays.fill(rows, -1);
        return solve(m, n, s, p, dp);
    }


//    again shifting index by +1 for tabulation solution
    private static boolean solve(int stri, int patternj, String str, String pattern, int[][] dp) {
        if (stri == 0 && patternj == 0) return true;
        if (patternj == 0 && stri > 0) return false;
        if (patternj > 0 && stri == 0) {
            for (int index = 1; index <= patternj; index++)
                if (pattern.charAt(index-1) != '*')
                    return false;
            return true;
        }

        if (dp[stri][patternj] != -1) return dp[stri][patternj] == 1;

        if (str.charAt(stri-1) == pattern.charAt(patternj-1) || pattern.charAt(patternj-1) == '?') {
            boolean solve = solve(stri - 1, patternj - 1, str, pattern, dp);
            dp[stri][patternj] = solve ? 1 : 0;
            return solve;
        }

        if (pattern.charAt(patternj-1) == '*') {
            boolean solve1 = solve(stri, patternj - 1, str, pattern, dp);
            boolean solve2 = solve(stri - 1, patternj, str, pattern, dp);
            dp[stri][patternj] = solve1 || solve2 ? 1 : 0;
            return solve1 || solve2;
        }

        dp[stri][patternj] = 0;
        return false;
    }
}
