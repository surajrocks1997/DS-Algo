package com.graph.medium;

import java.util.ArrayList;
import java.util.List;

public class NumberOfProvinces {
    public static void main(String[] args) {
        int[][] isConnected = {
                {1, 1, 0},
                {1, 1, 0},
                {0, 0, 1}
        };

        int result = solve(isConnected);
        System.out.println(result);
    }

    private static int solve(int[][] isConnected) {
        List<List<Integer>> adjList = new ArrayList<>();

        int V = isConnected.length;
        for (int i = 0; i < V; i++)
            adjList.add(new ArrayList<>());

        for (int i = 0; i < V; i++) {
            for (int j = 0; j < V; j++) {
                if (i != j && isConnected[i][j] == 1) {
                    adjList.get(i).add(j);
                }
            }
        }

        int[] vis = new int[V];
        int count = 0;
        for (int i = 0; i < V; i++) {
            if (vis[i] == 0) {
                count++;
                dfs(i, adjList, vis);
            }
        }

        return count;
    }

    private static void dfs(int node, List<List<Integer>> adjList, int[] vis) {
        vis[node] = 1;
        for (Integer it : adjList.get(node))
            if (vis[it] == 0)
                dfs(it, adjList, vis);
    }
}


//other possible solution

//class Solution {
//    public int findCircleNum(int[][] M) {
//
//        int N = M.length;
//        boolean[]visited = new boolean[N];
//        int count = 0;
//
//        for(int i = 0; i < N ;i++){
//            if(!visited[i]){
//                count++;
//                dfs(M,i,visited);
//            }
//        }
//        return count;
//    }
//
//
//    private void dfs(int[][]M,int i,boolean[]visited){
//        for(int j = 0 ; j < M[i].length ; j++){
//            if(!visited[j] && M[i][j] != 0){
//                visited[j] = true;
//                dfs(M,j,visited);
//            }
//        }
//    }
//}
