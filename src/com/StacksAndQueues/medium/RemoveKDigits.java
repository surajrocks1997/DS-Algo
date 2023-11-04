package com.StacksAndQueues.medium;

import java.util.Stack;

// https://leetcode.com/problems/remove-k-digits/description/
public class RemoveKDigits {
    public static void main(String[] args) {
        String num = "10";
        int k = 2;

        String result = solve(num, k);
        System.out.println(result);
    }

    private static String solve(String num, int k) {
        if (num.length() == k) return "0";

        Stack<Character> stack = new Stack<>();
        int i = 0;
        while (i < num.length()) {
            while (k > 0 && !stack.isEmpty() && stack.peek() > num.charAt(i)) {
                stack.pop();
                k--;
            }

            stack.push(num.charAt(i));
            i++;
        }

        while (k > 0) {
            stack.pop();
            k--;
        }

        StringBuilder sb = new StringBuilder();
        for (char ele : stack.stream().toList()) {
            sb.append(ele);
        }

        while (sb.length() > 1 && sb.charAt(0) == '0')
            sb.deleteCharAt(0);

        return sb.toString();
    }
}
