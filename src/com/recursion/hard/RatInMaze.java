package com.recursion.hard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RatInMaze {
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

        solve(0, 0, "", maze, n, result, visited);
        return result;
    }

    private static void solve(int row, int col, String str, int[][] maze, int n, List<String> result, int[][] visited) {
        if (row == n - 1 && col == n - 1) {
            result.add(str);
            return;
        }

//        DLRU
        if (row + 1 < n && visited[row + 1][col] == 0 && maze[row + 1][col] == 1) {
            visited[row][col] = 1;
            solve(row + 1, col, str + "D", maze, n, result, visited);
            visited[row][col] = 0;
        }

        if (col - 1 > 0 && visited[row][col - 1] == 0 && maze[row][col - 1] == 1) {
            visited[row][col] = 1;
            solve(row, col - 1, str + "L", maze, n, result, visited);
            visited[row][col] = 0;
        }

        if (col + 1 < n && visited[row][col + 1] == 0 && maze[row][col + 1] == 1) {
            visited[row][col] = 1;
            solve(row, col + 1, str + "R", maze, n, result, visited);
            visited[row][col] = 0;
        }

        if (row - 1 > 0 && visited[row - 1][col] == 0 && maze[row - 1][col] == 1) {
            visited[row][col] = 1;
            solve(row - 1, col, str + "U", maze, n, result, visited);
            visited[row][col] = 0;
        }

    }
}
