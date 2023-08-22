package com.dynamicProgramming.Strings.EditDistance;

public class EditDistance_Rec {
    public static void main(String[] args) {
        String word1 = "intention";
        String word2 = "execution";

        int result = solve(word1, word2);
        System.out.println(result);
    }

    private static int solve(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();
        return solve(m - 1, n - 1, word1, word2);
    }

    private static int solve(int i, int j, String word1, String word2) {
        if (i < 0) return j + 1;
        if (j < 0) return i + 1;

        if (word1.charAt(i) == word2.charAt(j))
            return solve(i - 1, j - 1, word1, word2);

        int insert = 1 + solve(i, j - 1, word1, word2);
        int delete = 1 + solve(i - 1, j, word1, word2);
        int replace = 1 + solve(i - 1, j - 1, word1, word2);

        return Math.min(insert, Math.min(delete, replace));
    }
}
