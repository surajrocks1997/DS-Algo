package com.dynamicProgramming.intro;

public class Fibonacci_Opt {
    public static void main(String[] args) {
        int n = 4;

        int result = solve(n);
        System.out.println(result);
    }

    private static int solve(int n) {
        int prev2 = 0;
        int prev = 1;
        int curri = 0;

        for (int i = 2; i < n + 1; i++) {
            curri = prev + prev2;
            prev2 = prev;
            prev = curri;
        }

        return prev;
    }
}
