package com.graph.hard;

import java.util.*;

//https://leetcode.com/problems/find-the-safest-path-in-a-grid/description/

public class demo {

    public static void main(String[] args) {
        List<List<Integer>> grid = new ArrayList<>();
        grid.add(new ArrayList<>(Arrays.asList(0, 0, 0, 1)));
        grid.add(new ArrayList<>(Arrays.asList(0, 0, 0, 0)));
        grid.add(new ArrayList<>(Arrays.asList(0, 0, 0, 0)));
        grid.add(new ArrayList<>(Arrays.asList(1, 0, 0, 0)));

        int result = solve(grid);
        System.out.println(result);

    }

    private static int solve(List<List<Integer>> grid) {
        int m = grid.size();
        int n = grid.get(0).size();

        Queue<Tuple> queue = new LinkedList<>();
        int[][] visited = new int[m][n];
        int[][] ans = new int[m][n];

        for (int row = 0; row < m; row++) {
            for (int col = 0; col < n; col++) {
                if (grid.get(row).get(col) == 1) {
                    queue.add(new Tuple(0, row, col));
                    visited[row][col] = 1;
                }
            }
        }

        int[] delrow = {-1, 0, 1, 0};
        int[] delcol = {0, 1, 0, -1};

        while (!queue.isEmpty()) {
            Tuple p = queue.poll();
            int r = p.row;
            int c = p.col;
            int distance = p.distance;

            for (int i = 0; i < 4; i++) {
                int nrow = r + delrow[i];
                int ncol = c + delcol[i];

                if (nrow >= 0 && nrow < m && ncol >= 0 && ncol < n) {
                    if (visited[nrow][ncol] == 0) {
                        ans[nrow][ncol] = distance + 1;
                        queue.add(new Tuple(ans[nrow][ncol], nrow, ncol));
                        visited[nrow][ncol] = 1;
                    } else {
                        ans[nrow][ncol] = Math.min(ans[nrow][ncol], distance + 1);
                    }
                }
            }
        }

        PriorityQueue<Tuple> pq = new PriorityQueue<Tuple>((a, b) -> b.distance - a.distance);
        pq.add(new Tuple(ans[0][0], 0, 0));
        visited[0][0] = 0;

        while (!pq.isEmpty()) {
            Tuple poll = pq.poll();
            int row = poll.row;
            int col = poll.col;
            int distance = poll.distance;

            if (row == m - 1 && col == n - 1)
                return distance;

            for (int i = 0; i < 4; i++) {
                int nrow = row + delrow[i];
                int ncol = col + delcol[i];

                if (nrow >= 0 && nrow < m && ncol >= 0 && ncol < n) {
                    if (visited[nrow][ncol] == 1) {
                        pq.add(new Tuple(Math.min(distance, ans[nrow][ncol]), nrow, ncol));
                        visited[nrow][ncol] = 0;
                    }
                }
            }
        }

        return -1;
    }
}

class Tuple {

    int distance;
    int row;
    int col;

    public Tuple(int distance, int row, int col) {
        this.distance = distance;
        this.row = row;
        this.col = col;
    }
}