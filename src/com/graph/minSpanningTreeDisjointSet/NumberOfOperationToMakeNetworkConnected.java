package com.graph.minSpanningTreeDisjointSet;

public class NumberOfOperationToMakeNetworkConnected {
    public static void main(String[] args) {
        int n = 4;
        int[][] connections = {
                {0, 1},
                {0, 2},
                {1, 2}
        };

        int result = solve(n, connections);
        System.out.println(result);
    }

    private static int solve(int n, int[][] connections) {
        DisjointSet_Class ds = new DisjointSet_Class(n);
        int countExtras = 0;

        for (int[] connection : connections) {
            int u = connection[0];
            int v = connection[1];

            if (ds.findUltimateParent(u) == ds.findUltimateParent(v))
                countExtras++;
            else
                ds.unionBySize(u, v);

        }

        int countC = 0;
        for (int i = 0; i < n; i++)
            if (ds.parent.get(i) == i)
                countC++;

        int ans = countC - 1;  // number of connected Component - 1

        return countExtras >= ans ? ans : -1;
    }
}
