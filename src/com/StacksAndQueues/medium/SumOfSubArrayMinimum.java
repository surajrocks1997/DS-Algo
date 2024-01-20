package com.StacksAndQueues.medium;

import java.util.Stack;

// https://leetcode.com/problems/sum-of-subarray-minimums/description/

public class SumOfSubArrayMinimum {
    public static void main(String[] args) {
//        int[] arr = {3,1,2,4};
        int[] arr = {1, 5, 4, 3, 2, 2, 3, 4, 5, 1};

        int result = solve(arr);
        System.out.println(result);
    }

//    CODE NOT CLEAR. CODE IS TAKEN FROM LEETCODE
    private static int solve(int[] arr) {
        long res = 0;
        Stack<Integer> stack = new Stack<>();
        long Modulo = (long) 1e9 + 7;
        stack.push(-1);

        for (int i2 = 0; i2 < arr.length + 1; i2++) {
            int currVal = i2 < arr.length ? arr[i2] : 0;

            while (stack.peek() != -1 && currVal < arr[stack.peek()]) {
                int index = stack.pop();
                int i1 = stack.peek();
                int left = index - i1;
                int right = i2 - index;

                long add = (long) (left * right * (long) arr[index]) % Modulo;
                res += add;
                res %= Modulo;
            }

            stack.push(i2);
        }
        return (int) res;
    }
}
