package com.dynamicProgramming.Strings.LongestStringChain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LongestStringChain_DFS {
    public static void main(String[] args) {
        String[] words = {"lz", "aiodvi", "stp", "z", "qolsz", "edxfum", "stvf", "shgtp", "gilfefs", "sgilfgefs", "tp", "atnpuu", "atnpuuib", "nshgtph", "v", "qlsz", "eqolnsz", "ghphjykf", "vf", "adv", "qlz", "zstvf", "ghphjyf", "abiodvi", "aodvi", "ilffs", "fi", "fedxfum", "ilfs", "st", "nsihgtph", "shtp", "syt", "tvf", "sgilfefs", "av", "nshgtp", "nsihgtpmh", "v", "ifs", "sgilfgelfs", "aodv", "if", "gphjyf", "ilfefs", "atnpuui", "qolnsz"};

        int result = solve(words);
        System.out.println(result);
    }

    private static int solve(String[] words) {
        int n = words.length;
        if (n == 1) return 1;

        Map<Integer, List<String>> map = new HashMap<>();
        Map<String, Integer> memoization = new HashMap<>();

        for (int i = 0; i < n; i++) {
            int wordLength = words[i].length();
            map.putIfAbsent(wordLength, new ArrayList<>());
            List<String> list = map.get(wordLength);
            list.add(words[i]);
        }

        int maxLength = 1;
        for (String word : words) {
            maxLength = Math.max(maxLength, dfs(word, map, memoization));
        }

        return maxLength;
    }

    private static int dfs(String word, Map<Integer, List<String>> map, Map<String, Integer> memoization) {
        if (!map.containsKey(word.length() + 1)) return 1;
        if (memoization.containsKey(word)) return memoization.get(word);

        int count = 0;

        List<String> list = map.get(word.length() + 1);
        for (String nextWord : list) {
//            if (isOk(word, nextWord, word.length() - 1, nextWord.length() - 1, true)) {
//                count = Math.max(count, dfs(nextWord, map, memoization));
//            }
            if (isOneOff(word, nextWord))
                count = Math.max(count, dfs(nextWord, map, memoization));
        }
        memoization.put(word, 1 + count);
        return memoization.get(word);
    }

    private static boolean isOk(String word, String nextWord, int m, int n, boolean canSkipCharacter) {
        if (m <= 0 && m - n <= 0)
            return true;

        if (word.charAt(m) == nextWord.charAt(n)) {
            return isOk(word, nextWord, m - 1, n - 1, true);
        } else if (!canSkipCharacter) return false;
        else return isOk(word, nextWord, m, n - 1, false);
    }

    private static boolean isOneOff(String a, String b) {
        int count = 0;
        for (int i = 0, j = 0; i < b.length() && j < a.length() && count <= 1; i++) {
            if (a.charAt(j) != b.charAt(i)) count++;
            else j++;
        }
        return count <= 1;
    }
}
