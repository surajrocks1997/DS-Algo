package com.dynamicProgramming.Strings.LongestPalindromicSubsequence;

import java.util.Arrays;

public class LongestPalindromicSubsequence_Tab {
    public static void main(String[] args) {
        String s = "bbbab";

        int result = solve(s);
        System.out.println(result);

    }

    private static int solve(String s) {
        StringBuilder sb = new StringBuilder(s);
        String sReverse = sb.reverse().toString();
        int m = s.length();
        int n = sReverse.length();
        int[][] dp = new int[m + 1][n + 1];

        for (int i = 0; i <= n; i++) dp[0][i] = 0;
        for (int i = 0; i <= m; i++) dp[i][0] = 0;

        for (int index1 = 1; index1 <= m; index1++) {
            for (int index2 = 1; index2 <= n; index2++) {
                if (s.charAt(index1 - 1) == sReverse.charAt(index2 - 1))
                    dp[index1][index2] = 1 + dp[index1 - 1][index2 - 1];

                else dp[index1][index2] = Math.max(dp[index1 - 1][index2], dp[index1][index2 - 1]);
            }
        }

        return dp[m][n];
    }
}
