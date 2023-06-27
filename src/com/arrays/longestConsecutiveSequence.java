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
        Set<Integer> hashSet = new HashSet<Integer>();
        for (int num : arr) {
            hashSet.add(num);
        }

        int longestStreak = 0;

        for (int num : arr) {
            if (!hashSet.contains(num - 1)) {
                int currentNum = num;
                int currentStreak = 1;

                while (hashSet.contains(currentNum + 1)) {
                    currentNum += 1;
                    currentStreak += 1;
                }

                longestStreak = Math.max(longestStreak, currentStreak);
            }
        }

        return longestStreak;
    }
}
