package com.Tries;

public class Trie_Main {
    public static void main(String[] args) {
        Trie trie = new Trie();
        int[] type = {1, 1, 2, 3, 2};
        String[] value = {"hello", "help", "help", "hel", "hel"};
        int n = value.length;

        for (int i = 0; i < n; i++) {
            if (type[i] == 1) {
                trie.insert(value[i]);
            } else if (type[i] == 2) {
                System.out.println(trie.search(value[i]));
            } else {
                System.out.println(trie.startsWith(value[i]));
            }
        }
    }
}
