package com.StacksAndQueues.hard;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

public class SlidingWindowMaximum {
    public static void main(String[] args) {
        int[] nums = {1, 3, -1, -3, 5, 3, 6, 7};
        int k = 3;
        int[] result = solve(nums, k);
        Arrays.stream(result).forEach(ele -> System.out.print(ele + " "));
    }

    private static int[] solve(int[] nums, int k) {
        int[] result = new int[nums.length - k + 1];
        int resultIndex = 0;
        Deque<Integer> deque = new LinkedList<>();
        for (int i = 0; i < nums.length; i++) {
            if (!deque.isEmpty() && deque.peek() <= i - k)
                deque.poll();

            while (!deque.isEmpty() && nums[deque.peekLast()] < nums[i])
                deque.pollLast();

            deque.offer(i);

            if (i >= k - 1)
                result[resultIndex++] = nums[deque.getFirst()];
        }
        return result;
    }
}
