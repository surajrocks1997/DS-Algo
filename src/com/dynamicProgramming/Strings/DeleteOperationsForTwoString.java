package com.dynamicProgramming.Strings;

public class DeleteOperationsForTwoString {
    public static void main(String[] args) {
        String text1 = "abcde";
        String text2 = "ace";

        int result = solve(text1, text2);
        System.out.println(result);
    }

    private static int solve(String text1, String text2) {
        int m = text1.length();
        int n = text2.length();
        int[][] dp = new int[m + 1][n + 1];

        for (int i = 0; i <= m; i++) dp[i][0] = 0;
        for (int i = 0; i <= n; i++) dp[0][i] = 0;

        for (int index1 = 1; index1 <= m; index1++) {
            for (int index2 = 1; index2 <= n; index2++) {
                if (text1.charAt(index1 - 1) == text2.charAt(index2 - 1))
                    dp[index1][index2] = 1 + dp[index1 - 1][index2 - 1];

                else dp[index1][index2] = Math.max(dp[index1 - 1][index2], dp[index1][index2 - 1]);
            }
        }

        int len = dp[m][n];
        return (m + n) - 2 * len;
    }
}
