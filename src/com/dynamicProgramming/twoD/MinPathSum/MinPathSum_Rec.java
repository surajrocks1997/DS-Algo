package com.dynamicProgramming.twoD.MinPathSum;

public class MinPathSum_Rec {
    public static void main(String[] args) {
        int[][] grid = {
                {1, 3, 1},
                {1, 5, 1},
                {4, 2, 1}
        };

        int result = solve(grid);
        System.out.println(result);
    }

    private static int solve(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        return solve(m - 1, n - 1, grid);
    }

    private static int solve(int m, int n, int[][] grid) {
        if (m == 0 && n == 0)
            return grid[m][n];
        if (m < 0 || n < 0) return (int) 1e9;

        int up = grid[m][n] + solve(m - 1, n, grid);
        int left = grid[m][n] + solve(m, n - 1, grid);

        return Math.min(up, left);
    }
}
