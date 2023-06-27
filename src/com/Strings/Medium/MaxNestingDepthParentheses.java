package com.Strings.Medium;

import java.util.Stack;

public class MaxNestingDepthParentheses {
    public static void main(String[] args) {
        String str = "";
        int result = solve(str);
        System.out.println(result);
    }

    private static int solve(String s) {
        int count = 0;   //count current dept of "()"
        int max = 0;     //count max dept of "()"

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                count++;
            } else if (s.charAt(i) == ')') {
                count--;
            }
            max = Math.max(count, max);
        }
        return max;
    }
}
