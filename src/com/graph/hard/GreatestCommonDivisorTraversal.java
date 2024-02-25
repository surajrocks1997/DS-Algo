package com.graph.hard;


import java.util.HashMap;
import java.util.Map;

// https://leetcode.com/problems/greatest-common-divisor-traversal/
public class GreatestCommonDivisorTraversal {
    public static void main(String[] args) {
        int[] nums = {30, 30};
        boolean result = solve(nums);
        System.out.println(result);
    }

    private static boolean solve(int[] nums) {
        int n = nums.length;
        if (n == 1) return true;

        DisjointSet_GCDT ds = new DisjointSet_GCDT(n);
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            int f = 2;
            while (f * f <= nums[i]) {
                if (nums[i] % f == 0) {
                    if (map.containsKey(f)) {
                        ds.unionBySize(i, map.get(f));
                    } else {
                        map.put(f, i);
                    }
                    while (nums[i] % f == 0)
                        nums[i] /= f;
                }
                f++;
            }
            if (nums[i] > 1) {
                if (map.containsKey(nums[i])) {
                    ds.unionBySize(i, map.get(nums[i]));
                } else {
                    map.put(nums[i], i);
                }
            }
        }

        return ds.getCount() == 1;
    }

    private static int gcd(int n1, int n2) {
        if (n2 == 0)
            return n1;

        return gcd(n2, n1 % n2);
    }
}

class DisjointSet_GCDT {
    int[] size;
    int[] parent;
    int count;

    public DisjointSet_GCDT(int size) {
        this.size = new int[size];
        this.parent = new int[size];
        this.count = size;
        for (int i = 0; i < size; i++) {
            this.size[i] = 1;
            this.parent[i] = i;
        }
    }

    public int[] getParentArray() {
        return parent;
    }

    public int getCount() {
        return count;
    }

    public void reset(int p) {
        parent[p] = p;
        size[p] = 1;
    }

    public int findUltimateParent(int u) {
        if (parent[u] == u)
            return u;

        int ultimateParent = findUltimateParent(parent[u]);
        parent[u] = ultimateParent;
        return ultimateParent;
    }

    public void unionBySize(int u, int v) {
        int ulParU = findUltimateParent(u);
        int ulParV = findUltimateParent(v);

        if (ulParU == ulParV) return;

        this.count--;

        if (size[ulParU] > size[ulParV]) {
            parent[ulParV] = ulParU;
            size[ulParU] = size[ulParU] + size[ulParV];
        } else {
            parent[ulParU] = ulParV;
            size[ulParV] = size[ulParU] + size[ulParV];
        }

    }
}