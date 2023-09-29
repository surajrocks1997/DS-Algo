package com.dynamicProgramming.Strings.LongestCommonSubstring;

public class LongestCommonSubstring_Rec {
    public static void main(String[] args) {
        String str1 = "abcjklp";
        String str2 = "acjkp";

        int result = solve(str1, str2);
        System.out.println(result);
    }

    private static int solve(String str1, String str2) {
        int[] ans = new int[2];
        solve(str1.length() - 1, str1, str2.length() - 1, str2, ans);
        return ans[1];
    }

    private static void solve(int m, String str1, int n, String str2, int[] ans) {
        if (m < 0 || n < 0) return;

        if (str1.charAt(m) == str2.charAt(n)) {
            ans[0]++;
            ans[1] = Math.max(ans[0], ans[1]);
            solve(m - 1, str1, n - 1, str2, ans);
        }

        ans[0] = 0;

        solve(m, str1, n - 1, str2, ans);
        solve(m - 1, str1, n, str2, ans);

    }
}
