package com.graph.minSpanningTreeDisjointSet;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class MostStonesRemovedFromSameRowOrColumn {
    public static void main(String[] args) {
        int[][] stones = {
                {0, 0},
                {0, 1},
                {1, 0},
                {1, 2},
                {2, 1},
                {2, 2}
        };

        int result = solve(stones);
        System.out.println(result);
    }

    private static int solve(int[][] stones) {
        int maxRow = 0;
        int maxCol = 0;

        for (int i = 0; i < stones.length; i++) {
            maxRow = Math.max(maxRow, stones[i][0]);
            maxCol = Math.max(maxCol, stones[i][1]);
        }

        DisjointSet_Class ds = new DisjointSet_Class(maxCol + maxRow + 1);
        HashMap<Integer, Integer> stoneNodes = new HashMap<>();

        for (int i = 0; i < stones.length; i++) {
            int nodeRow = stones[i][0];
            int nodeCol = stones[i][1] + maxRow + 1;

            ds.unionBySize(nodeRow, nodeCol);
            stoneNodes.put(nodeRow, 1);
            stoneNodes.put(nodeCol, 1);
        }

        int count = 0;
        for (Map.Entry<Integer, Integer> it : stoneNodes.entrySet())
            if (ds.findUltimateParent(it.getKey()) == it.getKey())
                count++;

        return stones.length - count;
    }
}
