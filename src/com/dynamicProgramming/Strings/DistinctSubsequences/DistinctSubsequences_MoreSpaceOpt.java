package com.dynamicProgramming.Strings.DistinctSubsequences;

public class DistinctSubsequences_MoreSpaceOpt {
    public static void main(String[] args) {
        String s = "rabbbit";
        String t = "rabbit";

        int result = solve(s, t);
        System.out.println(result);
    }

    //    not passing all test cases
    private static int solve(String s, String t) {
        int m = s.length();
        int n = t.length();
        int[] prev = new int[n + 1];
        prev[0] = 1;

        for (int i = 1; i <= m; i++) {
            for (int j = n; j >= 1; j--) {
                if (s.charAt(i - 1) == t.charAt(j - 1))
                    prev[j] = prev[j - 1] + prev[j];

                else prev[j] = prev[j]; //can omit this statement
            }
        }
        return prev[n];
    }
}
