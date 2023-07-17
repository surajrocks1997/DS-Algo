package com.graph.medium;

import java.util.LinkedList;
import java.util.Queue;

public class NumberOfIslands {
    public static void main(String[] args) {
        int[][] graph = {
                {0, 1, 1, 0},
                {0, 1, 1, 0},
                {0, 0, 1, 0},
                {0, 0, 0, 0},
                {1, 1, 0, 1}
        };

        int result = solve(graph);
        System.out.println(result);
    }

    private static int solve(int[][] graph) {
        int m = graph.length;
        int n = graph[0].length;
        int[][] vis = new int[m][n];
        int count = 0;

        for (int row = 0; row < m; row++) {
            for (int col = 0; col < n; col++) {
                if (vis[row][col] == 0 && graph[row][col] == 1) {
                    count++;
                    bfs(row, col, vis, graph);
                }
            }
        }

        return count;
    }

    private static void bfs(int row, int col, int[][] vis, int[][] graph) {
        vis[row][col] = 1;
        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(row, col));
        int m = graph.length;
        int n = graph[0].length;

        while (!queue.isEmpty()) {
            Pair pair = queue.poll();
            int rw = pair.first;
            int cl = pair.second;

            for (int delRow = -1; delRow <= 1; delRow++) {
                for (int delCol = -1; delCol <= 1; delCol++) {
                    int nrow = rw + delRow;
                    int ncol = cl + delCol;
                    if (nrow >= 0 && nrow < m && ncol >= 0 && ncol < n &&
                            graph[nrow][ncol] == 1 && vis[nrow][ncol] == 0) {
                        vis[nrow][ncol] = 1;
                        queue.add(new Pair(nrow, ncol));
                    }
                }
            }
        }

    }
}

class Pair {
    int first;
    int second;

    public Pair(int first, int second) {
        this.first = first;
        this.second = second;
    }
}
