package com.graph;

// https://leetcode.com/problems/count-sub-islands/description/
public class CountSubIslands {

    public static void main(String[] args) {
        int[][] grid1 = {
                {1, 0, 1, 0, 1},
                {1, 1, 1, 1, 1},
                {0, 0, 0, 0, 0},
                {1, 1, 1, 1, 1},
                {1, 0, 1, 0, 1}
        };
        int[][] grid2 = {
                {0, 0, 0, 0, 0},
                {1, 1, 1, 1, 1},
                {0, 1, 0, 1, 0},
                {0, 1, 0, 1, 0},
                {1, 0, 0, 0, 1}
        };
        int result = solve(grid1, grid2);
        System.out.println(result);
    }

    private static int solve(int[][] grid1, int[][] grid2) {
        int m = grid1.length;
        int n = grid1[0].length;

        int[][] visited = new int[m][n];

        int count = 0;
        for (int row = 0; row < m; row++) {
            for (int col = 0; col < n; col++) {
                if (visited[row][col] == 0 && grid2[row][col] == 1) {
                    if (dfs(grid1, grid2, visited, m, n, row, col)) {
                        count++;
                    }
                }
            }
        }

        return count;
    }

    private static boolean dfs(int[][] grid1, int[][] grid2, int[][] visited, int m, int n, int row, int col) {
        visited[row][col] = 1;
        boolean res = true;
        if (grid1[row][col] == 0) res = false;


        int[] delrow = {-1, 0, 1, 0};
        int[] delcol = {0, 1, 0, -1};

        for (int i = 0; i < 4; i++) {
            int nrow = row + delrow[i];
            int ncol = col + delcol[i];

            if (nrow >= 0 && nrow < m && ncol >= 0 && ncol < n && visited[nrow][ncol] == 0 && grid2[nrow][ncol] == 1) {
                res = dfs(grid1, grid2, visited, m, n, nrow, ncol) && res;
            }
        }
        return res;
    }
}