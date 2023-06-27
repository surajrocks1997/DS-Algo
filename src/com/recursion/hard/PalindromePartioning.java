package com.recursion.hard;

import java.util.ArrayList;
import java.util.List;

public class PalindromePartioning {
    public static void main(String[] args) {
        String str = "aabb";
        List<List<String>> result = solve(str);
        System.out.println(result);
    }

    private static List<List<String>> solve(String str) {
        List<List<String>> result = new ArrayList<>();
        List<String> current = new ArrayList<>();
        solve(0, str, current, result);
        return result;
    }

    private static void solve(int index, String str, List<String> current, List<List<String>> result) {
        if (index == str.length()) {
            result.add(new ArrayList<>(current));
            return;
        }

        for (int i = index; i < str.length(); i++) {
            if (isPalindrome(index, i, str)) {
                current.add(str.substring(index, i + 1));
                solve(i + 1, str, current, result);
                current.remove(current.size() - 1);
            }
        }
    }

    private static boolean isPalindrome(int left, int right, String str) {
        while (left < right) {
            if (str.charAt(left++) != str.charAt(right--)) return false;
        }
        return true;
    }
}
