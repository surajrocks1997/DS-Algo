package com.dynamicProgramming.Strings.DistinctSubsequences;

public class DistinctSubsequences_Rec {
    public static void main(String[] args) {
        String s = "rabbbit";
        String t = "rabbit";

        int result = solve(s, t);
        System.out.println(result);
    }

    private static int solve(String s, String t) {
        int m = s.length();
        int n = t.length();
        return solve(m - 1, n - 1, s, t);
    }

    private static int solve(int i, int j, String s, String t) {
        if (j < 0) return 1;
        if (i < 0) return 0;

        if (s.charAt(i) == t.charAt(j))
            return solve(i - 1, j - 1, s, t) + solve(i - 1, j, s, t);

        return solve(i - 1, j, s, t);
    }
}
