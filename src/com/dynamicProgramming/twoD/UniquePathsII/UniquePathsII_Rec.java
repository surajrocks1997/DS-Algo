package com.dynamicProgramming.twoD.UniquePathsII;

public class UniquePathsII_Rec {
    public static void main(String[] args) {
        int[][] obstacleGrid = {
                {0, 0, 0},
                {0, 1, 0},
                {0, 0, 0}
        };

        int result = solve(obstacleGrid);
        System.out.println(result);
    }

    private static int solve(int[][] obstacleGrid) {
        return find(obstacleGrid.length - 1, obstacleGrid[0].length - 1, obstacleGrid);
    }

    private static int find(int m, int n, int[][] obstacleGrid) {
        if (m >= 0 && n >= 0 && obstacleGrid[m][n] == 1) return 0;
        if (m == 0 && n == 0) return 1;
        if (m < 0 || n < 0) return 0;

        int up = find(m - 1, n, obstacleGrid);
        int left = find(m, n - 1, obstacleGrid);

        return up + left;
    }
}
