package com.graph.hard;

import java.util.*;

public class WordLadder_I {
    public static void main(String[] args) {
        String beginWord = "hit";
        String endWord = "cog";
        String[] wordList = {"hot", "dot", "dog", "lot", "log", "cog"};

        int result = solve(beginWord, endWord, wordList);
        System.out.println(result);
    }

    private static int solve(String beginWord, String endWord, String[] wordList) {
        Queue<Pair_WordLadder_I> queue = new LinkedList<>();
        queue.add(new Pair_WordLadder_I(beginWord, 1));
        Set<String> set = new HashSet<>();

        for (String str : wordList) set.add(str);

        set.remove(beginWord);

        while (!queue.isEmpty()) {
            Pair_WordLadder_I poll = queue.poll();
            String word = poll.first;
            int steps = poll.second;

            if (word.equals(endWord)) return steps;

            for (int i = 0; i < word.length(); i++) {
                for (char ch = 'a'; ch <= 'z'; ch++) {
                    char[] replacedCharArray = word.toCharArray();
                    replacedCharArray[i] = ch;
                    String replaceWord = new String(replacedCharArray);
                    if (set.contains(replaceWord)) {
                        set.remove(replaceWord);
                        queue.add(new Pair_WordLadder_I(replaceWord, steps + 1));
                    }
                }
            }
        }

        return 0;
    }
}

class Pair_WordLadder_I {
    String first;
    int second;

    public Pair_WordLadder_I(String first, int second) {
        this.first = first;
        this.second = second;
    }
}