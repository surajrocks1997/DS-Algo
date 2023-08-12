package com.dynamicProgramming.twoD.NinjaTraining;

public class NinjasTraining_Opt {
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
        int[] prev = new int[4];
        prev[0] = Math.max(points[0][1], points[0][2]);
        prev[1] = Math.max(points[0][0], points[0][2]);
        prev[2] = Math.max(points[0][0], points[0][1]);
        prev[3] = Math.max(points[0][0], Math.max(points[0][1], points[0][2]));

        for (int day = 1; day < n; day++) {
            int[] temp = new int[4];
            for (int last = 0; last < 4; last++) {
                temp[last] = 0;

                for (int task = 0; task < 3; task++) {
                    if (task != last)
                        temp[last] = Math.max(temp[last], points[day][task] + prev[task]);
                }
            }
            prev = temp;
        }
        return prev[3];
    }
}
