package com.SlidingWindow_2Pointer;

import java.util.HashMap;
import java.util.Map;

public class LongestRepeatingCharacterReplacement {
    public static void main(String[] args) {
        String s = "AABABBA";
        int k = 1;

        int result = solve(s, k);
        System.out.println(result);
    }

    private static int solve(String s, int k) {
        int n = s.length();

        int window_start = 0;
        int maxRollingFrequency = 0;
        int maxLength = 0;

        int[] charCount = new int[26];

        for (int window_end = 0; window_end < n; window_end++) {
            int currentCharCount = ++charCount[s.charAt(window_end) - 'A'];
            maxRollingFrequency = Math.max(maxRollingFrequency, currentCharCount);

            while (window_end - window_start + 1 - maxRollingFrequency > k) {
                charCount[s.charAt(window_start) - 'A']--;
                window_start++;
            }

            maxLength = Math.max(maxLength, window_end - window_start + 1);
        }
        return maxLength;
    }

    private static int solve2(String s, int k) {
        int n = s.length();
        Map<Character, Integer> map = new HashMap<>();

        int l = 0;
        int r = 0;
        int max = 0;
        int maxRepeatCount = 0;

        while (l <= r && r < n) {
            char ch = s.charAt(r);
            map.put(ch, map.getOrDefault(ch, 0) + 1);
            maxRepeatCount = Math.max(maxRepeatCount, map.get(ch));
            if (r - l + 1 - maxRepeatCount <= k) {
                max = Math.max(max, r - l + 1);
            } else {
                map.put(s.charAt(l), map.getOrDefault(s.charAt(l), 1) - 1);
                l++;
            }
            r++;
        }

        return max;
    }
}
