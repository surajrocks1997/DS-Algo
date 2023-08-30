package com.arrays;

import java.util.HashMap;
import java.util.Map;

public class BinarySubArraysWithSum {
    public static void main(String[] args) {
        int[] arr = {1,0,1,0,1};
        int goal = 2;

        int result = solve(arr, goal);
        System.out.println(result);
    }

    private static int solve(int[] arr, int goal) {
        if (arr.length == 1 && arr[0] != goal) return 0;

        Map<Integer, Integer> map = new HashMap<>();
        int preSum = 0;
        int count = 0;
        map.put(0, 1);
        for (int j : arr) {
            preSum += j;

            int rem = preSum - goal;
            count += map.getOrDefault(rem, 0);

            map.put(preSum, map.getOrDefault(preSum, 0) + 1);


        }

        return count;
    }
}
