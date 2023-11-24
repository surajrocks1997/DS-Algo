package com.StacksAndQueues.easy;

import java.util.Stack;
public class ReverseStackUsingRecursion {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);

        solve(stack);
        while (!stack.isEmpty())
            System.out.print(stack.pop() + " ");
    }

    private static void solve(Stack<Integer> stack) {
        if (stack.isEmpty()) return;
        int ele = stack.pop();
        solve(stack);
        insertAtBottom(stack, ele);
    }

    private static void insertAtBottom(Stack<Integer> stack, int ele) {
        if (stack.isEmpty()) {
            stack.push(ele);
            return;
        }

        int x = stack.pop();
        insertAtBottom(stack, ele);
        stack.push(x);
    }
}
