package com.dynamicProgramming.Strings;

public class ShortestCommonSupersequence {
    public static void main(String[] args) {
        String str1 = "abac";
        String str2 = "cab";

        String result = solve(str1, str2);
        System.out.println(result);
    }

    private static String solve(String text1, String text2) {
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

        for (int[] rows : dp) {
            for (int ele : rows) {
                System.out.print(ele + " ");
            }
            System.out.println();
        }

        int i = m;
        int j = n;
        StringBuilder sb = new StringBuilder();

        while (i > 0 && j > 0) {
            if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                sb.append(text1.charAt(i - 1));
                i--;
                j--;
            } else if (dp[i - 1][j] > dp[i][j - 1]) {
                sb.append(text1.charAt(i - 1));
                i--;
            } else {
                sb.append(text2.charAt(j - 1));
                j--;
            }
        }

        while (i > 0) {
            sb.append(text1.charAt(i - 1));
            i--;
        }

        while (j > 0) {
            sb.append(text2.charAt(j - 1));
            j--;
        }


        return sb.reverse().toString();
    }


}
