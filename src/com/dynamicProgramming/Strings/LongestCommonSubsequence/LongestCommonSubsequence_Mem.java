package com.dynamicProgramming.Strings.LongestCommonSubsequence;

import java.util.Arrays;

public class LongestCommonSubsequence_Mem {
    public static void main(String[] args) {
        String text1 = "abcde";
        String text2 = "ace";

        int result = solve(text1, text2);
        System.out.println(result);
    }

    //    index shifted by +1 for upcoming easy tabulation solution,
    //    else exact same solution from recursion conversion to Memoized solution will also work
    private static int solve(String text1, String text2) {
        int m = text1.length();
        int n = text2.length();
        int[][] dp = new int[m + 1][n + 1];
        for (int[] rows : dp) Arrays.fill(rows, -1);
        return solve(m, n, text1, text2, dp);
    }

    private static int solve(int index1, int index2, String str1, String str2, int[][] dp) {
        if (index1 == 0 || index2 == 0)
            return 0;

        if (dp[index1][index2] != -1) return dp[index1][index2];

        if (str1.charAt(index1 - 1) == str2.charAt(index2 - 1))
            return dp[index1][index2] = 1 + solve(index1 - 1, index2 - 1, str1, str2, dp);

        return dp[index1][index2] = Math.max(solve(index1 - 1, index2, str1, str2, dp), solve(index1, index2 - 1, str1, str2, dp));
    }
}
