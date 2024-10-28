package com.dynamicProgramming;

import java.util.Arrays;

// https://leetcode.com/problems/count-square-submatrices-with-all-ones/description/
public class CountSquareSubmatricesWithAllOnes {
    public static void main(String[] args) {
        int[][] matrix = {
                {0, 1, 1, 1},
                {1, 1, 1, 1},
                {0, 1, 1, 1}
        };
        int result = solve(matrix);
        System.out.println(result);
    }

    private static int solve(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;

        int[][] dp = new int[m][n];

        for (int[] row : dp)
            Arrays.fill(row, -1);

        int result = 0;

        for (int row = 0; row < m; row++) {
            for (int col = 0; col < n; col++) {
                result += dfs(matrix, row, col, m, n, dp);
            }
        }

        return result;

    }

    private static int dfs(int[][] matrix, int row, int col, int m, int n, int[][] dp) {
        if (row == m || col == n || matrix[row][col] == 0) return 0;

        if(dp[row][col] != -1) return dp[row][col];

        int length = 1 + Math.min(
                dfs(matrix, row + 1, col, m, n, dp),
                Math.min(
                        dfs(matrix, row + 1, col + 1, m, n, dp),
                        dfs(matrix, row, col + 1, m, n, dp)
                )
        );

        return dp[row][col] = length;
    }
}
