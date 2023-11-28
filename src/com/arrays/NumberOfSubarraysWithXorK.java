package com.arrays;

import java.util.HashMap;
import java.util.Map;

public class NumberOfSubarraysWithXorK {
    public static void main(String[] args) {
        int[] a = {1, 2, 3, 2};
        int b = 2;

        int result = solve(a, b);
        System.out.println(result);
    }

    private static int solve(int[] a, int b) {
        int xor = 0;
        Map<Integer, Integer> frontXor = new HashMap<>();   // xor, count
        frontXor.put(0, 1); // initial setup
        int count = 0;

        for (int ele : a) {
            xor ^= ele;

            if (frontXor.containsKey(xor ^ b)) {
                count += frontXor.get(xor ^ b);
            }

            frontXor.put(xor, frontXor.getOrDefault(xor, 0) + 1);
        }
        return count;
    }


}
