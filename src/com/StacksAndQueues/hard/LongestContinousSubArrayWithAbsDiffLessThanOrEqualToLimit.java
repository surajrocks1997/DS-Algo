package com.StacksAndQueues.hard;

import java.util.LinkedList;

public class LongestContinousSubArrayWithAbsDiffLessThanOrEqualToLimit {

    public static void main(String[] args) {
        int[] nums = {2, 2, 2, 4, 4, 2, 5, 5, 5, 5, 5, 2};
        int limit = 2;

        int result = solve(nums, limit);
        System.out.println(result);
    }

    private static int solve(int[] nums, int limit) {
        int n = nums.length;

        LinkedList<Integer> minQ = new LinkedList<>();
        LinkedList<Integer> maxQ = new LinkedList<>();

        int l = 0;
        int r = 0;
        int maxWindow = 0;

        while (l <= r && r < n) {
            while (!minQ.isEmpty() && minQ.getLast() > nums[r])
                minQ.pollLast();

            minQ.add(nums[r]);

            while (!maxQ.isEmpty() && maxQ.getLast() < nums[r])
                maxQ.pollLast();

            maxQ.add(nums[r]);

            while (!maxQ.isEmpty() && !minQ.isEmpty() &&
                    Math.abs(maxQ.getFirst() - minQ.getFirst()) > limit) {
                if (nums[l] == maxQ.getFirst()) maxQ.pollFirst();
                if (nums[l] == minQ.getFirst()) minQ.pollFirst();

                l++;
            }

            maxWindow = Math.max(maxWindow, r - l + 1);

            r++;
        }
        return maxWindow;
    }
}