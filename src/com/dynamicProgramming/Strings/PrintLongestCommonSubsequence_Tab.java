package com.dynamicProgramming.Strings;

public class PrintLongestCommonSubsequence_Tab {
    public static void main(String[] args) {
        String s1 = "ldxgoohkumo";
        String s2 = "cqyxwraowfz";
        int m = s1.length();
        int n = s2.length();

        String result = solve(m, n, s1, s2);
        System.out.println(result);
    }

//    check striver intuitive solution of tabulation

    private static String solve(int m, int n, String text1, String text2) {
        m = text1.length();
        n = text2.length();
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
        System.out.println(len);
        int i = m;
        int j = n;
        StringBuilder ans = new StringBuilder();

        while (i > 0 && j > 0) {
            if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                ans.insert(0, text1.charAt(i - 1));
                i--;
                j--;
            } else if (dp[i - 1][j] > dp[i][j - 1]) {
                i--;
            } else {
                j--;
            }
        }

        return ans.toString();
    }
}
