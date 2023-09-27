package com.arrays;

import java.util.HashSet;
import java.util.Set;

public class longestConsecutiveSequence {
    public static void main(String[] args) {
        int[] arr = {102, 4, 100, 1, 101, 3, 2, 1, 1};

        int result = solve(arr);
        System.out.println(result);
    }

    private static int solve(int[] arr) {
        Set<Integer> set = new HashSet<Integer>();
        for (int num : arr) {
            set.add(num);
        }

        int max = 0;

        for (int j : arr) {
            if (!set.contains(j)) continue;
            int count = 1;
            int num = j;
            set.remove(j);
            while (set.contains(--num)) {
                count++;
                set.remove(num);
            }

            num = j;
            while (set.contains(++num)) {
                count++;
                set.remove(num);
            }

            max = Math.max(max, count);

        }

        return max;
    }
}
