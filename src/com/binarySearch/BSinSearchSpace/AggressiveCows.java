package com.binarySearch.BSinSearchSpace;

import java.util.Arrays;

public class AggressiveCows {
    public static void main(String[] args) {
        int[] stalls = {0, 3, 4, 7, 10, 9};
        int k = 4;

        int result = solve(stalls, k);
        System.out.println(result);
    }

    private static int solve(int[] stalls, int k) {
        Arrays.sort(stalls);
        int n = stalls.length;

        int low = 0;
        int high = stalls[n - 1] - stalls[0];

        int ans = -1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (canPlaceCows(stalls, mid, k)) {
                ans = mid;
                low = mid + 1;
            } else
                high = mid - 1;
        }
        return ans;
    }

    private static boolean canPlaceCows(int[] stalls, int distance, int cows) {
        int cowsPlaced = 1;
        int lastPlacedCow = stalls[0];

        for (int i = 1; i < stalls.length; i++) {
            if (stalls[i] - lastPlacedCow >= distance) {
                lastPlacedCow = stalls[i];
                cowsPlaced++;
            }

            if (cowsPlaced >= cows) return true;
        }
        return false;
    }
}
