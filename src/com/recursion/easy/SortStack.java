package com.recursion.easy;

import java.util.Stack;

public class SortStack {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(3);
        stack.push(2);
        stack.push(1);

        Stack<Integer> result = solve(stack);
        System.out.println(result);

    }

    private static Stack<Integer> solve(Stack<Integer> stack) {
        return new Stack<>();
    }
}
