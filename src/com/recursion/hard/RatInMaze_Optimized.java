package com.recursion.hard;

import java.util.ArrayList;
import java.util.List;

public class RatInMaze_Optimized {
    public static void main(String[] args) {
        int[][] maze = {
                {1, 0, 0, 0},
                {1, 1, 0, 1},
                {1, 1, 0, 0},
                {0, 1, 1, 1}
        };
        int size = 4;
        List<String> result = solve(maze, size);
        System.out.println(result);
    }

    private static List<String> solve(int[][] maze, int n) {
        List<String> result = new ArrayList<>();
        int[][] visited = new int[n][n];
        int[] di = {+1, 0, 0, -1};
        int[] dj = {0, -1, +1, 0};

        if (maze[0][0] == 1) solve(0, 0, "", maze, n, result, visited, di, dj);
        return result;
    }

    private static void solve(int row, int col, String str, int[][] maze, int n, List<String> result, int[][] visited, int[] di, int[] dj) {
        if (row == n - 1 && col == n - 1) {
            result.add(str);
            return;
        }

        String dir = "DLRU";
        for (int i = 0; i < dir.length(); i++) {
            int nextRow = row + di[i];
            int nextCol = col + dj[i];
            if (nextRow >= 0 && nextRow < n && nextCol >= 0 && nextCol < n &&
                    visited[nextRow][nextCol] == 0 && maze[nextRow][nextCol] == 1) {
                visited[row][col] = 1;
                solve(nextRow, nextCol, str + dir.charAt(i), maze, n, result, visited, di, dj);
                visited[row][col] = 0;
            }
        }

    }
}
