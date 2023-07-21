package com.graph.hard;

import java.util.*;

public class WordLadder_II {
    public static void main(String[] args) {
        String beginWord = "hit";
        String endWord = "cog";
        String[] wordList = {"hot", "dot", "dog", "lot", "log", "cog"};

        List<List<String>> result = solve(beginWord, endWord, wordList);
        System.out.println(result);
    }

    private static List<List<String>> solve(String beginWord, String endWord, String[] wordList) {
        Set<String> set = new HashSet<>();
        for (String str : wordList)
            set.add(str);

        Queue<List<String>> queue = new LinkedList<>();
        List<String> list = new ArrayList<>();
        list.add(beginWord);
        queue.add(list);

        List<String> usedOnLevel = new ArrayList<>();
        usedOnLevel.add(beginWord);

        int level = 0;

        List<List<String>> result = new ArrayList<>();

        while (!queue.isEmpty()) {
            List<String> poll = queue.poll();
            if (poll.size() > level) {
                level++;
                for (String it : usedOnLevel)
                    set.remove(it);
                usedOnLevel.clear();
            }

            String word = poll.get(poll.size() - 1);
            if (word.equals(endWord)) {
                if (result.size() == 0) result.add(poll);
                else if (result.get(0).size() == poll.size()) {
                    result.add(poll);
                }
            }

            for (int i = 0; i < word.length(); i++) {
                for (char ch = 'a'; ch <= 'z'; ch++) {
                    char[] replacedCharArray = word.toCharArray();
                    replacedCharArray[i] = ch;
                    String replacedWord = new String(replacedCharArray);
                    if (set.contains(replacedWord)) {
                        poll.add(replacedWord);

                        List<String> temp = new ArrayList<>(poll);
                        queue.add(temp);

                        usedOnLevel.add(replacedWord);
                        poll.remove(poll.size() - 1);
                    }
                }
            }
        }


        return result;
    }
}