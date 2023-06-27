package com.StacksAndQueues.hard;

import java.util.Stack;

public class LargestRectangleInHistogram {
    public static void main(String[] args) {
        int[] height = {2, 1, 5, 6, 2, 3};
        int result = solve(height);
        System.out.println(result);
    }

    private static int solve(int[] heights) {
        int leftSmallest = 0;
        int rightSmallest = heights.length - 1;
        int[] leftSmall = new int[heights.length];
        int[] rightSmall = new int[heights.length];

        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < heights.length; i++) {
            while (!stack.isEmpty() && heights[i] <= heights[stack.peek()])
                stack.pop();

            if (stack.isEmpty())
                leftSmall[i] = leftSmallest;
            else
                leftSmall[i] = stack.peek() + 1;

            stack.push(i);
        }

        stack = new Stack<>();

        for (int i = heights.length - 1; i >= 0; i--) {
            while (!stack.isEmpty() && heights[i] <= heights[stack.peek()])
                stack.pop();

            if (stack.isEmpty())
                rightSmall[i] = rightSmallest;
            else
                rightSmall[i] = stack.peek() - 1;

            stack.push(i);
        }

        int max = Integer.MIN_VALUE;
        for (int i = 0; i < heights.length; i++) {
            int calc = (Math.abs(leftSmall[i] - rightSmall[i]) + 1) * heights[i];
            if (calc > max) max = calc;
        }

        return max;
    }
}
