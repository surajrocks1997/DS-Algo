package com.SlidingWindow_2Pointer;

import java.util.Arrays;

// https://leetcode.com/problems/maximum-points-you-can-obtain-from-cards/description/

public class MaxPointsObtainFromCards {
    public static void main(String[] args) {
        int[] cardPoints = {1, 2, 3, 4, 5, 6, 1};
        int k = 3;

        int result = solve(cardPoints, k);
        System.out.println(result);
    }

    private static int solve(int[] cardPoints, int k) {
        if (cardPoints.length == k)
            return Arrays.stream(cardPoints).sum();

        int sum = 0;
        for (int i = 0; i < k; i++) {
            sum += cardPoints[i];
        }

        int max = sum;
        int i = k - 1;
        int j = cardPoints.length - 1;
        while (i >= 0) {
            sum = sum - cardPoints[i--] + cardPoints[j--];
            max = Math.max(max, sum);
        }

        return max;
    }
}
