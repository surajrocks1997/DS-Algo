package com.dynamicProgramming.twoD.MinFallingPathSum;

public class MinFallingPathSum_Tab {
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

        for (int i = 0; i < n; i++)
            dp[0][i] = matrix[0][i];

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int up = matrix[i][j] + dp[i - 1][j];

                int upDiagLeft = (int) 1e9;
                if (j > 0)
                    upDiagLeft = matrix[i][j] + dp[i - 1][j - 1];

                int upDiagRight = (int) 1e9;
                if (j + 1 < n)
                    upDiagRight = matrix[i][j] + dp[i - 1][j + 1];

                dp[i][j] = Math.min(up, Math.min(upDiagLeft, upDiagRight));
            }
        }

        int min = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            min = Math.min(min, dp[m - 1][i]);
        }
        return min;
    }
}
