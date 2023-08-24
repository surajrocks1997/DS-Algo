package com.dynamicProgramming.Strings.WildcardMatching;

import java.util.Arrays;

public class WildcardMatching_Tab {
    public static void main(String[] args) {
        String p = "*cb*b";
        String s = "cbasdawadwabb";

        boolean result = solve(s, p);
        System.out.println(result);
    }

//    not giving right ans
    private static boolean solve(String s, String p) {
        int m = s.length();
        int n = p.length();
        boolean[][] dp = new boolean[m + 1][n + 1];

        dp[0][0] = true;
        for (int j = 1; j <= n; j++)
            dp[0][j] = false;

        for (int i = 1; i <= m; i++) {
            boolean flag = true;
            for (int index = 1; index <= i; index++) {
                if (p.charAt(index - 1) != '*') {
                    flag = false;
                    break;
                }
            }
            dp[i][0] = flag;
        }

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (s.charAt(i - 1) == p.charAt(j - 1) || p.charAt(j - 1) == '?')
                    dp[i][j] = dp[i - 1][j - 1];

                else if (p.charAt(j - 1) == '*')
                    dp[i][j] = dp[i][j - 1] || dp[i - 1][j];

                else dp[i][j] = false;
            }
        }
        return dp[m][n];
    }
}
