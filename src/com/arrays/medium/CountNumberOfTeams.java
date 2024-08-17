package com.arrays.medium;

import java.util.HashMap;
import java.util.Map;

//https://leetcode.com/problems/count-number-of-teams/description/
public class CountNumberOfTeams {

    public static void main(String[] args) {
        int[] rating = {2, 5, 3, 4, 1};
        int result = solve(rating);
        System.out.println(result);

        result = dpSolve(rating);
        System.out.println(result);
    }

    private static int solve(int[] rating) {
        int result = 0;
        int n = rating.length;

        for (int i = 1; i < n - 1; i++) {
            int leftSmaller = 0;
            int rightLarger = 0;

            for (int j = 0; j < i; j++) {
                if (rating[j] < rating[i])
                    leftSmaller++;
            }

            for (int j = i + 1; j < n; j++) {
                if (rating[j] > rating[i])
                    rightLarger++;
            }

            result += leftSmaller * rightLarger;

            int leftLarger = i - leftSmaller;
            int rightSmaller = n - i - 1 - rightLarger;

            result += leftLarger * rightSmaller;
        }
        return result;
    }

    private static int dpSolve(int[] rating) {
        int result = 0;
        Map<Tuple, Integer> cache = new HashMap<>();
        for (int i = 0; i < rating.length - 2; i++) {
            result += helper(i, true, 1, rating, cache);
            result += helper(i, false, 1, rating, cache);
        }
        return result;
    }

    private static int helper(int index, boolean isIncreasing, int count, int[] rating, Map<Tuple, Integer> cache) {
        Tuple key = new Tuple(index, isIncreasing, count);
        if (cache.containsKey(key))
            return cache.get(key);
        if (count == 3) return 1;

        if (index == rating.length) return 0;


        int result = 0;
        for (int i = index + 1; i < rating.length; i++) {
            if (isIncreasing && rating[index] < rating[i])
                result += helper(i, isIncreasing, count + 1, rating, cache);
            if (!isIncreasing && rating[index] > rating[i])
                result += helper(i, isIncreasing, count + 1, rating, cache);
        }

        cache.put(key, result);
        return result;
    }
}

class Tuple {
    int index;
    boolean isIncreasing;
    int count;

    public Tuple(int index, boolean isIncreasing, int count) {
        this.index = index;
        this.isIncreasing = isIncreasing;
        this.count = count;
    }
}
