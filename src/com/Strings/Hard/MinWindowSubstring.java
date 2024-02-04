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

// another valid solution

//class Solution {
//    public String minWindow(String s, String t) {
//        int tLen = t.length();
//        int sLen = s.length();
//        if(sLen < tLen) return "";
//
//        Map<Character, Integer> tMap = new HashMap<>();
//
//        for (int i = 0; i < tLen; i++) {
//            tMap.put(t.charAt(i), tMap.getOrDefault(t.charAt(i), 0) + 1);
//        }
//        int required = tMap.size();
//        int have = 0;
//
//        Map<Character, Integer> sMap = new HashMap<>();
//        int i = 0;
//        int j = 0;
//        int minLength = Integer.MAX_VALUE;
//        String resultString = "";
//        boolean updated = false;
//
//        while (j < sLen) {
//            if (tMap.containsKey(s.charAt(j))) {
//                sMap.put(s.charAt(j), sMap.getOrDefault(s.charAt(j), 0) + 1);
//                if (sMap.get(s.charAt(j)) == (tMap.get(s.charAt(j))))
//                    have++;
//            }
//
//
//            while (have == required) {
//                if(j-i + 1 < minLength){
//                    minLength = j-i + 1;
//                    resultString = s.substring(i, j + 1);
//                    updated = true;
//                }
//
//                if (tMap.containsKey(s.charAt(i))) {
//                    sMap.put(s.charAt(i), sMap.get(s.charAt(i)) - 1);
//                    if (sMap.get(s.charAt(i)) < tMap.get(s.charAt(i)))
//                        have--;
//                }
//                i++;
//            }
//            j++;
//        }
//
//        if(updated) return resultString;
//        else return "";
//    }
//}
