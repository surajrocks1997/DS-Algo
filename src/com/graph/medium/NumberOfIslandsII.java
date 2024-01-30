package com.graph.medium;

import com.graph.minSpanningTreeDisjointSet.DisjointSet_Class;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NumberOfIslandsII {
    public static void main(String[] args) {
        int m = 4;
        int n = 5;

        int[][] queries = {
                {0, 0},
                {0, 0},
                {1, 1},
                {1, 0},
                {0, 1},
                {0, 3},
                {1, 3},
                {0, 4},
                {3, 2},
                {2, 2},
                {1, 2},
                {0, 2}
        };

        int[] result = solve(m, n, queries);
        Arrays.stream(result).forEach(ele -> System.out.print(ele + " "));

    }

    private static int[] solve(int m, int n, int[][] queries) {
        DisjointSet_Class ds = new DisjointSet_Class(m * n);
        int[][] visited = new int[m][n];
        int count = 0;
        List<Integer> result = new ArrayList<>();
        int length = queries.length;

        for (int i = 0; i < length; i++) {
            int row = queries[i][0];
            int col = queries[i][1];

            if (visited[row][col] == 1) {
                result.add(count);
            }
            visited[row][col] = 1;
            count++;

            int[] delrow = {-1, 0, 1, 0};
            int[] delcol = {0, 1, 0, -1};


            for (int ind = 0; ind < 4; ind++) {
                int nrow = row + delrow[ind];
                int ncol = col + delcol[ind];

                if (nrow >= 0 && nrow < m && ncol >= 0 && ncol < n && visited[nrow][ncol] == 1) {
                    int nodeNo = n * row + col;
                    int adjNodeNo = n * nrow + ncol;
                    if (ds.findUltimateParent(nodeNo) != ds.findUltimateParent(adjNodeNo)) {
                        ds.unionBySize(nodeNo, adjNodeNo);
                        count--;
                    }
                }
            }
            result.add(count);
        }


        return result.stream().mapToInt(i -> i).toArray();
    }
}