package com.greedy.easy;

import java.util.*;

public class NMeetingsIn1Room {
    public static void main(String[] args) {
        int[] start = {1, 3, 0, 5, 8, 5};
        int[] end = {2, 4, 6, 7, 9, 9};
        int n = 6;
        int result = solve(start, end, n);
        System.out.println(result);

    }

    private static int solve(int[] start, int[] end, int n) {
        List<MeetingWithIndex> list = new ArrayList<>();
        for (int i = 0; i < start.length; i++) {
            list.add(new MeetingWithIndex(start[i], end[i], i));
        }

        list.sort(Comparator.comparingInt(a -> a.end));

        int count = 0;
        int currentEnd = -1;
        for (MeetingWithIndex current : list) {
            if (currentEnd < current.start) {
                count++;
                currentEnd = current.end;
            }
        }

        return count;
    }
}

class MeetingWithIndex {
    int start;
    int end;
    int index;

    public MeetingWithIndex(int start, int end, int index) {
        this.start = start;
        this.end = end;
        this.index = index;
    }
}
