package com.SlidingWindow_2Pointer;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithoutRepeatingChar {
    public static void main(String[] args) {
        String s = "abba";
        int result = solve(s);
        System.out.println(result);
    }

    private static int solve(String s) {
        int left = 0, right = 0;
        int window = 0;
        Map<Character, Integer> map = new HashMap<>();
        while (right < s.length()) {
            if (map.containsKey(s.charAt(right)))
                left = Math.max(map.get(s.charAt(right)) + 1, left);

            map.put(s.charAt(right), right);
            window = Math.max(right-left+1, window);
            right++;
        }

        return window;
    }
}
