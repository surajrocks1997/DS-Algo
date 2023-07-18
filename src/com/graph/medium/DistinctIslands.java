package com.graph.medium;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class DistinctIslands {
    public static void main(String[] args) {
        int[][] arr = {
                {1, 1, 0, 1, 1},
                {1, 0, 0, 0, 0},
                {0, 0, 0, 1, 1},
                {1, 1, 0, 1, 0}
        };

        int result = solve(arr);
        System.out.println(result);
    }

    private static int solve(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] vis = new int[m][n];
        Set<List<String>> set = new HashSet<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (vis[i][j] == 0 && grid[i][j] == 1) {
                    List<String> list = new ArrayList<>();
                    dfs(i, j, vis, grid, list, i, j, m, n);
                    set.add(list);
                }
            }
        }

        return set.size();
    }

    private static void dfs(int row, int col, int[][] vis, int[][] grid, List<String> list, int row0, int col0, int m, int n) {
        vis[row][col] = 1;
        list.add(toString(row - row0, col - col0));
        int[] delrow = {-1, 0, 1, 0};
        int[] delcol = {0, -1, 0, 1};

        for (int i = 0; i < 4; i++) {
            int nrow = row + delrow[i];
            int ncol = col + delcol[i];

            if (nrow >= 0 && nrow < m && ncol >= 0 && ncol < n && vis[nrow][ncol] == 0 && grid[nrow][ncol] == 1)
                dfs(nrow, ncol, vis, grid, list, row0, col0, m, n);
        }

    }

    private static String toString(int row, int col) {
        return Integer.toString(row) + " " + Integer.toString(col);
    }

}
