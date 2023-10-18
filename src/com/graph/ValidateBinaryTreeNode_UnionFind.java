package com.graph;

import java.util.ArrayList;
import java.util.List;

//https://leetcode.com/problems/validate-binary-tree-nodes/?envType=daily-question&envId=2023-10-17
public class ValidateBinaryTreeNode_UnionFind {
    public static void main(String[] args) {
        int n = 4;
        int[] leftChild = {1, -1, 3, -1};
        int[] rightChild = {2, -1, -1, -1};

        boolean result = solve(n, leftChild, rightChild);
        System.out.println(result);
    }

    private static boolean solve(int n, int[] leftChild, int[] rightChild) {
        DisjointSet ds = new DisjointSet(n);
        for (int i = 0; i < n; i++) {
            if (leftChild[i] >= 0 && !ds.union(i, leftChild[i]))
                return false;
            if (rightChild[i] >= 0 && !ds.union(i, rightChild[i]))
                return false;
        }

        return ds.getComponent() == 1;
    }
}

class DisjointSet {
    private List<Integer> parent = new ArrayList<>();
    private List<Integer> size = new ArrayList<>();
    private int component;

    public DisjointSet(int n) {
        this.component = n;

        for (int i = 0; i < n; i++) {
            parent.add(i);
            size.add(1);
        }
    }

    private int findUltimateParent(int node) {
        if (node == parent.get(node))
            return node;

        int ultimateParent = findUltimateParent(parent.get(node));
        parent.set(node, ultimateParent);
        return ultimateParent;
    }

    public boolean union(int parent, int child) {
        int parentUltimateParent = findUltimateParent(parent);
        int childUltimateParent = findUltimateParent(child);

        if (parentUltimateParent == childUltimateParent || childUltimateParent != child)
            return false;

        if (size.get(parentUltimateParent) < size.get(childUltimateParent)) {
            this.parent.set(parentUltimateParent, childUltimateParent);
            this.size.set(childUltimateParent, size.get(childUltimateParent) + size.get(parentUltimateParent));
        } else {
            this.parent.set(childUltimateParent, parentUltimateParent);
            this.size.set(parentUltimateParent, size.get(childUltimateParent) + size.get(parentUltimateParent));
        }

        this.component--;
        return true;
    }

    public int getComponent() {
        return component;
    }
}
