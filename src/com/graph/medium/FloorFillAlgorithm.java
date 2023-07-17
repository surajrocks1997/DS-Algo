package com.graph.medium;

public class FloorFillAlgorithm {
    public static void main(String[] args) {
        int[][] image = {
                {1, 1, 1},
                {1, 1, 0},
                {1, 0, 1}
        };
        int sr = 1;
        int sc = 1;
        int color = 2;

        int[][] result = solve(image, sr, sc, color);

        for (int i = 0; i < result.length; i++) {
            for (int j = 0; j < result[0].length; j++) {
                System.out.print(result[i][j] + " ");
            }
            System.out.println();
        }

    }

    private static int[][] solve(int[][] image, int sr, int sc, int color) {
        int iniColor = image[sr][sc];
        int[][] ans = image;
        int[] delrow = {-1, 0, 1, 0};
        int[] delcol = {0, 1, 0, -1};
        dfs(sr, sc, delrow, delcol, image, color, iniColor, ans);

        return ans;
    }

    private static void dfs(int row, int col, int[] delrow, int[] delcol, int[][] image, int color, int iniColor, int[][] ans) {
        ans[row][col] = color;
        int m = image.length;
        int n = image[0].length;

        for (int i = 0; i < 4; i++) {
            int nrow = row + delrow[i];
            int ncol = col + delcol[i];

            if (nrow >= 0 && nrow < m && ncol >= 0 && ncol < n && image[nrow][ncol] == iniColor
                    && ans[nrow][ncol] != color)
                dfs(nrow, ncol, delrow, delcol, image, color, iniColor, ans);
        }
    }


}
