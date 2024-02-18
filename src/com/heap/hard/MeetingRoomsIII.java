package com.heap.hard;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

// https://leetcode.com/problems/meeting-rooms-iii/description
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
        //sorting meeting[][] based on start time, if start time is same then smaller endTime should come first
        Arrays.sort(meetings, (a, b) -> a[0] != b[0] ? a[0] - b[0] : a[1] - b[1]);

        PriorityQueue<RoomDetail> availQ = new PriorityQueue<>((a, b) -> Integer.compare(a.roomNo, b.roomNo));

        // smaller end time will come first, if end time is same then smaller roomNo will come first
        PriorityQueue<BusyQ> busyQ = new PriorityQueue<>((a, b) ->
                a.endTime != b.endTime ? Long.compare(a.endTime, b.endTime) : a.roomDetail.roomNo - b.roomDetail.roomNo);

        for (int i = 0; i < n; i++) availQ.add(new RoomDetail(i, 0));

        for (int[] meetingTime : meetings) {
            long currentStart = meetingTime[0];
            long currentEnd = (long) meetingTime[1];

            // checking if current meeting's start time is <= smallest end time of busyQ
            // if true then emptying the busyROom and adding to freeRoom
            while (!busyQ.isEmpty() && busyQ.peek().endTime <= currentStart) {
                BusyQ pollBusy = busyQ.poll();
                availQ.add(pollBusy.roomDetail);
            }

            // if no rooms available, then find the earliest endTime of meeting is busyQ
            // update the start time of delayed meeting to earliest endTime of meeting is busyQ
            // poll fromBusyQ and add new meeting to busyQ

            //else, since we have rooms available, directly add a meeting to busyQ and poll from availQ
            if (availQ.isEmpty()) {
                Long duration = currentEnd - currentStart;
                Long newStart = busyQ.peek().endTime;

                BusyQ pollBusy = busyQ.poll();
                busyQ.add(new BusyQ(new RoomDetail(pollBusy.roomDetail.roomNo, pollBusy.roomDetail.count + 1), newStart + duration));

            } else {
                RoomDetail pollAvail = availQ.poll();
                busyQ.add(new BusyQ(new RoomDetail(pollAvail.roomNo, pollAvail.count + 1), currentEnd));
            }
        }

        while (!busyQ.isEmpty()) {
            BusyQ pollBusy = busyQ.poll();
            availQ.add(pollBusy.roomDetail);
        }

        // sorting based on highest count, if count is same, then room with smaller number comes first
        return availQ.stream().sorted((a, b) -> a.count != b.count ? b.count - a.count : a.roomNo - b.roomNo).toList().get(0).roomNo;

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