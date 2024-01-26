package com.dynamicProgramming.threeD;

//https://leetcode.com/problems/out-of-boundary-paths/description/

import java.util.Arrays;

public class OutOfBoundaryPaths_Tabulation {
    public static void main(String[] args) {
        int m = 2;
        int n = 3;
        int maxMove = 4;
        int startRow = 0;
        int startCol = 1;

        int result = solve(m, n, maxMove, startRow, startCol);
        System.out.println(result);
    }

    private static int solve(int m, int n, int maxMove, int startRow, int startColumn) {
        if ((startRow < 0 || startRow >= m || startColumn < 0 || startColumn >= n) && maxMove == 0) return 0;

        int mod = (int) 1e9 + 7;

        long[][][] dp = new long[m][n][maxMove + 1];

        for (int move = 1; move <= maxMove; move++) {
            for (int currentRow = 0; currentRow < m; currentRow++) {
                for (int currentCol = 0; currentCol < n; currentCol++) {

                    long up = currentRow - 1 >= 0 ? dp[currentRow - 1][currentCol][move - 1] % mod : 1;
                    long right = currentCol + 1 < n ? dp[currentRow][currentCol + 1][move - 1] % mod : 1;
                    long down = currentRow + 1 < m ? dp[currentRow + 1][currentCol][move - 1] % mod : 1;
                    long left = currentCol - 1 >= 0 ? dp[currentRow][currentCol - 1][move - 1] % mod : 1;

                    dp[currentRow][currentCol][move] = (up + right + down + left) % mod;
                }
            }
        }

        long ans = dp[startRow][startColumn][maxMove];
        return (int) ans % mod;
    }
}
