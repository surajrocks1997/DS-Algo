package com.dynamicProgramming.Strings.DistinctSubsequences;

public class DistinctSubsequences_SpaceOpt {
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
        int[] prev = new int[m + 1];
        prev[0] = 1;

        for (int i = 1; i <= m; i++) {
            int[] curr = new int[m + 1];
            curr[0] = 1;
            for (int j = 1; j <= n; j++) {
                if (s.charAt(i - 1) == t.charAt(j - 1))
                    curr[j] = prev[j - 1] + prev[j];

                else curr[j] = prev[j];
            }
            prev = curr;
        }
        return prev[n];
    }
}
