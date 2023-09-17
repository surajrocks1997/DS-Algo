package com.graph.minSpanningTreeDisjointSet;

import java.util.ArrayList;
import java.util.List;

public class DisjointSet_Class {
    List<Integer> rank = new ArrayList<>();
    List<Integer> parent = new ArrayList<>();
    List<Integer> size = new ArrayList<>();

    public DisjointSet_Class(int n) {
        for (int i = 0; i < n + 1; i++) {    // for 1 based indexing -> n+1 declaring n+1 works for both 0 and 1 based indexing
            rank.add(0);
            parent.add(i);
            size.add(1);
        }
    }

    public int findUltimateParent(int node) {
        if (node == parent.get(node))
            return node;

        int ultParent = findUltimateParent(parent.get(node));
        parent.set(node, ultParent);
        return parent.get(node);
    }

    public void unionByRank(int u, int v) {
        int ulParU = findUltimateParent(u);
        int ulParV = findUltimateParent(v);

        if (ulParU == ulParV) return;

        if (rank.get(ulParU) < rank.get(ulParV))
            parent.set(ulParU, ulParV);
        else if (rank.get(ulParU) > rank.get(ulParV))
            parent.set(ulParV, ulParU);
        else {
            parent.set(ulParV, ulParU);
            rank.set(ulParU, rank.get(ulParU) + 1);
        }
    }

    public void unionBySize(int u, int v) {
        int ulParU = findUltimateParent(u);
        int ulParV = findUltimateParent(v);

        if (ulParU == ulParV) return;

        if (size.get(ulParU) < size.get(ulParV)) {
            parent.set(ulParU, ulParV);
            size.set(ulParV, size.get(ulParU) + size.get(ulParV));
        } else {
            parent.set(ulParV, ulParU);
            size.set(ulParU, size.get(ulParU) + size.get(ulParV));
        }

    }
}
