package com.recursion.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LetterCombinationOfPhoneNumber {
    public static void main(String[] args) {
        String digits = "23";

        List<String> result = solve(digits);
        System.out.println(result);
    }

    private static List<String> solve(String digits) {
        List<String> result = new ArrayList<>();
        if (digits.length() == 0) return result;

        Map<Character, String> map = new HashMap<>();
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");

        StringBuilder sb = new StringBuilder();
        solve(digits, 0, map, sb, result);
        return result;
    }

    private static void solve(String digits, int index, Map<Character, String> map, StringBuilder sb, List<String> result) {
        if (index == digits.length()) {
            result.add(sb.toString());
            return;
        }

        char digit = digits.charAt(index);
        String mapped = map.get(digit);
        for (char letter : mapped.toCharArray()) {
            sb = sb.append(letter);
            solve(digits, index + 1, map, sb, result);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
