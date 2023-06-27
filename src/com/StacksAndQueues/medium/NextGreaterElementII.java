package com.StacksAndQueues.medium;

import java.util.Arrays;
import java.util.Stack;

public class NextGreaterElementII {
    public static void main(String[] args) {
        int[] nums = {3, 10, 4, 2, 1, 2, 6, 1, 7, 2, 9};
        int[] result = solve(nums);
        Arrays.stream(result).forEach(ele -> System.out.print(ele + " "));
    }

    private static int[] solve(int[] nums) {
        int n = nums.length;
        int[] nge = new int[n];
        Stack<Integer> stack = new Stack<>();
        for (int i = 2 * n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && nums[i % n] >= stack.peek())
                stack.pop();

            if (i < n) {
                if (stack.isEmpty()) nge[i % n] = -1;
                else
                    nge[i % n] = stack.peek();
            }

            stack.push(nums[i % n]);

        }

        return nge;
    }
}
