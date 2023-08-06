package com.graph.minSpanningTreeDisjointSet;

import java.util.ArrayList;
import java.util.List;

public class NumberOfIslands_II {
    public static void main(String[] args) {
        int rows = 2;
        int cols = 4;
        int[][] operators = {
                {1, 3},
                {0, 3},
                {0, 1},
                {1, 1},
                {1, 0},
                {1, 2},
                {0, 3},
                {1, 2}
        };

        List<Integer> result = solve(rows, cols, operators);
        System.out.println(result);
    }

    private static List<Integer> solve(int rows, int cols, int[][] operators) {
        DisjointSet_Class ds = new DisjointSet_Class(rows * cols);
        int[][] vis = new int[rows][cols];
        int count = 0;

        List<Integer> ans = new ArrayList<>();

        for (int[] operator : operators) {
            int row = operator[0];
            int col = operator[1];

            if (vis[row][col] == 1) {
                ans.add(count);
                continue;
            }

            vis[row][col] = 1;
            count++;

            int[] delrow = {-1, 0, 1, 0};
            int[] delcol = {0, 1, 0, -1};

            for (int ind = 0; ind < 4; ind++) {
                int nrow = row + delrow[ind];
                int ncol = col + delcol[ind];

                if (nrow >= 0 && nrow < rows && ncol >= 0 && ncol < cols) {
                    if (vis[nrow][ncol] == 1) {
                        int nodeNum = row * cols + col;
                        int adjNodeNum = nrow * cols + ncol;
                        if (ds.findUltimateParent(nodeNum) != ds.findUltimateParent(adjNodeNum)) {
                            count--;
                            ds.unionBySize(nodeNum, adjNodeNum);
                        }
                    }
                }
            }
            ans.add(count);
        }
        return ans;
    }
}
