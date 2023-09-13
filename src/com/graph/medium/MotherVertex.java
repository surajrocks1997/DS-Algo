package com.graph.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class MotherVertex {
    public static void main(String[] args) {
        List<List<Integer>> adj = new ArrayList<>();
        List<Integer> curr = new ArrayList<>(Arrays.asList(3,2));
        adj.add(curr);

        curr = new ArrayList<>(Collections.singleton(0));
        adj.add(curr);
        curr = new ArrayList<>(Collections.singleton(1));
        adj.add(curr);
        curr = new ArrayList<>(Collections.singleton(4));
        adj.add(curr);
        curr = new ArrayList<>(Collections.emptyList());
        adj.add(curr);

        List<Integer> result = solve(adj);
        System.out.println(result);
    }

    private static List<Integer> solve(List<List<Integer>> adj) {
        List<Integer> result = new ArrayList<>();

        for (int i = 0; i < adj.size(); i++) {
            int[] visited = new int[adj.size()];
            int[] count = new int[1];
            if (dfs(adj, visited, i, count) == adj.size() - 1)
                result.add(i);
        }
        return result;
    }

    private static int dfs(List<List<Integer>> adj, int[] visited, int index, int[] count) {
        visited[index] = 1;

        for (int it : adj.get(index)) {
            if (visited[it] == 0) {
                count[0]++;
                dfs(adj, visited, it, count);
            }
        }

        return count[0];

    }
}
