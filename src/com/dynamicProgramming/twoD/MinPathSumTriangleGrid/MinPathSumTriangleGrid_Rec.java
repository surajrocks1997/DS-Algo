package com.dynamicProgramming.twoD.MinPathSumTriangleGrid;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class MinPathSumTriangleGrid_Rec {
    public static void main(String[] args) {
        List<List<Integer>> triangle = new ArrayList<>();
        triangle.add(new ArrayList<>(Collections.singletonList(-10)));
        triangle.add(new ArrayList<>(Arrays.asList(3, 4)));
        triangle.add(new ArrayList<>(Arrays.asList(6, 5, 7)));
        triangle.add(new ArrayList<>(Arrays.asList(4, 1, 8, 3)));

        int result = solve(triangle);
        System.out.println(result);
    }

    private static int solve(List<List<Integer>> triangle) {
        return solve(0, 0, triangle, triangle.size() - 1);
    }

    private static int solve(int row, int col, List<List<Integer>> triangle, int size) {
        if (row == size)
            return triangle.get(row).get(col);

        int down = triangle.get(row).get(col) + solve(row + 1, col, triangle, size);
        int diagDown = triangle.get(row).get(col) + solve(row + 1, col + 1, triangle, size);

        return Math.min(down, diagDown);
    }
}
