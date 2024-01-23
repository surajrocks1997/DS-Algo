package com.recursion.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// https://leetcode.com/problems/maximum-length-of-a-concatenated-string-with-unique-characters/description/

public class MaxLenOfConcatStringWithUniqueChar {
    public static void main(String[] args) {
        List<String> arr = new ArrayList<>(Arrays.asList("un", "iq", "ue"));
        int result = solve(arr);
        System.out.println(result);
    }

    private static int solve(List<String> arr) {
        if (arr.size() == 1)
            if (isUnique(arr.get(0)))
                return arr.get(0).length();
            else
                return 0;

        int[] max = new int[1];
        solve("", 0, max, arr);
        return max[0];
    }

    private static void solve(String str, int index, int[] result, List<String> arr) {
        if (index == arr.size()) {
            result[0] = Math.max(result[0], str.length());
            return;
        }

        if (isUnique(str + arr.get(index)))
            solve(str + arr.get(index), index + 1, result, arr);
        solve(str, index + 1, result, arr);
    }

    private static boolean isUnique(String str) {
        int[] charArr = new int[26];
        for (int i = 0; i < str.length(); i++) {
            if (charArr[str.charAt(i) - 'a'] != 0)
                return false;
            charArr[str.charAt(i) - 'a']++;
        }

        return true;
    }
}
