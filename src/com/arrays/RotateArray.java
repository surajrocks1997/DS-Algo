package com.arrays;

public class RotateArray {
    public static void main(String[] args) {
        int[][] arr = {
                {5, 1, 9, 11},
                {2, 4, 8, 10},
                {13, 3, 6, 7},
                {15, 14, 12, 16}
        };
        printMatrix(arr);
        solve(arr);
        System.out.println("Result: ");
        printMatrix(arr);

    }

    private static void solve(int[][] matrix) {
//        swap matrix[row][col] with matrix[col][row]
        for (int i = 0; i < matrix.length; i++) {
            for (int j = i; j < matrix[i].length; j++) {
                if (i == j) continue;
                swap(matrix, i, j);
            }
        }

//        reverse each row
        for (int i = 0; i < matrix.length; i++) {
            int left = 0;
            int right = matrix[i].length - 1;
            while (left < right) {
                int temp = matrix[i][left];
                matrix[i][left] = matrix[i][right];
                matrix[i][right] = temp;
                left++;
                right--;
            }
        }
    }

    private static void swap(int[][] matrix, int row, int col) {
        int temp = matrix[row][col];
        matrix[row][col] = matrix[col][row];
        matrix[col][row] = temp;
    }

    private static void printMatrix(int[][] arr) {
        for (int[] ele : arr) {
            for (int i : ele) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }
}
