package com.StacksAndQueues.easy;

import java.util.Stack;

public class ValidParenthesis {
    public static void main(String[] args) {
        String str = "(])";
        boolean result = solve(str);
        System.out.println(result);
    }

    private static boolean solve(String str) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '(' || str.charAt(i) == '[' || str.charAt(i) == '{') {
                stack.push(str.charAt(i));
            } else {
                if (stack.isEmpty()) return false;
                else if (str.charAt(i) == ']' && stack.peek() == '[')
                    stack.pop();
                else if (str.charAt(i) == ')' && stack.peek() == '(')
                    stack.pop();
                else if (str.charAt(i) == '}' && stack.peek() == '{')
                    stack.pop();
                else return false;
            }
        }

        return stack.isEmpty();
    }
}
