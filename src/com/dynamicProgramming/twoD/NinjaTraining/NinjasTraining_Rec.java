package com.dynamicProgramming.twoD.NinjaTraining;

public class NinjasTraining_Rec {
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
        return solve(n - 1, 3, points);
    }

    private static int solve(int day, int last, int[][] points) {
        if (day == 0) {
            int maxi = Integer.MIN_VALUE;
            for (int i = 0; i < 3; i++) {
                if (i == last) continue;
                maxi = Math.max(maxi, points[day][i]);
            }
            return maxi;
        }

        int maxi = Integer.MIN_VALUE;
        for (int i = 0; i < 3; i++) {
            if (i == last) continue;
            maxi = Math.max(maxi, points[day][i] + solve(day - 1, i, points));
        }

        return maxi;
    }
}
