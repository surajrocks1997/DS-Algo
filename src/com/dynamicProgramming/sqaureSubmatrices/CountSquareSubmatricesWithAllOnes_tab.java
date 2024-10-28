package com.dynamicProgramming.sqaureSubmatrices;

import java.util.Arrays;

// https://leetcode.com/problems/count-square-submatrices-with-all-ones/description/
public class CountSquareSubmatricesWithAllOnes_tab {
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

        int[][] dp = new int[m + 1][n + 1];

        int result = 0;

        for (int row = 0; row < m; row++) {
            for (int col = 0; col < n; col++) {
                // adjusted indexing based on dp size and matrix size
                if (matrix[row][col] == 1) {
                    dp[row + 1][col + 1] = 1 + Math.min(
                            dp[row][col + 1],
                            Math.min(
                                    dp[row][col],
                                    dp[row + 1][col]
                            )
                    );
                    result += dp[row + 1][col + 1];
                }
            }
        }

        return result;
    }

    private static int memoryOptimized(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;

        int[] dp = new int[n + 1];

        int result = 0;

        for (int row = 0; row < m; row++) {
            int[] curr_dp = new int[n + 1];
            for (int col = 0; col < n; col++) {
                // adjusted indexing based on dp size and matrix size
                if (matrix[row][col] == 1) {
                    curr_dp[col + 1] = 1 + Math.min(
                            dp[col + 1],
                            Math.min(
                                    dp[col],
                                    curr_dp[col]
                            )
                    );
                    result += curr_dp[col + 1];
                }
            }
            dp = curr_dp;
        }

        return result;
    }
}