package com.greedy.medium;

import java.util.Comparator;
import java.util.PriorityQueue;

// https://leetcode.com/problems/maximum-average-pass-ratio/
public class MaximumAvgPassRatio {

    public static void main(String[] args) {
        int[][] classes = {
                {1, 2},
                {3, 5},
                {2, 2}
        };

        int extraStudents = 2;
        double result = solve(classes, extraStudents);
        System.out.println(result);
    }

    private static double solve(int[][] classes, int extraStudents) {
        int n = classes.length;
        PriorityQueue<DS> pq = new PriorityQueue<>(new Compare());
        for (int[] row : classes) {
            pq.add(new DS(row[0], row[1]));
        }

        while (extraStudents-- != 0) {
            DS poll = pq.poll().addOne();
            pq.add(new DS(poll.n, poll.d));
        }

        double result = 0;
        while (!pq.isEmpty()) {
            DS poll = pq.poll();
            result += (double) poll.n / poll.d;
        }

        return result / n;
    }
}

class DS {
    int n;
    int d;
    double inc;

    public DS(int n, int d) {
        this.n = n;
        this.d = d;
        this.inc = getIncrement();
    }

    public DS addOne() {
        this.n++;
        this.d++;
        this.inc = getIncrement();
        return this;
    }

    private double getIncrement() {
        return (double) (this.n + 1) / (this.d + 1) - (double) (this.n) / (this.d);
    }
}

class Compare implements Comparator<DS> {
    public int compare(DS a, DS b) {
        if (a.inc < b.inc)
            return 1;
        else if (a.inc > b.inc)
            return -1;
        else
            return 0;
    }
}