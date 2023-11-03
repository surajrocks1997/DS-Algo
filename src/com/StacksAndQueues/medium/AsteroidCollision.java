package com.StacksAndQueues.medium;

import java.util.Iterator;
import java.util.Stack;

//https://leetcode.com/problems/asteroid-collision/
public class AsteroidCollision {
    public static void main(String[] args) {
        int[] asteroids = {10, 2, -5};
        int[] result = solve(asteroids);
        for (int ele : result)
            System.out.print(ele + " ");
    }

    private static int[] solve(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < asteroids.length; i++) {
            if (asteroids[i] > 0 || stack.isEmpty())
                stack.push(asteroids[i]);

            else {
                while (!stack.isEmpty() && stack.peek() > 0 && stack.peek() < Math.abs(asteroids[i]))
                    stack.pop();

                if (!stack.isEmpty() && stack.peek() == Math.abs(asteroids[i]))
                    stack.pop();
                else {
                    if (stack.isEmpty() || stack.peek() < 0)
                        stack.push(asteroids[i]);
                }
            }
        }

        int[] result = new int[stack.size()];
        int i = 0;
        for (int data : stack.stream().toList())
            result[i++] = data;

        return result;
    }
}
