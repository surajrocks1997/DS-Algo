package com.StacksAndQueues.medium;

import java.util.Stack;

//https://leetcode.com/problems/asteroid-collision/
public class AsteroidCollision {
    public static void main(String[] args) {
        int[] asteroids = {1, -2, -2, -2};
        int[] result = solve(asteroids);
        for (int ele : result)
            System.out.print(ele + " ");
    }

    private static int[] solve(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < asteroids.length; i++) {
            if (stack.isEmpty() || (stack.peek() < 0 && asteroids[i] > 0) || isSameSign(stack.peek(), asteroids[i]))
                stack.push(asteroids[i]);

            else {
                while (!stack.isEmpty() && stack.peek() > 0 && stack.peek() < Math.abs(asteroids[i]))
                    stack.pop();

                if (stack.isEmpty() || stack.peek() < 0)
                    stack.push(asteroids[i]);
                else if (stack.peek() == Math.abs(asteroids[i]))
                    stack.pop();

            }
        }

        int[] result = new int[stack.size()];
        int i = 0;
        for (int data : stack.stream().toList())
            result[i++] = data;

        return result;
    }

    private static boolean isSameSign(int a, int b) {
        if (a < 0 && b < 0) return true;
        else return (a > 0 && b > 0);
    }
}
