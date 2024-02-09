package com.dynamicProgramming.Strings.DecodeWays;

public class DecodeWays_Rec {
    public static void main(String[] args) {
        String s = "2611055971756562";
        int result = solve(s);
        System.out.println(result);
    }

    private static int solve(String s) {
        return s.isEmpty() ? 0 : solve(0, s, s.length());
    }

    private static int solve(int index, String s, int n) {
        if (index == n) return 1;

        if (s.charAt(index) == '0') return 0;

        int left = solve(index + 1, s, n);
        int right = 0;
        if (index + 1 < n && (s.charAt(index) == '1' || s.charAt(index) == '2' && s.charAt(index + 1) <= '6'))
            right = solve(index + 2, s, n);

        return left + right;
    }
}
