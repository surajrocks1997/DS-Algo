package com.Strings.Medium;

// https://leetcode.com/problems/determine-if-two-strings-are-close/description

import java.util.Arrays;

public class DetermineIfStringsAreClose {
    public static void main(String[] args) {
        String word1 = "cabbba";
        String word2 = "abbccc";

        boolean result = solve(word1, word2);
        System.out.println(result);
    }

    private static boolean solve(String word1, String word2) {
        int len1 = word1.length();
        int len2 = word2.length();
        if (len1 != len2) return false;

        int[] freq1 = new int[26];
        int[] freq2 = new int[26];

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < len1; i++) {
            char c1 = word1.charAt(i);
            if (freq1[c1 - 'a'] == 0)
                sb.append(c1);
            freq1[c1 - 'a']++;

            char c2 = word2.charAt(i);
            freq2[c2 - 'a']++;
        }

        String uniqueInWord1 = sb.toString();
        for (int i = 0; i < uniqueInWord1.length(); i++) {
            if (freq2[uniqueInWord1.charAt(i) - 'a'] == 0) return false;
        }

        Arrays.sort(freq1);
        Arrays.sort(freq2);

        return Arrays.equals(freq1, freq2);
    }
}
