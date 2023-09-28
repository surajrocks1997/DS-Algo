package com.graph.medium;

import java.util.LinkedList;
import java.util.Queue;

public class DistanceOfNearestCellHaving0 {
    public static void main(String[] args) {
        int[][] grid = {
                {0, 0, 0},
                {0, 1, 0},
                {1, 1, 1}
        };

        int[][] result = solve(grid);

        for (int[] row : result) {
            for (int ele : row)
                System.out.print(ele + " ");
            System.out.println();
        }
    }

    private static int[][] solve(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        int[][] vis = new int[m][n];
        int[][] distanceGrid = new int[m][n];

        Queue<Thruple_DistanceOfNearestCellHaving0> queue = new LinkedList<>();

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0) {
                    queue.add(new Thruple_DistanceOfNearestCellHaving0(i, j, 0));
                    vis[i][j] = 1;
                }
            }
        }

        int[] delrow = {-1, 0, 1, 0};
        int[] delcol = {0, 1, 0, -1};

        while (!queue.isEmpty()) {
            Thruple_DistanceOfNearestCellHaving0 thrup = queue.poll();
            int row = thrup.first;
            int col = thrup.second;
            int distance = thrup.third;

            distanceGrid[row][col] = distance;
            for (int i = 0; i < 4; i++) {
                int nrow = row + delrow[i];
                int ncol = col + delcol[i];

                if (nrow >= 0 && nrow < m && ncol >= 0 && ncol < n &&
                        vis[nrow][ncol] == 0) {
                    vis[nrow][ncol] = 1;
                    queue.add(new Thruple_DistanceOfNearestCellHaving0(nrow, ncol, distance + 1));
                }
            }
        }


        return distanceGrid;
    }
}

class Thruple_DistanceOfNearestCellHaving0 {
    int first;
    int second;
    int third;

    public Thruple_DistanceOfNearestCellHaving0(int first, int second, int third) {
        this.first = first;
        this.second = second;
        this.third = third;
    }
}
