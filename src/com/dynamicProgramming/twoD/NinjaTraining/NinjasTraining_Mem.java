package com.dynamicProgramming.twoD.NinjaTraining;

import java.util.Arrays;

public class NinjasTraining_Mem {
    public static void main(String[] args) {
        int n = 4;
        int[][] points = {
                {2, 1, 3},
                {3, 4, 6},
                {10, 1, 6},
                {8, 3, 7}
        };

        int result = solve(n, points);
        System.out.println(result);
    }

    private static int solve(int n, int[][] points) {
        int[][] dp = new int[n][4];
        for (int[] row : dp) Arrays.fill(row, -1);
        return solve(n - 1, 3, points, dp);
    }

    private static int solve(int day, int last, int[][] points, int[][] dp) {
        if (dp[day][last] != -1) return dp[day][last];

        if (day == 0) {
            int maxi = Integer.MIN_VALUE;
            for (int i = 0; i < 3; i++) {
                if (i == last) continue;
                maxi = Math.max(maxi, points[day][i]);
            }
            return dp[day][last] = maxi;
        }

        int maxi = Integer.MIN_VALUE;
        for (int i = 0; i < 3; i++) {
            if (i == last) continue;
            maxi = Math.max(maxi, points[day][i] + solve(day - 1, i, points, dp));
        }

        return dp[day][last] = maxi;
    }
}
