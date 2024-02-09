package com.dynamicProgramming.Strings.DecodeWays;

public class DecodeWays_Tab {
    public static void main(String[] args) {
        String s = "2611055971756562";
        int result = solve(s);
        System.out.println(result);
    }

    private static int solve(String s) {
        if (s.isEmpty()) return 0;
        int n = s.length();
        int[] dp = new int[n + 1];
        dp[n] = 1;

        for (int index = n - 1; index >= 0; index--) {
            if (s.charAt(index) == '0') {
                dp[index] = 0;
                continue;
            }

            int left = dp[index + 1];
            int right = 0;
            if (index + 1 < n && (s.charAt(index) == '1' || s.charAt(index) == '2' && s.charAt(index + 1) <= '6'))
                right = dp[index + 2];

            dp[index] = left + right;
        }

        return dp[0];
    }

    private static int solve(int index, String s, int n, int[] dp) {
        if (index == n) return 1;

        if (dp[index] != -1) return dp[index];

        if (s.charAt(index) == '0') return 0;

        int left = solve(index + 1, s, n, dp);
        int right = 0;
        if (index + 1 < n && (s.charAt(index) == '1' || s.charAt(index) == '2' && s.charAt(index + 1) <= '6'))
            right = solve(index + 2, s, n, dp);

        return dp[index] = left + right;
    }
}
