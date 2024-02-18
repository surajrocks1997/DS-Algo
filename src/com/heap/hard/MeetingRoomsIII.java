package com.heap.hard;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

// https://leetcode.com/problems/meeting-rooms-iii/description

// ans is correct but not passing 2 test cases because of long input in meeting end times. could not resolve those 2 test cases
public class MeetingRoomsIII {

    public static void main(String[] args) {
        int[][] meetings = {
                {1, 20},
                {2, 10},
                {3, 5},
                {4, 9},
                {6, 8}
        };
        int n = 3;

        int result = solve(meetings, n);
        System.out.println(result);

    }

    private static int solve(int[][] meetings, int n) {
        Arrays.sort(meetings, (a, b) -> a[0] - b[0]);
        PriorityQueue<RoomDetail> availQ = new PriorityQueue<>((a, b) -> Integer.compare(a.roomNo, b.roomNo));
        PriorityQueue<BusyQ> busyQ = new PriorityQueue<>((a, b) -> Long.compare(a.endTime, b.endTime));

        for (int i = 0; i < n; i++) availQ.add(new RoomDetail(i, 0));

        for (int[] meetingTime : meetings) {
            int currentStart = meetingTime[0];
            Long currentEnd = (long) meetingTime[1];

            while (!busyQ.isEmpty() && busyQ.peek().endTime <= currentStart) {
                BusyQ pollBusy = busyQ.poll();
                availQ.add(pollBusy.roomDetail);
            }

            if (availQ.isEmpty()) {
                Long duration = currentEnd - currentStart;
                Long newStart = busyQ.peek().endTime;

                // when rooms are not available, next meeting will be scheduled when busy rooms get free.
                // multiple rooms can get free at the same time
                while (!busyQ.isEmpty() && busyQ.peek().endTime == newStart) {
                    BusyQ pollBusy = busyQ.poll();
                    availQ.add(pollBusy.roomDetail);
                }

                // now that rooms are free, we put the current meeting to room with smaller Room No.
                RoomDetail pollAvail = availQ.poll();
                busyQ.add(new BusyQ(new RoomDetail(pollAvail.roomNo, pollAvail.count + 1), newStart + duration));

            } else {
                RoomDetail pollAvail = availQ.poll();
                busyQ.add(new BusyQ(new RoomDetail(pollAvail.roomNo, pollAvail.count + 1), currentEnd));
            }
        }

        while (!busyQ.isEmpty()) {
            BusyQ pollBusy = busyQ.poll();
            availQ.add(pollBusy.roomDetail);
        }


        List<RoomDetail> sorted = availQ.stream().sorted(new Comparator<RoomDetail>() {
            @Override
            public int compare(RoomDetail a1, RoomDetail a2) {
                if (a1.count != a2.count) return Integer.compare(a2.count, a1.count);
                else return Integer.compare(a1.roomNo, a2.roomNo);
            }
        }).toList();


        return sorted.get(0).roomNo;
    }
}

class BusyQ {
    RoomDetail roomDetail;
    long endTime;

    public BusyQ(RoomDetail roomDetail, long endTime) {
        this.roomDetail = roomDetail;
        this.endTime = endTime;
    }
}

class RoomDetail {
    int roomNo;
    int count;

    public RoomDetail(int roomNo, int count) {
        this.roomNo = roomNo;
        this.count = count;
    }
}