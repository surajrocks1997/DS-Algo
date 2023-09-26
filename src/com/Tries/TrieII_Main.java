package com.Tries;

public class TrieII_Main {
    public static void main(String[] args) {
        Trie_II trie = new Trie_II();
        trie.insert("apple");
        trie.insert("apple");
        trie.insert("apps");
        trie.insert("apps");

        String word1 = "apps";
        System.out.println("Count Words Equal to " + word1 + " " + trie.countWordsEqualTo(word1));
        String word2 = "abc";
        System.out.println("Count Words Equal to " + word2 + " " + trie.countWordsEqualTo(word2));
        String word3 = "ap";
        System.out.println("Count Words Starting With " + word3 + " " + trie.countWordsStartingWith
                (word3));
        String word4 = "appl";
        System.out.println("Count Words Starting With " + word4 + " " + trie.countWordsStartingWith
                (word4));
        trie.erase(word1);
        System.out.println("Count Words equal to " + word1 + " " + trie.countWordsEqualTo(word1));
    }
}
