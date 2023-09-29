package com.dynamicProgramming.Strings.LongestPalindromicSubsequence;

public class LongestPalindromicSubsequence_Rec {
    public static void main(String[] args) {
        String s = "bbbab";

        int result = solve(s);
        System.out.println(result);

    }

    private static int solve(String s) {
        StringBuilder sb = new StringBuilder(s);
        String sReverse = sb.reverse().toString();
        return solve(s, sReverse, s.length() - 1, sReverse.length() - 1);
    }

    private static int solve(String str1, String str2, int m, int n) {
        if (m < 0 || n < 0) return 0;

        if (str1.charAt(m) == str2.charAt(n))
            return 1 + solve(str1, str2, m - 1, n - 1);

        return Math.max(solve(str1, str2, m - 1, n), solve(str1, str2, m, n - 1));
    }


}
