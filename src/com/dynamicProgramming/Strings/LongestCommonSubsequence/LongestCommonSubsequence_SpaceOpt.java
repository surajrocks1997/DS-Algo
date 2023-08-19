package com.dynamicProgramming.Strings.LongestCommonSubsequence;

public class LongestCommonSubsequence_SpaceOpt {
    public static void main(String[] args) {
        String text1 = "abcde";
        String text2 = "ace";

        int result = solve(text1, text2);
        System.out.println(result);
    }

    private static int solve(String text1, String text2) {
        int m = text1.length();
        int n = text2.length();
        int[] prev = new int[n + 1];

        for (int i = 0; i <= m; i++) prev[0] = 0;

        for (int index1 = 1; index1 <= m; index1++) {
            int[] curr = new int[n + 1];
            for (int index2 = 1; index2 <= n; index2++) {
                if (text1.charAt(index1 - 1) == text2.charAt(index2 - 1))
                    curr[index2] = 1 + prev[index2 - 1];

                else curr[index2] = Math.max(prev[index2], curr[index2 - 1]);
            }
            prev = curr;
        }

        return prev[n];
    }
}
