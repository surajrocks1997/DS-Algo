package com.arrays;

public class LongestPalindromicSubstring {
    public static void main(String[] args) {
        String s = "babad";
        String result = solve(s);
        System.out.println(result);
    }

    private static String solve(String s) {
        int[] ans = new int[3];     //len, left, right
        for (int i = 0; i < s.length(); i++) {
            int[] len1 = expandFromCentre(s, i, i + 1);
            int[] len2 = expandFromCentre(s, i, i);

            int len1len = len1[1] - len1[0] + 1;
            int len2len = len2[1] - len2[0] + 1;

            if (len1len > len2len) {
                if (len1len > ans[0]) {
                    ans[0] = len1len;
                    ans[1] = len1[0];
                    ans[2] = len1[1];
                }
            } else {
                if (len2len > ans[0]) {
                    ans[0] = len2len;
                    ans[1] = len2[0];
                    ans[2] = len2[1];
                }
            }

        }

        return s.substring(ans[1], ans[2] + 1);

    }

    private static int[] expandFromCentre(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        return new int[]{left + 1, right - 1};
    }
}
