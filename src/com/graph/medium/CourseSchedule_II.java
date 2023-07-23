package com.graph.medium;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class CourseSchedule_II {
    public static void main(String[] args) {
        int numCourses = 4;
        int[][] prerequisites = {
                {1, 0},
                {2, 0},
                {3, 1},
                {3, 2}
        };

        int[] result = solve(numCourses, prerequisites);
        for (int ele : result)
            System.out.print(ele + " ");
    }

    private static int[] solve(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            adj.add(new ArrayList<>());
        }

        for (int[] prerequisite : prerequisites)
            adj.get(prerequisite[1]).add(prerequisite[0]);

        int[] indegree = new int[numCourses];

        for (int i = 0; i < numCourses; i++) {
            for (int it : adj.get(i))
                indegree[it]++;
        }

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++)
            if (indegree[i] == 0) queue.add(i);

        int[] topo = new int[numCourses];
        int count = 0;

        while (!queue.isEmpty()) {
            int node = queue.poll();
            topo[count++] = node;

            for (int it : adj.get(node)) {
                indegree[it]--;
                if (indegree[it] == 0) queue.add(it);
            }
        }
        return count == numCourses ? topo : new int[]{};
    }
}
