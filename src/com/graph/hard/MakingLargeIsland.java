package com.graph.hard;

import com.graph.minSpanningTreeDisjointSet.DisjointSet_Class;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class MakingLargeIsland {
    public static void main(String[] args) {
        int[][] grid = {
                {0, 0},
                {0, 0}
        };

        int result = solve(grid);
        System.out.println(result);
    }

    private static int solve(int[][] grid) {
        int n = grid.length;
        if (n == 1) return 1;

        int[][] visited = new int[n][n];
        DisjointSet_Class ds = new DisjointSet_Class(n * n);

        List<Tuple> cellWithZeroes = new ArrayList<>();

        for (int row = 0; row < n; row++) {
            for (int col = 0; col < n; col++) {
                if (visited[row][col] == 0 && grid[row][col] == 1) {
                    dfs(row, col, n, grid, visited, ds);
                } else if (grid[row][col] == 0) {
                    cellWithZeroes.add(new Tuple(row, col, row * n + col));
                }
            }
        }

        int maxSize = 0;
        for (Tuple tuple : cellWithZeroes) {
            int row = tuple.row;
            int col = tuple.col;
            int cellNum = tuple.cellNum;
            int size = 1;

            int[] delrow = {-1, 0, 1, 0};
            int[] delcol = {0, 1, 0, -1};

            Set<Integer> set = new HashSet<>();

            for (int i = 0; i < 4; i++) {
                int nrow = row + delrow[i];
                int ncol = col + delcol[i];
                if (nrow >= 0 && nrow < n && ncol >= 0 && ncol < n && grid[nrow][ncol] == 1) {
                    int adjCellNum = nrow * n + ncol;
                    set.add(ds.findUltimateParent(adjCellNum));
                }
            }

            for (int ele : set) {
                size += ds.getSize().get(ele);   // if size gives error, make disjoint set class SIZE property public
            }
            maxSize = Math.max(maxSize, size);
        }

        if (cellWithZeroes.isEmpty()) {
            for (int cellNo = 0; cellNo < n * n; cellNo++) {
                maxSize = Math.max(maxSize, ds.getSize().get(ds.findUltimateParent(cellNo)));
            }
        }

        return maxSize;
    }

    public static void dfs(int row, int col, int n, int[][] grid, int[][] visited, DisjointSet_Class ds) {
        visited[row][col] = 1;

        int[] delrow = {-1, 0, 1, 0};
        int[] delcol = {0, 1, 0, -1};

        for (int i = 0; i < 4; i++) {
            int nrow = row + delrow[i];
            int ncol = col + delcol[i];
            if (nrow >= 0 && nrow < n && ncol >= 0 && ncol < n && visited[nrow][ncol] == 0 && grid[nrow][ncol] == 1) {
                int cellNum = row * n + col;
                int adjCellNum = nrow * n + ncol;
                if (ds.findUltimateParent(cellNum) != ds.findUltimateParent(adjCellNum)) {
                    ds.unionBySize(cellNum, adjCellNum);
                    dfs(nrow, ncol, n, grid, visited, ds);
                }
            }
        }
    }
}

class Tuple {
    int row;
    int col;
    int cellNum;

    public Tuple(int row, int col, int cellNum) {
        this.row = row;
        this.col = col;
        this.cellNum = cellNum;
    }
}