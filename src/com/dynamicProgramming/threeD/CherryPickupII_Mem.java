package com.dynamicProgramming.threeD;

import java.util.Arrays;

public class CherryPickupII_Mem {
    public static void main(String[] args) {
        int r = 3;
        int c = 4;
        int[][] grid = {
                {2, 3, 1, 2},
                {3, 4, 2, 2},
                {5, 6, 3, 5}
        };

        int result = solve(r, c, grid);
        System.out.println(result);
    }

    private static int solve(int r, int c, int[][] grid) {
        int[][][] dp = new int[r][c][c];
        for (int row1[][] : dp) {
            for (int row2[] : row1) {
                Arrays.fill(row2, -1);
            }
        }

        return solve(0, 0, c - 1, grid, r, c, dp);
    }

    private static int solve(int i, int j1, int j2, int[][] grid, int r, int c, int[][][] dp) {
        if (j1 < 0 || j2 < 0 || j1 >= c || j2 >= c)
            return (int) -1e9;

        if (i == r - 1) {
            if (j1 == j2) return grid[i][j1];
            else return grid[i][j1] + grid[i][j2];
        }

        if (dp[i][j1][j2] != -1)
            return dp[i][j1][j2];

        int maxi = Integer.MIN_VALUE;
        for (int dj1 = -1; dj1 <= +1; dj1++) {
            for (int dj2 = -1; dj2 <= +1; dj2++) {
                int value = 0;

                if (j1 == j2) value = grid[i][j1];
                else value = grid[i][j1] + grid[i][j2];

                value += solve(i + 1, j1 + dj1, j2 + dj2, grid, r, c, dp);
                maxi = Math.max(maxi, value);
            }
        }

        return dp[i][j1][j2] = maxi;
    }
}

// another readable solution

//class Solution {
//    public int cherryPickup(int[][] grid) {
//        int m = grid.length;
//        int n = grid[0].length;
//
//        int[][][] dp = new int[m][n][n];
//        for(int[][] twoD: dp){
//            for(int[] rows: twoD){
//                Arrays.fill(rows, -1);
//            }
//        }
//
//        return solve(0, 0, n-1, grid, m, n, dp);
//    }
//
//    private static int solve(int row, int r0col, int r1col, int[][] grid, int m, int n, int[][][] dp){
//        if(row == m-1){
//            if(r0col == r1col) return grid[row][r0col];
//            else return grid[row][r0col] + grid[row][r1col];
//        }
//
//        if(dp[row][r0col][r1col] != -1) return dp[row][r0col][r1col];
//
//        int max = Integer.MIN_VALUE;
//        for(int dr0 = -1; dr0 <= 1; dr0++){
//            for(int dr1 = -1; dr1 <= 1; dr1++){
//
//                int value = 0;
//                if(r0col == r1col) value = grid[row][r0col];
//                else value = grid[row][r0col] + grid[row][r1col];
//
//                int nr0col = r0col + dr0;
//                int nr1col = r1col + dr1;
//
//                if(nr0col >= 0 && nr0col < n && nr1col >= 0 && nr1col < n){
//                    value += solve(row+1, nr0col, nr1col, grid, m, n, dp);
//                    max = Math.max(max, value);
//                }
//            }
//        }
//
//        return dp[row][r0col][r1col] = max;
//    }
//}
