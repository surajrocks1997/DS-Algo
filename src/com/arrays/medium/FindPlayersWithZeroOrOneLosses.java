package com.arrays.medium;

import java.util.*;

// https://leetcode.com/problems/find-players-with-zero-or-one-losses/

public class FindPlayersWithZeroOrOneLosses {
    public static void main(String[] args) {
        int[][] matches = {
                {1, 3},
                {2, 3},
                {3, 6},
                {5, 6},
                {5, 7},
                {4, 5},
                {4, 8},
                {4, 9},
                {10, 4},
                {10, 9}
        };

        List<List<Integer>> result = solve(matches);
        System.out.println(result);
    }

    private static List<List<Integer>> solve(int[][] matches) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int[] match : matches) {
            int winVal = map.getOrDefault(match[0], 0);
            map.put(match[0], winVal <= -1 ? winVal : winVal + 1);

            int loseVal = map.getOrDefault(match[1], 0);
            map.put(match[1], loseVal >= 0 ? -1 : loseVal - 1);
        }

        List<List<Integer>> result = Arrays.asList(new ArrayList<>(), new ArrayList<>());

        for (int key : map.keySet()) {
            if (map.get(key) > 0) result.get(0).add(key);
            else if (map.get(key) == -1) result.get(1).add(key);
        }
        Collections.sort(result.get(0));
        Collections.sort(result.get(1));
        return result;
    }
}
