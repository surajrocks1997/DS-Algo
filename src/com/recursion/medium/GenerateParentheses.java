package com.recursion.medium;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class GenerateParentheses {
    public static void main(String[] args) {
        int n = 8;
        List<String> result = generateParentheses(n);
        System.out.println(result.size());
    }

    private static List<String> generateParentheses(int n) {
        List<String> result = new ArrayList<>();
        generate("(", 1, 0, result, n);
        return result;
    }

    private static void generate(String current, int open, int close, List<String> result, int n) {
        if (current.length() == 2 * n) {
            result.add(current);
            return;
        }

        if (open < n) {
            generate(current + "(", open + 1, close, result, n);
        }
        if (close < open) {
            generate(current + ")", open, close + 1, result, n);
        }
    }
}
