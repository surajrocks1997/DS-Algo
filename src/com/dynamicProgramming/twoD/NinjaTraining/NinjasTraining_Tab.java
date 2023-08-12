package com.dynamicProgramming.twoD.NinjaTraining;

import java.util.Arrays;

public class NinjasTraining_Tab {
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
        dp[0][0] = Math.max(points[0][1], points[0][2]);
        dp[0][1] = Math.max(points[0][0], points[0][2]);
        dp[0][2] = Math.max(points[0][0], points[0][1]);
        dp[0][3] = Math.max(points[0][0], Math.max(points[0][1], points[0][2]));

        for (int day = 1; day < n; day++) {
            for (int last = 0; last < 4; last++) {
                dp[day][last] = 0;

                for (int task = 0; task < 3; task++) {
                    if (task != last)
                        dp[day][last] = Math.max(dp[day][last], points[day][task] + dp[day - 1][task]);
                }
            }
        }
        return dp[n - 1][3];
    }
}
