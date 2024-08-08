package com.arrays.medium;

public class SpiralMatrixIII {

    public static void main(String[] args) {
        int rows = 5;
        int cols = 6;
        int rStart = 1;
        int cStart = 4;

        int[][] result = solve(rows, cols, rStart, cStart);
        for(int[] rws: result){
            for(int ele: rws)
                System.out.print(ele + " ");
            System.out.println();
        }
    }

    private static int[][] solve(int rows, int cols, int rStart, int cStart) {
        int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        int[][] result = new int[rows * cols][2];
        int steps = 0, d = 0, len = 0;

        result[0] = new int[]{rStart, cStart};
        int count = 1;

        while (count < rows * cols) {
            for(int j = 0; j < 2; j++){
                for (int i = 0; i <= steps; i++) {
                    rStart += directions[d][0];
                    cStart += directions[d][1];

                    if (rStart >= 0 && rStart < rows && cStart >= 0 && cStart < cols) {
                        result[count++] = new int[]{rStart, cStart};
                    }

                    if (count == rows * cols) return result;
                }
                d = (d + 1) % 4;
            }
            steps++;
        }

        return result;
    }
}