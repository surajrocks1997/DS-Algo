package com.Tries;

import java.util.Objects;

public class LongestWordWithAllPrefixes {
    public static void main(String[] args) {
        String[] str = {"ab", "abc", "a", "bp"};

        String result = solve(str);
        System.out.println(result);
    }

    private static String solve(String[] str) {
        Trie trie = new Trie();
        for (int i = 0; i < str.length; i++) {
            trie.insert(str[i]);
        }

        String longest = "";
        for (int i = 0; i < str.length; i++) {
            if (trie.prefixExist(str[i])) {
                if (str[i].length() > longest.length()) {
                    longest = str[i];
                } else if (str[i].length() == longest.length() && str[i].compareTo(longest) < 0) {
                    longest = str[i];
                }
            }
        }

        if (Objects.equals(longest, "")) return "None";
        return longest;
    }
}
