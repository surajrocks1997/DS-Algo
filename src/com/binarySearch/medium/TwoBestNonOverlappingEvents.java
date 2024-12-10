package com.binarySearch.medium;

// https://leetcode.com/problems/two-best-non-overlapping-events/description

import java.util.Arrays;

public class TwoBestNonOverlappingEvents {
    public static void main(String[] args) {
        int[][] events = {
                {1, 5, 3},
                {1, 5, 1},
                {6, 6, 5}
        };

        int result = solve(events);
        System.out.println(result);
    }

    private static int solve(int[][] events) {
        int n = events.length;

        Arrays.sort(events, (a, b) -> a[1] - b[1]);

        int[] preprocess = new int[n];
        preprocess[0] = events[0][2];

        for (int i = 1; i < n; i++)
            preprocess[i] = Math.max(preprocess[i - 1], events[i][2]);

        int max = 0;

        for (int i = 0; i < n; i++) {
            int ans = 0;

            if (i > 0) {
                int low = 0;
                int high = i - 1;


                while (low <= high) {
                    int mid = low + (high - low) / 2;

                    if (events[i][0] > events[mid][1]) {
                        ans = preprocess[mid];
                        low = mid + 1;
                    } else {
                        high = mid - 1;
                    }

                }


            }

            max = Math.max(max, Math.max(events[i][2], events[i][2] + ans));
        }
        return max;
    }
}
