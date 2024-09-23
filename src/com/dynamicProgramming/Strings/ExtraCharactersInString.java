package com.dynamicProgramming.Strings;

import java.util.Arrays;
import java.util.HashSet;

//https://leetcode.com/problems/extra-characters-in-a-string/description/
public class ExtraCharactersInString {

    public static void main(String[] args) {
        String s = "ecolloycollotkvzqpdaumuqgs";
        String[] dictionary = {"flbri", "uaaz", "numy", "laper", "ioqyt", "tkvz", "ndjb", "gmg", "gdpbo", "x", "collo", "vuh", "qhozp", "iwk", "paqgn", "m", "mhx", "jgren", "qqshd", "qr", "qpdau", "oeeuq", "c", "qkot", "uxqvx", "lhgid", "vchsk", "drqx", "keaua", "yaru", "mla", "shz", "lby", "vdxlv", "xyai", "lxtgl", "inz", "brhi", "iukt", "f", "lbjou", "vb", "sz", "ilkra", "izwk", "muqgs", "gom", "je"};
        int result = solve(s, dictionary);
        System.out.println(result);
    }

    private static int solve(String s, String[] dictionary) {
        HashSet<String> set = new HashSet<>(Arrays.asList(dictionary));
        int n = s.length();
        int[] cache = new int[n];
        Arrays.fill(cache, -1);
        if (n == 1)
            return set.contains(s) ? 0 : 1;

        return dfs(0, s, dictionary, set, cache);
    }

    private static int dfs(int i, String s, String[] dictionary, HashSet<String> set, int[] cache) {
        if (i == s.length()) return 0;

        if (cache[i] != -1) return cache[i];

        // skip current char scenario
        int result = 1 + dfs(i + 1, s, dictionary, set, cache);

        //considering different length substring scenario
        for (int idx = i; idx < s.length(); idx++) {
            if (set.contains(s.substring(i, idx + 1)))
                result = Math.min(result, dfs(idx + 1, s, dictionary, set, cache));
        }

        return cache[i] = result;
    }
}