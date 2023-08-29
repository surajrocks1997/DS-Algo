package com.SlidingWindow_2Pointer;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithoutRepeatingChar {
    public static void main(String[] args) {
        String s = "tmmzuxt";
        int result = solve(s);
        System.out.println(result);
    }

    private static int solve(String s) {
        int windowStart = 0;
        int windowSize = 0;
        Map<Character, Integer> map = new HashMap<>();

        for (int windowEnd = 0; windowEnd < s.length(); windowEnd++) {
            if (map.containsKey(s.charAt(windowEnd))) {
                while (s.charAt(windowStart) != s.charAt(windowEnd)) {
                    map.remove(s.charAt(windowStart++));
                }
                map.remove(s.charAt(windowStart++));
            }

            map.put(s.charAt(windowEnd), 1);


            windowSize = Math.max(windowSize, windowEnd - windowStart + 1);
        }
        return windowSize;
    }
}
