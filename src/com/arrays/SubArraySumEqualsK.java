package com.arrays;

import java.util.HashMap;
import java.util.Map;

public class SubArraySumEqualsK {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, -3, 1, 1, 1, 4, 2, -3};
        int k = 3;
        int count = solve(arr, k);
        System.out.println(count);
    }

    private static int solve(int[] arr, int k) {

        if (arr.length == 1 && arr[0] != k) return 0;

        Map<Integer, Integer> map = new HashMap<>();
        int preSum = 0;
        int count = 0;
        map.put(0, 1);
        for (int j : arr) {
            preSum += j;

            int rem = preSum - k;
            count += map.getOrDefault(rem, 0);

            map.put(preSum, map.getOrDefault(preSum, 0) + 1);


        }

        return count;
    }
}
