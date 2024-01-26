package com.dynamicProgramming.threeD;

//https://leetcode.com/problems/out-of-boundary-paths/description/

import java.util.Arrays;

public class OutOfBoundaryPaths_Memoization {
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
        for (long[][] rows : dp)
            for (long[] col : rows)
                Arrays.fill(col, -1);

        long ans = solve(startRow, startColumn, m, n, maxMove, dp, mod);
        return (int) ans % mod;
    }

    private static long solve(int currentRow, int currentCol, int row, int col, int maxMove, long[][][] dp, int mod) {
        if (currentRow < 0 || currentCol < 0 || currentRow >= row || currentCol >= col)
            return 1;

        if (maxMove == 0)
            return 0;

        if (dp[currentRow][currentCol][maxMove] != -1) return dp[currentRow][currentCol][maxMove];

        long up = solve(currentRow - 1, currentCol, row, col, maxMove - 1, dp, mod) % mod;
        long right = solve(currentRow, currentCol + 1, row, col, maxMove - 1, dp, mod) % mod;
        long down = solve(currentRow + 1, currentCol, row, col, maxMove - 1, dp, mod) % mod;
        long left = solve(currentRow, currentCol - 1, row, col, maxMove - 1, dp, mod) % mod;

        return dp[currentRow][currentCol][maxMove] = (up + right + down + left) % mod;
    }
}
