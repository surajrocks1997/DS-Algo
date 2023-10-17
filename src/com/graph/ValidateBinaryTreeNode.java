package com.graph;

import java.util.*;

//https://leetcode.com/problems/validate-binary-tree-nodes/?envType=daily-question&envId=2023-10-17
public class ValidateBinaryTreeNode {
    public static void main(String[] args) {
        int n = 4;
        int[] leftChild = {1, -1, 3, -1};
        int[] rightChild = {2, -1, -1, -1};

        boolean result = solve(n, leftChild, rightChild);
        System.out.println(result);
    }

    private static boolean solve(int n, int[] leftChild, int[] rightChild) {
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++)
            adj.add(new ArrayList<>());

        for (int i = 0; i < n; i++) {
            if (leftChild[i] != -1)
                adj.get(i).add(leftChild[i]);
            if (rightChild[i] != -1)
                adj.get(i).add(rightChild[i]);
        }

        int[] indegree = new int[n];
        for (int i = 0; i < n; i++) {
            for (int it : adj.get(i)) {
                indegree[it]++;
            }
        }

        Queue<Integer> queue = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            if (indegree[i] > 1) return false;
            if (indegree[i] == 0)
                queue.add(i);
        }

        if (queue.size() != 1) return false;

        int count = 0;
        while (!queue.isEmpty()) {
            int poll = queue.poll();
            count++;
            for (int it : adj.get(poll)) {
                indegree[it]--;
                if (indegree[it] == 0)
                    queue.add(it);
            }
        }

        return count == n;
    }
}
