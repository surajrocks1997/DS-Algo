package com.dynamicProgramming.Strings.LongestPalindromicSubsequence;

import java.util.Arrays;

public class LongestPalindromicSubsequence_Mem {
    public static void main(String[] args) {
        String s = "bbbab";

        int result = solve(s);
        System.out.println(result);

    }

    private static int solve(String s) {
        StringBuilder sb = new StringBuilder(s);
        String sReverse = sb.reverse().toString();
        int[][] dp = new int[s.length()][sReverse.length()];
        for (int[] rows : dp)
            Arrays.fill(rows, -1);
        return solve(s, sReverse, s.length() - 1, sReverse.length() - 1, dp);
    }

    private static int solve(String str1, String str2, int m, int n, int[][] dp) {
        if (m < 0 || n < 0) return 0;

        if (dp[m][n] != -1) return dp[m][n];

        if (str1.charAt(m) == str2.charAt(n))
            return 1 + solve(str1, str2, m - 1, n - 1, dp);

        return dp[m][n] = Math.max(solve(str1, str2, m - 1, n, dp), solve(str1, str2, m, n - 1, dp));
    }


}
