package com.StacksAndQueues.medium;

import java.util.Stack;
import java.util.stream.Collectors;

//https://leetcode.com/problems/reverse-substrings-between-each-pair-of-parentheses/description/
public class ReverseSubstringBetweenParenthesis {

    public static void main(String[] args) {
        String s = "a(ed(et(oc))el)q";
        String result = solve(s);
        System.out.println(result);
    }

    private static String solve(String s) {
        Stack<Character> stack = new Stack<>();
        char[] chArr = s.toCharArray();
        int n = s.length();

        for (int i = 0; i < n; i++) {
            if (chArr[i] != ')') {
                stack.push(chArr[i]);
            } else {
                StringBuilder sb = new StringBuilder();
                while (stack.peek() != '(') {
                    sb.append(stack.pop());
                }
                stack.pop();
                for (int index = 0; index < sb.length(); index++) {
                    stack.push(sb.charAt(index));
                }
            }
        }
        return stack.stream().map(Object::toString).collect(Collectors.joining(""));
    }
}
