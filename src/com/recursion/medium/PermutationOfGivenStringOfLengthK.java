package com.recursion.medium;

import java.util.ArrayList;
import java.util.List;

public class PermutationOfGivenStringOfLengthK {
    public static void main(String[] args) {
        String str = "ab";
        int k = 3;

        List<String> result = solve(str, k);
        System.out.println(result);
    }

    private static List<String> solve(String str, int k) {
        List<String> result = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        solve(sb, result, str, k);
        return result;
    }

    private static void solve(StringBuilder sb, List<String> result, String str, int k) {
        if (sb.length() == k) {
            result.add(sb.toString());
            return;
        }

        for (int i = 0; i < str.length(); i++) {
            sb.append(str.charAt(i));
            solve(sb, result, str, k);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
