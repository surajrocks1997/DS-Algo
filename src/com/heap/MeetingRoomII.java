package com.heap;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

//https://neetcode.io/problems/meeting-schedule-ii/question?list=neetcode150
public class MeetingRoomII {
    public static void main(String[] args) {
        List<Interval> intervals = new ArrayList<>();
        intervals.add(new Interval(1, 5));
        intervals.add(new Interval(2, 6));
        intervals.add(new Interval(3, 7));
        intervals.add(new Interval(4, 8));
        intervals.add(new Interval(5, 9));

//        intervals.add(new Interval(0, 40));
//        intervals.add(new Interval(5, 10));
//        intervals.add(new Interval(15, 20));


        int result = findMinMeetingRooms(intervals);
        System.out.println(result);
    }

    private static int findMinMeetingRooms(List<Interval> intervals) {
        PriorityQueue<Interval> pq = new PriorityQueue<>((a, b) -> a.end - b.end);
        intervals.sort((a, b) -> a.start - b.start);

        int rooms = 0;
        for (Interval interval : intervals) {
            if (pq.isEmpty()) {
                pq.offer(interval);
            } else {
                while (!pq.isEmpty() && interval.start >= pq.peek().end) {
                    pq.poll();
                }
                pq.offer(interval);
            }

            rooms = Math.max(rooms, pq.size());
        }

        return rooms;
    }
}

class Interval {
    public int start, end;

    public Interval(int start, int end) {
        this.start = start;
        this.end = end;
    }
}