package com.Strings.Medium;

import java.util.HashMap;
import java.util.Map;

// https://leetcode.com/problems/sum-of-beauty-of-all-substrings/description/
public class SumOfBeautyOfAllSubstring {
    public static void main(String[] args) {
        String s = "aabcb";
        int result = solve(s);
        System.out.println(result);
    }

    private static int solve(String s) {
        int sum = 0;
        for (int i = 0; i < s.length(); i++) {
            Map<Character, Integer> map = new HashMap<>();
            for (int j = i; j < s.length(); j++) {
                map.put(s.charAt(j), map.getOrDefault(s.charAt(j), 0) + 1);
                sum += findBeauty(map);
            }
        }

        return sum;
    }

    private static int findBeauty(Map<Character, Integer> map) {
        int maxFreq = Integer.MIN_VALUE;
        int minFreq = Integer.MAX_VALUE;

        for (char ch : map.keySet()) {
            minFreq = Math.min(minFreq, map.get(ch));
            maxFreq = Math.max(maxFreq, map.get(ch));
        }

        return maxFreq - minFreq;
    }
}
