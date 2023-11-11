package com.SlidingWindow_2Pointer;

import java.util.HashMap;
import java.util.Map;

// https://leetcode.com/problems/number-of-substrings-containing-all-three-characters/description/
public class NumberOfSubstringContainingAllThreeCharacters {
    public static void main(String[] args) {
        String str = "acbbcac";

        int result = solve(str);
        System.out.println(result);
    }

    private static int solve(String s) {
        int start = 0;
        int end = 0;
        int count = 0;

        Map<Character, Integer> map = new HashMap<>();

        while (start <= s.length() - 3 && end < s.length()) {
            map.put(s.charAt(end), map.getOrDefault(s.charAt(end), 0) + 1);
            while (map.size() == 3) {
                count += 1 + s.length() - 1 - end;
                map.put(s.charAt(start), map.get(s.charAt(start)) - 1);
                if (map.get(s.charAt(start)) == 0) map.remove(s.charAt(start));
                start++;
            }
            end++;
        }
        return count;
    }

    private static int solve1(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int count = 0, start = 0, end = 0;
        int n = s.length();
        while (end < n) {
            char ch = s.charAt(end);
            map.put(ch, map.getOrDefault(ch, 0) + 1);
            while (map.getOrDefault('a', 0) > 0
                    && map.getOrDefault('b', 0) > 0
                    && map.getOrDefault('c', 0) > 0) {
                count += 1 + ((n - 1) - end);
                map.put(s.charAt(start), map.get(s.charAt(start)) - 1);
                start++;
            }
            end++;
        }
        return count;
    }
}
