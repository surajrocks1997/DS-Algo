package com.dynamicProgramming.twoD.UniquePaths;

public class UniquePaths_Rec {
    public static void main(String[] args) {
        int m = 3;
        int n = 7;

        int result = solve(m, n);
        System.out.println(result);
    }

    private static int solve(int m, int n) {
        return find(m - 1, n - 1);
    }

    private static int find(int m, int n) {
        if (m == 0 && n == 0) return 1;
        if (m < 0 || n < 0) return 0;

        int up = find(m - 1, n);
        int left = find(m, n - 1);

        return up + left;
    }
}
