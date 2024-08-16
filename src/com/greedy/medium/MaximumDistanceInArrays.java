package com.greedy.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// https://leetcode.com/problems/maximum-distance-in-arrays/description/
public class MaximumDistanceInArrays {
    public static void main(String[] args) {
        List<List<Integer>> arrays = new ArrayList<>();
        arrays.add(new ArrayList<>(Arrays.asList(1,2,3)));
        arrays.add(new ArrayList<>(Arrays.asList(4,5)));
        arrays.add(new ArrayList<>(Arrays.asList(7,8,9)));

        int result = solve(arrays);
        System.out.println(result);
    }

    private static int solve(List<List<Integer>> arrays) {
        int n = arrays.size();
        int curr_min = arrays.getFirst().getFirst();
        int curr_max = arrays.getFirst().getLast();
        int result = 0;

        for(int i = 1; i < n; i++){
            int min = arrays.get(i).getFirst();
            int max = arrays.get(i).getLast();
            result = Math.max(result, Math.max(max - curr_min, curr_max - min));

            curr_min = Math.min(curr_min, min);
            curr_max = Math.max(curr_max, max);
        }

        return result;

    }
}
