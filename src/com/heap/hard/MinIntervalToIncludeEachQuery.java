package com.heap.hard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

// https://leetcode.com/problems/minimum-interval-to-include-each-query/description/
public class MinIntervalToIncludeEachQuery {
    public static void main(String[] args) {
        int[][] intervals = {
                {4, 5},
                {5, 8},
                {1, 9},
                {8, 10},
                {1, 6}
        };
        int[] queries = {7, 9, 3, 9, 3};
        int[] result = solve(intervals, queries);
        Arrays.stream(result).forEach(System.out::println);
    }

    private static int[] solve(int[][] intervals, int[] queries) {
        List<Pair> queryList = new ArrayList<>();

        for (int i = 0; i < queries.length; i++) {
            queryList.add(new Pair(queries[i], i));
        }

        queryList.sort((a, b) -> a.num - b.num);

        Arrays.sort(intervals, ((a, b) -> a[0] - b[0]));

        int index = 0;
        int[] result = new int[queries.length];
        PriorityQueue<Pair2> pq = new PriorityQueue<>((a, b) -> a.size - b.size);

        for (Pair p : queryList) {
            while (index < intervals.length && p.num >= intervals[index][0]) {
                pq.add(new Pair2(intervals[index][1] - intervals[index][0] + 1, intervals[index][1]));
                index++;
            }
            while (!pq.isEmpty() && p.num > pq.peek().rightIndex)
                pq.poll();

            if (pq.isEmpty())
                result[p.index] = -1;
            else
                result[p.index] = pq.peek().size;
        }

        return result;
    }
}

class Pair {
    int num;
    int index;

    public Pair(int num, int index) {
        this.num = num;
        this.index = index;
    }
}

class Pair2 {
    int size;
    int rightIndex;

    public Pair2(int size, int rightIndex) {
        this.size = size;
        this.rightIndex = rightIndex;
    }
}
