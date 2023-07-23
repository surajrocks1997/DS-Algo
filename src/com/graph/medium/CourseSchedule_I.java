package com.graph.medium;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class CourseSchedule_I {
    public static void main(String[] args) {
        int numCourses = 2;
        int[][] prerequisites = {
                {1, 0},
                {0, 1}
        };

        boolean result = solve(numCourses, prerequisites);
        System.out.println(result);
    }

    private static boolean solve(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            adj.add(new ArrayList<>());
        }

        for (int[] prerequisite : prerequisites)
            adj.get(prerequisite[0]).add(prerequisite[1]);

        int[] indegree = new int[numCourses];

        for (int i = 0; i < numCourses; i++) {
            for (int it : adj.get(i))
                indegree[it]++;
        }

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++)
            if (indegree[i] == 0) queue.add(i);

        List<Integer> topo = new ArrayList<>();

        while (!queue.isEmpty()) {
            int node = queue.poll();
            topo.add(node);

            for (int it : adj.get(node)) {
                indegree[it]--;
                if (indegree[it] == 0) queue.add(it);
            }
        }
        return topo.size() == numCourses;
    }
}
