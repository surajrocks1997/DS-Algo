package com.Strings.Hard;

import java.util.HashMap;
import java.util.Map;

//https://leetcode.com/problems/minimum-window-substring/description

public class MinWindowSubstring {
    public static void main(String[] args) {
        String s = "ADOBECODEBANC";
        String t = "ABC";

        String result = solve(s, t);
        System.out.println(result);
    }

    // NOTE: Both methods solve and solve1 are equally efficient. solve1 solves using one Map and solve uses two Maps to track character matches
    private static String solve(String s, String t) {
        int ns = s.length();
        int nt = t.length();
        if (nt > ns) return "";
        int left = 0;
        int right = 0;
        Map<Character, Integer> map = new HashMap<>();
        char[] tchar = t.toCharArray();
        char[] schar = s.toCharArray();
        for (char c : tchar)
            map.put(c, map.getOrDefault(c, 0) + 1);
        int minWindow = (int) 1e6;
        int minLeft = 0;
        int count = 0;
        while (left <= right && right < ns) {
            char c = schar[right];
            if (map.containsKey(c)) {
                map.put(c, map.get(c) - 1);
                if (map.get(c) >= 0)
                    count++;
            }
            while (count == nt) {
                if (minWindow > right - left + 1) {
                    minWindow = right - left + 1;
                    minLeft = left;
                }

                c = schar[left];
                if (map.containsKey(c)) {
                    map.put(c, map.getOrDefault(c, 0) + 1);
                    if (map.get(c) > 0)
                        count--;
                }
                left++;
            }
            right++;
        }


        return minWindow > ns ? "" : s.substring(minLeft, minLeft + minWindow);
    }

    private static String solve1(String s, String t) {
        int tLen = t.length();
        int sLen = s.length();
        if (sLen < tLen) return "";

        Map<Character, Integer> tMap = new HashMap<>();

        for (int i = 0; i < tLen; i++) {
            tMap.put(t.charAt(i), tMap.getOrDefault(t.charAt(i), 0) + 1);
        }
        int required = tMap.size();
        int have = 0;

        Map<Character, Integer> sMap = new HashMap<>();
        int i = 0;
        int j = 0;
        int minLength = Integer.MAX_VALUE;
        int leftPointer = -1;

        while (j < sLen) {
            if (tMap.containsKey(s.charAt(j))) {
                sMap.put(s.charAt(j), sMap.getOrDefault(s.charAt(j), 0) + 1);
                if (sMap.get(s.charAt(j)).equals(tMap.get(s.charAt(j))))
                    have++;
            }


            while (have == required) {
                if (j - i + 1 < minLength) {
                    minLength = j - i + 1;
                    leftPointer = i;
                }

                if (tMap.containsKey(s.charAt(i))) {
                    sMap.put(s.charAt(i), sMap.get(s.charAt(i)) - 1);
                    if (sMap.get(s.charAt(i)) < tMap.get(s.charAt(i)))
                        have--;
                }
                i++;
            }
            j++;
        }

        if (minLength > sLen) return "";
        return s.substring(leftPointer, leftPointer + minLength);
    }
}
