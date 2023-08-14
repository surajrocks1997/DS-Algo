package com.dynamicProgramming.threeD;

public class CherryPickupII_Tab {
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

//        base cases
        for (int j1 = 0; j1 < c; j1++) {
            for (int j2 = 0; j2 < c; j2++) {
                if (j1 == j2) dp[r - 1][j1][j2] = grid[r - 1][j1];
                else dp[r - 1][j1][j2] = grid[r - 1][j1] + grid[r - 1][j2];
            }
        }

        for (int i = r - 2; i >= 0; i--) {
            for (int j1 = 0; j1 < c; j1++) {
                for (int j2 = 0; j2 < c; j2++) {
                    int maxi = Integer.MIN_VALUE;
                    for (int dj1 = -1; dj1 <= +1; dj1++) {
                        for (int dj2 = -1; dj2 <= +1; dj2++) {
                            int value = 0;

                            if (j1 == j2) value = grid[i][j1];
                            else value = grid[i][j1] + grid[i][j2];

                            if ((j1 + dj1 < 0 || j1 + dj1 >= c) ||
                                    (j2 + dj2 < 0 || j2 + dj2 >= c))
                                value += (int) -1e9;
                            else
                                value += dp[i + 1][j1 + dj1][j2 + dj2];
                            maxi = Math.max(maxi, value);
                        }
                    }
                    dp[i][j1][j2] = maxi;
                }
            }
        }
        return dp[0][0][c - 1];
    }
}
