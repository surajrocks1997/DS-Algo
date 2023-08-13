package com.dynamicProgramming.twoD.MinPathSumTriangleGrid;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class MinPathSumTriangleGrid_Mem {
    public static void main(String[] args) {
        List<List<Integer>> triangle = new ArrayList<>();
        triangle.add(new ArrayList<>(Collections.singletonList(2)));
        triangle.add(new ArrayList<>(Arrays.asList(3, 4)));
        triangle.add(new ArrayList<>(Arrays.asList(6, 5, 7)));
        triangle.add(new ArrayList<>(Arrays.asList(4, 1, 8, 3)));

        int result = solve(triangle);
        System.out.println(result);
    }

    private static int solve(List<List<Integer>> triangle) {
        int n = triangle.size();
        int[][] dp = new int[n][n];
        for (int[] rows : dp) Arrays.fill(rows, -1);

        return solve(0, 0, triangle, n - 1, dp);
    }

    private static int solve(int row, int col, List<List<Integer>> triangle, int size, int[][] dp) {
        if (row == size)
            return triangle.get(row).get(col);

        if (dp[row][col] != -1) return dp[row][col];

        int down = triangle.get(row).get(col) + solve(row + 1, col, triangle, size, dp);
        int diagDown = triangle.get(row).get(col) + solve(row + 1, col + 1, triangle, size, dp);

        return dp[row][col] = Math.min(down, diagDown);
    }
}
