package com.dynamicProgramming.Strings.EditDistance;

import java.util.Arrays;

public class EditDistance_Mem {
    public static void main(String[] args) {
        String word1 = "intention";
        String word2 = "execution";

        int result = solve(word1, word2);
        System.out.println(result);
    }

    //    shifting index with +1 for tabulation solution
    private static int solve(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();
        int[][] dp = new int[m + 1][n + 1];
        for (int[] rows : dp) Arrays.fill(rows, -1);
        return solve(m, n, word1, word2, dp);
    }

    private static int solve(int i, int j, String word1, String word2, int[][] dp) {
        if (i == 0) return j;
        if (j == 0) return i;

        if (dp[i][j] != -1) return dp[i][j];

        if (word1.charAt(i - 1) == word2.charAt(j - 1))
            return dp[i][j] = solve(i - 1, j - 1, word1, word2, dp);

        int insert = 1 + solve(i, j - 1, word1, word2, dp);
        int delete = 1 + solve(i - 1, j, word1, word2, dp);
        int replace = 1 + solve(i - 1, j - 1, word1, word2, dp);

        return dp[i][j] = Math.min(insert, Math.min(delete, replace));
    }
}
