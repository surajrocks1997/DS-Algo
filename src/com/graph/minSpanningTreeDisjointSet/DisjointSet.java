package com.graph.minSpanningTreeDisjointSet;

public class DisjointSet {
    public static void main(String[] args) {
        DisjointSet_Class dsRank = new DisjointSet_Class(7);
        dsRank.unionByRank(1,2);
        dsRank.unionByRank(2,3);
        dsRank.unionByRank(4,5);
        dsRank.unionByRank(6,7);
        dsRank.unionByRank(5,6);

        if(dsRank.findUltimateParent(3) == dsRank.findUltimateParent(7))
            System.out.println("Same");
        else
            System.out.println("Not Same");

        dsRank.unionByRank(3,7);

        if(dsRank.findUltimateParent(3) == dsRank.findUltimateParent(7))
            System.out.println("Same");
        else
            System.out.println("Not Same");


        DisjointSet_Class dsSize = new DisjointSet_Class(7);
        dsSize.unionBySize(1,2);
        dsSize.unionBySize(2,3);
        dsSize.unionBySize(4,5);
        dsSize.unionBySize(6,7);
        dsSize.unionBySize(5,6);

        if(dsSize.findUltimateParent(3) == dsSize.findUltimateParent(7))
            System.out.println("Same");
        else
            System.out.println("Not Same");

        dsSize.unionByRank(3,7);

        if(dsSize.findUltimateParent(3) == dsSize.findUltimateParent(7))
            System.out.println("Same");
        else
            System.out.println("Not Same");

    }
}
