package com.binarySearch.BSinSearchSpace;

import java.util.ArrayList;
import java.util.Arrays;

public class PainterPartitionProblem {
    public static void main(String[] args) {
        ArrayList<Integer> boards = new ArrayList<>(Arrays.asList(10, 20, 30, 40));
        int k = 2;
        int result = solve(boards, k);
        System.out.println(result);
    }

    private static int solve(ArrayList<Integer> boards, int k) {
        int low = Integer.MIN_VALUE;
        int high = 0;

        for (int ele : boards) {
            low = Math.max(low, ele);
            high += ele;
        }

        if (k == 1) return high;

        int ans = 0;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (isPossible(boards, k, mid)) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return ans;
    }

    private static boolean isPossible(ArrayList<Integer> boards, int k, int mid) {
        int partitions = 0;
        int count = 0;
        for (int ele : boards) {
            if (count + ele > mid) {
                partitions++;
                count = 0;
            }
            count += ele;

            if (partitions > k) return false;
        }
        if (count > 0) partitions++;
        return partitions <= k;
    }
}
