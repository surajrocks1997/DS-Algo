package com.graph.hard;

import java.util.*;

// https://leetcode.com/problems/find-all-people-with-secret/description

public class FindAllPeopleWIthSecret_Disjoint_Set {

    public static void main(String[] args) {
        int n = 4;
        int[][] meetings = {
                {3, 1, 3},
                {1, 2, 2},
                {0, 3, 3}
        };
        int firstPerson = 3;
        List<Integer> result = solve(n, meetings, firstPerson);
        System.out.println(result);
    }

    private static List<Integer> solve(int n, int[][] meetings, int firstPerson) {
        Arrays.sort(meetings, (a, b) -> a[2] - b[2]);
        DisjointSet ds = new DisjointSet(n);
        ds.unionBySize(0, firstPerson);

        int i = 0;
        while (i < meetings.length) {
            int currTime = meetings[i][2];
            Set<Integer> pool = new HashSet<>();

            while (i < meetings.length && currTime == meetings[i][2]) {
                int[] currentMeeting = meetings[i];
                ds.unionBySize(currentMeeting[0], currentMeeting[1]);
                pool.add(currentMeeting[0]);
                pool.add(currentMeeting[1]);
                i++;
            }

            for (int ele : pool) {
                if (ds.findUltimateParent(ele) != 0) ds.reset(ele);
            }
        }

        List<Integer> ans = new ArrayList<>();
        for (int j = 0; j < n; j++) {
            if (ds.findUltimateParent(j) == 0) ans.add(j);
        }
        return ans;
    }
}

class DisjointSet {
    int[] size;
    int[] parent;

    public DisjointSet(int size) {
        this.size = new int[size];
        this.parent = new int[size];
        for (int i = 0; i < size; i++) {
            this.size[i] = 1;
            this.parent[i] = i;
        }
    }

    public int[] getParentArray() {
        return parent;
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

        if (ulParU == 0) {
            parent[ulParV] = ulParU;
            size[ulParU] = size[ulParU] + size[ulParV];
        } else if (ulParV == 0) {
            parent[ulParU] = ulParV;
            size[ulParV] = size[ulParU] + size[ulParV];
        } else {
            if (size[ulParU] > size[ulParV]) {
                parent[ulParV] = ulParU;
                size[ulParU] = size[ulParU] + size[ulParV];
            } else {
                parent[ulParU] = ulParV;
                size[ulParV] = size[ulParU] + size[ulParV];
            }
        }
    }
}