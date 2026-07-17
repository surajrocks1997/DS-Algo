package com.greedy.medium;

import java.util.Arrays;

public class NonOverlappingIntervals {
    public static void main(String[] args) {
        int[][] intervals = {
                {1,2},
                {2,3},
                {3,4},
                {1,3}
        };

        int removals = solve(intervals);
        System.out.println(removals);
    }

    private static int solve(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[1] - b[1]);
        Arrays.stream(intervals).forEach(interval -> System.out.println(Arrays.toString(interval)));

        int count = 0;
        int lastEndTime = intervals[0][1];
        for(int i = 1; i < intervals.length; i++){
            if(intervals[i][0] >= lastEndTime){
                count++;
                lastEndTime = intervals[i][1];
            }
        }

        return intervals.length -1 - count;
    }
}
