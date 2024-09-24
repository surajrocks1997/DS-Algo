package com.recursion.medium;

import java.util.ArrayList;
import java.util.List;

// https://leetcode.com/problems/different-ways-to-add-parentheses/description/
public class DifferentWaysToAddParenthesis {

    public static void main(String[] args) {
        String expression = "2*3-4*5";
        List<Integer> result = solve(expression);
        System.out.println(result);
    }

    private static List<Integer> solve(String expression) {
        return recur(0, expression.length() - 1, expression);
    }

    private static List<Integer> recur(int left, int right, String expression) {
        List<Integer> result = new ArrayList<>();

        for (int i = left; i <= right; i++) {
            if (expression.charAt(i) == '*' ||
                    expression.charAt(i) == '+' ||
                    expression.charAt(i) == '-') {
                List<Integer> leftRes = recur(left, i - 1, expression);
                List<Integer> rightRes = recur(i + 1, right, expression);

                for (int ele1 : leftRes) {
                    for (int ele2 : rightRes) {
                        switch (expression.charAt(i)) {
                            case '*':
                                result.add(ele1 * ele2);
                                break;
                            case '-':
                                result.add(ele1 - ele2);
                                break;
                            case '+':
                                result.add(ele1 + ele2);
                                break;
                        }
                    }
                }

            }
        }
        // if within range left to right, there is no *,+,-; that means everything is a number
        if (result.isEmpty())
            result.add(Integer.parseInt(expression.substring(left, right + 1)));

        return result;

    }

}