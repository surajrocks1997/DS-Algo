package com.graph.hard;

import java.util.*;

public class BusRoutes {

    public static void main(String[] args) {
        int[][] routes = {
                {1, 2, 3},
                {1, 4, 5},
                {5, 8, 7},
                {3, 6, 7}
        };
        int source = 1;
        int target = 7;

        int result = solve(routes, source, target);
        System.out.println(result);
    }

    private static int solve(int[][] routes, int source, int target) {
        if (source == target) return 0;

        HashMap<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < routes.length; i++) {
            for (int j = 0; j < routes[i].length; j++) {
                map.computeIfAbsent(routes[i][j], (k) -> new ArrayList<>()).add(i);
            }
        }

        if (!map.containsKey(source)) return -1;

        int ans = 0;
        Set<Integer> visited = new HashSet<>();
        Queue<Integer> queue = new LinkedList<>();
        queue.add(source);

        while (!queue.isEmpty()) {
            int size = queue.size();
            ans++;

            for (int i = 0; i < size; i++) {
                int pollVal = queue.poll();

                for (int it : map.get(pollVal)) {
                    if (visited.contains(it))
                        continue;

                    visited.add(it);

                    for (int j = 0; j < routes[it].length; j++) {
                        if (target == routes[it][j])
                            return ans;

                        queue.add(routes[it][j]);
                    }
                }
            }
        }

        return -1;
    }

}
