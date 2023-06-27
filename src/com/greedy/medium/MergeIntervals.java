package com.greedy.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class MergeIntervals {
    public static void main(String[] args) {
        int[][] intervals = {
                {1, 3},
                {2, 6},
                {8, 10},
                {15, 18}
        };
        int[][] result = solve(intervals);
        for (int[] arr : result)
            System.out.println(arr[0] + " " + arr[1]);
    }

    private static int[][] solve(int[][] intervals) {
        if (intervals.length == 1) return intervals;

        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));

        int[] currentInterval = intervals[0];
        List<int[]> result = new ArrayList<>();
        result.add(currentInterval);

        for (int i = 1; i < intervals.length; i++) {
            int currentEnd = currentInterval[1];
            int nextBegin = intervals[i][0];
            int nextEnd = intervals[i][1];

            if (currentEnd >= nextBegin) {
                currentInterval[1] = Math.max(currentEnd, nextEnd);
            } else {
                currentInterval = new int[]{nextBegin, nextEnd};
                result.add(currentInterval);
            }
        }

        return result.toArray(new int[result.size()][]);
    }
}
