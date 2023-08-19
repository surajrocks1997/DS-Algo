package com.dynamicProgramming.Strings.LongestCommonSubsequence;

public class LongestCommonSubsequence_Rec {
    public static void main(String[] args) {
        String text1 = "abcde";
        String text2 = "ace";

        int result = solve(text1, text2);
        System.out.println(result);
    }

    private static int solve(String text1, String text2) {
        return solve(text1.length() - 1, text2.length() - 1, text1, text2);
    }

    private static int solve(int index1, int index2, String str1, String str2) {
        if (index1 < 0 || index2 < 0)
            return 0;

        if (str1.charAt(index1) == str2.charAt(index2))
            return 1 + solve(index1 - 1, index2 - 1, str1, str2);

        return Math.max(solve(index1 - 1, index2, str1, str2), solve(index1, index2 - 1, str1, str2));
    }
}
