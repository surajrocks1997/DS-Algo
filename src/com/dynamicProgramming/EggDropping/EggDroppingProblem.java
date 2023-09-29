package com.dynamicProgramming.EggDropping;

public class EggDroppingProblem {
    public static void main(String[] args) {
        int n = 2; // eggs
        int k = 10; // floor
        int result = solve(n, k);
        System.out.println(result);
    }

    private static int solve(int n, int k) {
        if (k == 1 || k == 0) return k;
        if (n == 1) return k;

        int min = Integer.MAX_VALUE;
        int res;
        for (int i = 1; i <= k; i++) {
            int eggBroke = solve(n - 1, i - 1); //1 egg broke, check lower floors
            int eggNotBreak = solve(n, k - i); //egg did not break, check upper floors

            res = Math.max(eggBroke, eggNotBreak);
            if (res < min)
                min = res;
        }
        return 1 + min;
    }
}
