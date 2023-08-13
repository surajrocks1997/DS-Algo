package com.dynamicProgramming.twoD.MinFallingPathSum;

public class MinFallingPathSum_Rec {
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

        int min = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            min = Math.min(min, solve(n - 1, i, n, matrix));
        }
        return min;
    }

    private static int solve(int row, int col, int size, int[][] matrix) {
        if (col < 0 || col >= size) return (int) 1e9;
        if (row == 0) return matrix[row][col];

        int up = matrix[row][col] + solve(row - 1, col, size, matrix);
        int upDiagLeft = matrix[row][col] + solve(row - 1, col - 1, size, matrix);
        int upDiagRight = matrix[row][col] + solve(row - 1, col + 1, size, matrix);

        return Math.min(up, Math.min(upDiagLeft, upDiagRight));
    }
}
