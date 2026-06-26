package com.arrays.medium;

import java.util.HashMap;
import java.util.Map;

// https://leetcode.com/problems/detect-squares/
public class DetectSquares {
    public static void main(String[] args) {
        CountSquares countSquares = new CountSquares();
        countSquares.add(new int[]{1, 1});
        countSquares.add(new int[]{2, 2});
        countSquares.add(new int[]{1, 2});
        countSquares.count(new int[]{2, 1});   // return 1.
        countSquares.count(new int[]{3, 3});   // return 0.
        countSquares.add(new int[]{2, 2});     // Duplicate points are allowed.
        countSquares.count(new int[]{2, 1});   // return 2.
    }
}

class CountSquares {
    Map<Integer, Map<Integer, Integer>> map;

    public CountSquares() {
        map = new HashMap<>();

    }

    public void add(int[] point) {
        Map<Integer, Integer> val = this.map.getOrDefault(point[0], new HashMap<>());
        val.put(point[1], val.getOrDefault(point[1], 0) + 1);
        map.put(point[0], val);
    }

    public int count(int[] point) {
        int x1 = point[0];
        int y1 = point[1];
        int res = 0;

        if (!map.containsKey(x1)) return 0;

        Map<Integer, Integer> yMap = this.map.get(x1);
        for (int y2 : yMap.keySet()) {
            if (y2 == y1) continue;

            int side = y2 - y1;
            int[] xCandidates = {x1 + side, x1 - side};
            for (int x2 : xCandidates) {
                Map<Integer, Integer> candidates = this.map.get(x2);
                int c1 = candidates == null ? 0 : candidates.getOrDefault(y1, 0);
                int c2 = candidates == null ? 0 : candidates.getOrDefault(y2, 0);
                res += yMap.get(y2) * c1 * c2;
            }

        }
        System.out.println(res);
        return res;
    }
}
