package com.SlidingWindow_2Pointer;

public class PermutationInString_Optimal {
    public static void main(String[] args) {
        String s1 = "hello";
        String s2 = "ooolleoooleh";

        boolean result = checkInclusion(s1, s2);
        System.out.println(result);
    }

    private static boolean checkInclusion(String s1, String s2) {
        int n1 = s1.length();
        int n2 = s2.length();
        if (n1 > n2) return false;
        char[] s1arr = s1.toCharArray();
        char[] s2arr = s2.toCharArray();
        int l = 0;
        int r = 0;

        int[] s1Map = new int[26];
        int[] s2Map = new int[26];

        for (char c : s1arr) {
            s1Map[c - 'a']++;
        }

        while (r < n1) {
            s2Map[s2arr[r] - 'a']++;
            r++;
        }

        int mismatch = 0;
        for (int i = 0; i < 26; i++) {
            if (s1Map[i] != s2Map[i]) mismatch++;
        }

        if (mismatch == 0) return true;

        while (r < n2) {
            // increasing the right pointer
            int x = s2arr[r] - 'a';
            if (s1Map[x] == s2Map[x]) {
                mismatch++;
            }
            s2Map[x]++;
            if (s1Map[x] == s2Map[x]) {
                mismatch--;
            }
            r++;

            // decreasing the left pointer

            x = s2arr[l] - 'a';
            if (s1Map[x] == s2Map[x]) {
                mismatch++;
            }
            s2Map[x]--;
            if (s1Map[x] == s2Map[x]) {
                mismatch--;
            }
            l++;

            if (mismatch == 0) return true;
        }

        return false;
    }
}
