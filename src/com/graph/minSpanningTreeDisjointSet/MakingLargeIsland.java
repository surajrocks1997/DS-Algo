package com.graph.minSpanningTreeDisjointSet;

import java.util.HashSet;
import java.util.Set;

public class MakingLargeIsland {
    public static void main(String[] args) {
        int[][] grid = {
                {1, 1, 0, 1, 1},
                {1, 1, 0, 1, 1},
                {1, 1, 0, 1, 1},
                {0, 0, 1, 0, 0},
                {0, 0, 1, 1, 1}
        };

        int result = solve(grid);
        System.out.println(result);

    }

    private static int solve(int[][] grid) {
        int n = grid.length;
        DisjointSet_Class ds = new DisjointSet_Class(n * n);

        for (int row = 0; row < n; row++) {
            for (int col = 0; col < n; col++) {
                if (grid[row][col] == 0) continue;

                int[] delrow = {-1, 0, 1, 0};
                int[] delcol = {0, -1, 0, 1};

                for (int i = 0; i < 4; i++) {
                    int nrow = row + delrow[i];
                    int ncol = col + delcol[i];

                    if (nrow >= 0 && nrow < n && ncol >= 0 && ncol < n && grid[nrow][ncol] == 1) {
                        int nodeNum = row * n + col;
                        int adjNodeNum = nrow * n + ncol;
                        ds.unionBySize(nodeNum, adjNodeNum);
                    }
                }
            }
        }

        int max = 0;

        for (int row = 0; row < n; row++) {
            for (int col = 0; col < n; col++) {
                if (grid[row][col] == 1) continue;
                int[] delrow = {-1, 0, 1, 0};
                int[] delcol = {0, -1, 0, 1};

                Set<Integer> set = new HashSet<>();
                for (int i = 0; i < 4; i++) {
                    int nrow = row + delrow[i];
                    int ncol = col + delcol[i];

                    if (nrow >= 0 && nrow < n && ncol >= 0 && ncol < n && grid[nrow][ncol] == 1) {
                        set.add(ds.findUltimateParent(nrow * n + ncol));
                    }
                }

                int totalSize = 0;
                for (int ele : set)
                    totalSize += ds.size.get(ele);
                max = Math.max(max, totalSize + 1);     // totalSize + 1 for 0 that we converted to 1 for making bigger island
            }
        }

//        what if all the cells have value 1? go through every cell and return the size of ultimate parent
        for (int cellNum = 0; cellNum < n * n; cellNum++)
            max = Math.max(max, ds.size.get(ds.findUltimateParent(cellNum)));


        return max;
    }
}
