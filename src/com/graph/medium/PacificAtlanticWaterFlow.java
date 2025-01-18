package com.graph.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//https://leetcode.com/problems/pacific-atlantic-water-flow/description/
public class PacificAtlanticWaterFlow {
    public static void main(String[] args) {
        int[][] heights = {
                {1, 2, 2, 3, 5},
                {3, 2, 3, 4, 4},
                {2, 4, 5, 3, 1},
                {6, 7, 1, 4, 5},
                {5, 1, 1, 2, 4}
        };

        List<List<Integer>> result = solve(heights);
        System.out.println(result);
    }

    private static List<List<Integer>> solve(int[][] heights) {
        int m = heights.length;
        int n = heights[0].length;

        boolean[][] pacific = new boolean[m][n];
        boolean[][] atlantic = new boolean[m][n];

        for (int row = 0; row < m; row++) {
            dfs(row, 0, heights, pacific, m, n, -1);
            dfs(row, n - 1, heights, atlantic, m, n, -1);
        }

        for (int col = 0; col < n; col++) {
            dfs(0, col, heights, pacific, m, n, -1);
            dfs(m - 1, col, heights, atlantic, m, n, -1);
        }

        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++)
                if (pacific[i][j] == atlantic[i][j])
                    res.add(Arrays.asList(i, j));
        }

        return res;

    }

    private static void dfs(int row, int col, int[][] heights, boolean[][] vis, int m, int n, int parent) {
        if (row < 0 || row == m || col < 0 || col == n || vis[row][col] || parent > heights[row][col])
            return;

        vis[row][col] = true;
        dfs(row - 1, col, heights, vis, m, n, heights[row][col]);
        dfs(row, col + 1, heights, vis, m, n, heights[row][col]);
        dfs(row + 1, col, heights, vis, m, n, heights[row][col]);
        dfs(row, col - 1, heights, vis, m, n, heights[row][col]);
    }
}