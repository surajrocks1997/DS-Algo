package com.graph.hard;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class AlienDictionary {
    public static void main(String[] args) {
        String[] dict = {"baa", "abcd", "abca", "cab", "cad"};
        int N = 5;
        int K = 4;

        String result = solve(dict, N, K);
        System.out.println(result);
    }

    private static String solve(String[] dict, int N, int K) {
        List<List<Integer>> adj = new ArrayList<>();

        for (int i = 0; i < K; i++) {
            adj.add(new ArrayList<>());
        }

        for (int i = 0; i < N - 1; i++) {
            String s1 = dict[i];
            String s2 = dict[i + 1];
            int minLength = Math.min(s1.length(), s2.length());

            for (int j = 0; j < minLength; j++) {
                if (s1.charAt(j) != s2.charAt(j)) {
                    adj.get(s1.charAt(j) - 'a').add(s2.charAt(j) - 'a');
                    break;
                }
            }
        }

        List<Integer> topo = topoSort(K, adj);

        StringBuilder ans = new StringBuilder();
        for (int it : topo)
            ans.append((char) (it + (int) ('a')));

        return ans.toString();
    }

    private static List<Integer> topoSort(int V, List<List<Integer>> adj) {
        int[] indegree = new int[V];

        for (int i = 0; i < V; i++) {
            for (int it : adj.get(i))
                indegree[it]++;
        }

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < V; i++) {
            if (indegree[i] == 0)
                queue.add(i);
        }

        List<Integer> topo = new ArrayList<>();

        while (!queue.isEmpty()) {
            int node = queue.poll();
            topo.add(node);

            for (int it : adj.get(node)) {
                indegree[it]--;
                if (indegree[it] == 0)
                    queue.add(it);
            }
        }

        return topo;
    }
}
