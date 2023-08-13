package com.dynamicProgramming.twoD.MinPathSumTriangleGrid;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class MinPathSumTriangleGrid_Tab {
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

        for (int j = 0; j < n; j++)
            dp[n - 1][j] = triangle.get(n - 1).get(j);

        for (int i = n - 2; i >= 0; i--) {
            for (int j = i; j >= 0; j--) {
                int down = triangle.get(i).get(j) + dp[i + 1][j];
                int diagDown = triangle.get(i).get(j) + dp[i + 1][j + 1];

                dp[i][j] = Math.min(down, diagDown);
            }
        }
        return dp[0][0];
    }
}
