package com.Strings.Hard;

import java.util.HashMap;
import java.util.Map;

public class MinWindowSubstring {
    public static void main(String[] args) {
        String s = "ADOBECODEBANC";
        String t = "ABC";

        String result = solve(s, t);
        System.out.println(result);
    }

    private static String solve(String s, String t) {
        if (s.length() == 0 || s.length() < t.length()) return "";

        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            map.put(t.charAt(i), map.getOrDefault(t.charAt(i), 0) + 1);
        }

        int count = 0;
        int start = 0;
        int minLength = Integer.MAX_VALUE;
        int minLeft = 0;

        for (int i = 0; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i))) {
                map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) - 1);

                if (map.get(s.charAt(i)) >= 0) {
                    count++;
                }
            }


            while (count == t.length()) {
                if (minLength > i - start + 1) {
                    minLength = i - start + 1;
                    minLeft = start;
                }

                if (map.containsKey(s.charAt(start))) {
                    map.put(s.charAt(start), map.get(s.charAt(start)) + 1);
                    if (map.get(s.charAt(start)) > 0) count--;
                }
                start++;
            }
        }

        if (minLength > s.length()) return "";
        return s.substring(minLeft, minLeft + minLength);
    }
}
