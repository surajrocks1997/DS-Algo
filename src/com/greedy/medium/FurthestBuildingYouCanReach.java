package com.greedy.medium;

//https://leetcode.com/problems/furthest-building-you-can-reach/description

import java.util.Collections;
import java.util.PriorityQueue;

public class FurthestBuildingYouCanReach {

    public static void main(String[] args) {
        int[] heights = {0, 2, 1, 2, 0, 3, 2};
        int bricks = 3;
        int ladders = 2;

        int result = solve(heights, bricks, ladders);
        System.out.println(result);
    }

    private static int solve(int[] heights, int bricks, int ladders) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        for (int i = 0; i < heights.length - 1; i++) {
            if (heights[i] >= heights[i + 1]) continue;

            int required = heights[i + 1] - heights[i];
            bricks -= required;
            pq.add(required);

            if (bricks < 0) {
                bricks += pq.poll();
                if (ladders > 0) ladders--;
                else return i;
            }
        }
        return heights.length - 1;
    }
}