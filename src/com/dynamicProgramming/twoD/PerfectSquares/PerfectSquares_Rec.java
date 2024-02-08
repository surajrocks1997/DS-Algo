package com.dynamicProgramming.twoD.PerfectSquares;


// https://leetcode.com/problems/perfect-squares/description/

public class PerfectSquares_Rec {

    public static void main(String[] args) {
        int n = 15;
        int result = solve(n);
        System.out.println(result);
    }

    private static int solve(int n) {
        int x = (int) Math.sqrt(n);
        return solve(n, x);
    }

    private static int solve(int n, int sqrt) {
        if (n <= 3) return n;

        int min = Integer.MAX_VALUE;
        for (int i = sqrt; i >= 2; i--) {
            int x = n - (int) Math.pow(i, 2);
            min = Math.min(min, solve(x, (int) Math.sqrt(x)));
        }

        return 1 + min;

    }
}