package com.arrays;

//https://leetcode.com/problems/set-matrix-zeroes/
public class SetMatrixZero {
    public static void main(String[] args) {
        int[][] arr = {
                {0, 1, 2, 0},
                {3, 4, 5, 2},
                {1, 3, 1, 5}
        };

//        int[][] arr = {
//                {1, 0, 1},
//                {1, 0, 1},
//                {0, 1, 1}
//        };
        printMatrix(arr);
        solve1(arr);
        System.out.println("Result:");
        printMatrix(arr);
    }

    private static void printMatrix(int[][] arr) {
        for (int[] ele : arr) {
            for (int i : ele) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
        System.out.println("\n");
    }

    // O(1) space solution
    private static void solve1(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        int rowZero = 1;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (matrix[i][j] == 0) {
                    matrix[0][j] = 0;

                    if (i > 0) matrix[i][0] = 0;
                    else rowZero = 0;
                }
            }
        }

        printMatrix(matrix);

        // row and col >= 1
        for (int i = 1; i < rows; i++) {
            for (int j = 1; j < cols; j++) {
                if (matrix[0][j] == 0 || matrix[i][0] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }

        printMatrix(matrix);

        // first row 0th column
        if (matrix[0][0] == 0) {
            for (int i = 0; i < rows; i++) {
                matrix[i][0] = 0;
            }
        }

        printMatrix(matrix);

        // first column 0th row
        if (rowZero == 0) {
            for (int j = 0; j < cols; j++) {
                matrix[0][j] = 0;
            }
        }

        printMatrix(matrix);
    }

    private static void solve(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;

//        creating row and column array,
//        if any (row,col) == 0, then entire row and entire column should be changed to 0
        int[] row = new int[m];
        int[] col = new int[n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) {
                    row[i] = 1;
                    col[j] = 1;
                }
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (row[i] == 1 || col[j] == 1) {
                    matrix[i][j] = 0;
                }
            }
        }
    }
}
