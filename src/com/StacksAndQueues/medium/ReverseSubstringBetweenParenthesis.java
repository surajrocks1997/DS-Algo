package com.StacksAndQueues.medium;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;
import java.util.stream.Collectors;

//https://leetcode.com/problems/reverse-substrings-between-each-pair-of-parentheses/description/
public class ReverseSubstringBetweenParenthesis {

    public static void main(String[] args) {
        String s = "a(ed(et(oc))el)q";
        String result = solve1(s);
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
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        return sb.reverse().toString();
    }

    private static String solve1(String s) {
        Stack<Integer> stack = new Stack<>();
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(')
                stack.push(i);
            else if (s.charAt(i) == ')') {
                int j = stack.pop();
                map.put(j, i);
                map.put(i, j);
            }
        }

        int i = 0;
        int direction = 1;
        StringBuilder sb = new StringBuilder();
        while (i < s.length()) {
            char c = s.charAt(i);
            if (c == '(' || c == ')') {
                i = map.get(i);
                direction = -1 * direction;
            } else
                sb.append(c);

            i += direction;
        }

        return sb.toString();
    }
}
