package com.graph.hard;

public class Microsoft_StringInMazeEndingAtEdge {
    public static void main(String[] args) {
        char[][] maze = {
                {'a', 's', 'u', 'r', 'j'},
                {'t', 'q', 'd', 'a', 'm'},
                {'s', 'u', 'x', 'j', 'v'},
                {'n', 'r', 'u', 's', 't'},
                {'a', 'a', 'r', 'a', 'j'},
                {'r', 'j', 'm', 'i', 's'}
        };

        String str = "suraj";
        int[][] result = solve(maze, str);

        for (int[] rows : result) {
            for (int ele : rows) {
                System.out.print(ele + " ");
            }
            System.out.println();
        }
    }

    private static int[][] solve(char[][] maze, String str) {
        int m = maze.length;
        int n = maze[0].length;

        int[] start = new int[2];

        int[][] visited = new int[m][n];
        for (int col = 0; col < n; col++) {
            if (maze[0][col] == str.charAt(0)) {
                if (dfs(maze, str, 1, visited, 0, col, m, n)) {
                    return visited;
                }
            }

            if (maze[m - 1][col] == str.charAt(0)) {
                if (dfs(maze, str, 1, visited, m - 1, col, m, n)) {
                    return visited;
                }
            }

        }

        for (int row = 0; row < m; row++) {
            if (maze[row][0] == str.charAt(0)) {
                if (dfs(maze, str, 1, visited, row, 0, m, n)) {
                    return visited;
                }
            }

            if (maze[row][n - 1] == str.charAt(0)) {
                if (dfs(maze, str, 1, visited, row, n - 1, m, n)) {
                    return visited;
                }
            }

        }

        return visited;
    }


    private static boolean dfs(char[][] maze, String str, int strIndex, int[][] visited, int row, int col, int m, int n) {
        visited[row][col] = strIndex;

        if (strIndex == str.length()) {
            if ((row == 0 || row == m - 1 || col == 0 || col == n - 1))
                return true;
            else {
                visited[row][col] = 0;
                return false;
            }
        }

        int[] delrow = {-1, 0, 1, 0};
        int[] delcol = {0, 1, 0, -1};

        for (int i = 0; i < 4; i++) {
            int nrow = row + delrow[i];
            int ncol = col + delcol[i];

            if (nrow >= 0 && nrow < m && ncol >= 0 && ncol < n
                    && visited[nrow][ncol] != 1 && maze[nrow][ncol] == str.charAt(strIndex)) {

                if (dfs(maze, str, strIndex + 1, visited, nrow, ncol, m, n)) {
                    return true;
                }
            }
        }
        visited[row][col] = 0;

        return false;
    }
}


