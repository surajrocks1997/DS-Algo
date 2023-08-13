package com.dynamicProgramming.twoD.MinFallingPathSum;

import java.util.Arrays;

public class MinFallingPathSum_Mem {
    public static void main(String[] args) {
        int[][] matrix = {
                {2, 1, 3},
                {6, 5, 4},
                {7, 8, 9}
        };

        int result = solve(matrix);
        System.out.println(result);
    }

    private static int solve(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;

        int[][] dp = new int[m][n];
        for (int[] rows : dp) Arrays.fill(rows, -1);

        int min = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            min = Math.min(min, solve(n - 1, i, n, matrix, dp));
        }
        return min;
    }

    private static int solve(int row, int col, int size, int[][] matrix, int[][] dp) {
        if (col < 0 || col >= size) return (int) 1e9;
        if (row == 0) return matrix[row][col];

        if (dp[row][col] != -1) return dp[row][col];

        int up = matrix[row][col] + solve(row - 1, col, size, matrix, dp);
        int upDiagLeft = matrix[row][col] + solve(row - 1, col - 1, size, matrix, dp);
        int upDiagRight = matrix[row][col] + solve(row - 1, col + 1, size, matrix, dp);

        return dp[row][col] = Math.min(up, Math.min(upDiagLeft, upDiagRight));
    }
}
