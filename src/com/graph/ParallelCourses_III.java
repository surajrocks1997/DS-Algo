package com.graph;

import java.util.*;

// https://leetcode.com/problems/parallel-courses-iii/description/?envType=daily-question&envId=2023-10-18
public class ParallelCourses_III {
    public static void main(String[] args) {
        int n = 5;
        int[][] relations = {
                {1, 5},
                {2, 5},
                {3, 4},
                {3, 5},
                {4, 5}
        };

        int[] time = {1, 2, 3, 4, 5};

        int result = solve(n, relations, time);
        System.out.println(result);
    }

    private static int solve(int n, int[][] relations, int[] time) {
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i <= n; i++)
            adj.add(new ArrayList<>());

        for (int i = 0; i < relations.length; i++) {
            adj.get(relations[i][0]).add(relations[i][1]);
        }

        int[] indegree = new int[n + 1];

        for (int i = 0; i <= n; i++) {
            for (int it : adj.get(i))
                indegree[it]++;
        }

        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> a.step - b.step);
        for (int i = 1; i <= n; i++)
            if (indegree[i] == 0)
                pq.add(new Pair(0, i));

        int minMonths = 0;

        while (!pq.isEmpty()) {
            int size = pq.size();

            int max = Integer.MIN_VALUE;
            for (int i = 0; i < size; i++) {
                Pair poll = pq.poll();
                int step = poll.step;
                max = Math.max(max, poll.element - 1 >= 0 ? time[poll.element - 1] : max);

                for (int it : adj.get(poll.element)) {
                    indegree[it]--;
                    if (indegree[it] == 0)
                        pq.add(new Pair(step + 1, it));
                }
            }
            minMonths += max;
        }

        return minMonths;
    }
}

class Pair {
    int step;
    int element;

    public Pair(int step, int element) {
        this.step = step;
        this.element = element;
    }
}