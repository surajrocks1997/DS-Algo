package com.graph.shortestPathAlgorithms;

public class FloydWarshallAlgorithm {
    public static void main(String[] args) {
        int[][] matrix = {
                {0, 1, 43},
                {1, 0, 6},
                {-1, -1, 0}
        };

        solve(matrix);
        for(int[] row: matrix) {
            for(int ele: row) {
                System.out.print(ele + " ");
            }
            System.out.println();
        }

    }

    private static void solve(int[][] matrix) {
        int n = matrix.length;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == -1)
                    matrix[i][j] = (int) 1e9;
                if (i == j)
                    matrix[i][j] = 0;
            }
        }

        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    matrix[i][j] = Math.min(matrix[i][j], matrix[i][k] + matrix[k][j]);
                }
            }
        }

        for(int i = 0; i< n; i++){
            if(matrix[i][i] < 0)
                System.out.println("It has a Negative Cycle");
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == (int) 1e9)
                    matrix[i][j] = -1;
            }
        }
    }
}
