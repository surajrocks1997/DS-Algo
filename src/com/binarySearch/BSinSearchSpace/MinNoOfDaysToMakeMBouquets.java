package com.binarySearch.BSinSearchSpace;

import java.util.Arrays;

// https://leetcode.com/problems/minimum-number-of-days-to-make-m-bouquets/description/
public class MinNoOfDaysToMakeMBouquets {
    public static void main(String[] args) {
        int[] bloomDay = {1, 10, 3, 10, 2};
        int m = 3;
        int k = 1;

        int minDays = solve(bloomDay, m, k);
        System.out.println(minDays);
    }

    private static int solve(int[] bloomDay, int m, int k) {
        if (m * k > bloomDay.length) return -1;

        int high = Integer.MIN_VALUE;
        int low = Integer.MAX_VALUE;

        for (int ele : bloomDay) {
            high = Math.max(high, ele);
            low = Math.min(low, ele);
        }
        int ans = Integer.MAX_VALUE;
        System.out.println(high >= 2147483647);

        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (isReqBouqPossible(mid, bloomDay, m, k)) {
                ans = mid;
                high = mid - 1;
            } else
                low = mid + 1;
        }

        return ans;
    }

    private static boolean isReqBouqPossible(int mid, int[] bloomDay, int m, int k) {
        int count = 0;
        int bouquets = 0;
        for (int ele : bloomDay) {
            if (ele <= mid)
                count++;
            else {
                bouquets += count / k;
                count = 0;
            }

            if (bouquets >= m || (count / k) >= m) return true;
        }

        bouquets += count / k;  // edge case when last index of bloomDay has bloomed and k is 1
        return bouquets >= m;
    }
}
